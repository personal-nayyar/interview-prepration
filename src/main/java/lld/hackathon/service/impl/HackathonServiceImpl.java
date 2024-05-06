package lld.hackathon.service.impl;

import lld.hackathon.entity.*;
import lld.hackathon.enums.ProblemDifficulty;
import lld.hackathon.enums.SubmissionStatus;
import lld.hackathon.exceptions.UserNotFoundException;
import lld.hackathon.repository.ProblemMetricsRepo;
import lld.hackathon.repository.ProblemRepo;
import lld.hackathon.repository.SubmissionRepo;
import lld.hackathon.repository.UserRepo;
import lld.hackathon.service.HackathonService;
import lld.hackathon.constants.GlobalConstants;
import lombok.NonNull;

import java.util.*;

public class HackathonServiceImpl implements HackathonService {
    private final UserRepo userRepository;
    private final ProblemRepo problemRepository;
    private final ProblemMetricsRepo problemMetricsRepository;
    private final SubmissionRepo submissionRepository;

    public HackathonServiceImpl(UserRepo userRepository,
                                ProblemRepo problemRepository,
                                ProblemMetricsRepo problemMetricsRepository,
                                SubmissionRepo submissionRepository) {
        this.userRepository = userRepository;
        this.problemRepository = problemRepository;
        this.problemMetricsRepository = problemMetricsRepository;
        this.submissionRepository = submissionRepository;
    }


    @Override
    public void addUser(@NonNull User user) {
        userRepository.addOrUpdateUser(user);
    }

    @Override
    public void addProblem(@NonNull Problem problem) {
        // Create new problem metrics
        ProblemMetrics problemMetrics = new ProblemMetrics(problem);

        problemRepository.addProblem(problem);
        problemMetricsRepository.addOrUpdateProblemMetrics(problemMetrics);
    }

    @Override
    public List<Problem> solve(User user, Problem problem, SubmissionStatus status, Long timeTaken) throws UserNotFoundException {
        if(Objects.isNull(userRepository.findById(user.getId())))
            throw new UserNotFoundException(user.getId());

        List<Problem> relevantProblems = new ArrayList<>();
        Submission submission = new Submission(user, problem, status);
        submissionRepository.addSubmission(user, submission);

        if(SubmissionStatus.SUCCESS.equals(status)) {
            // Add problem metrics
            ProblemMetrics problemMetrics = problemMetricsRepository.fetchMetrics(problem);

            if(problemMetrics == null)
                problemMetrics = new ProblemMetrics(problem);

            problemMetrics.successSubmission(user, timeTaken);

            problemMetricsRepository.addOrUpdateProblemMetrics(problemMetrics);

            user.setScore(user.getScore() + getScore(problem, timeTaken));

            // Update user score
            userRepository.addOrUpdateUser(user);

            // Get relevant problems
            relevantProblems = getNRecommendedProblems(problem, 3);
        }

        return relevantProblems;
    }

    @Override
    public List<Problem> fetchSolvedProblems(User user) throws UserNotFoundException {
        if(Objects.isNull(userRepository.findById(user.getId())))
            throw new UserNotFoundException(user.getId());

        List<Problem> solvedProblems = new ArrayList<>();

        List<Submission> submissionList = submissionRepository.findByUser(user);

        for(Submission submission : submissionList) {
            if(SubmissionStatus.SUCCESS.equals(submission.getStatus())) {
                solvedProblems.add(submission.getProblem());
            }
        }

        return solvedProblems;
    }

    @Override
    public User getLeader() {
        User leader = null ;
        Long topScore = Long.valueOf(0);

        for(User user: userRepository.getAllUsers()) {
            if(user.getScore() > topScore) {
                topScore = user.getScore();
                leader = user;
            }
        }

        return leader;
    }

    @Override
    public List<Problem> getTopNProblems(Tag tag, int n) {
        // Fetch top n problems
        PriorityQueue<ProblemMetrics> minHeap = new PriorityQueue<>(n, (a, b) -> b.getLikesCount().compareTo(a.getLikesCount()));

        List<ProblemMetrics> problemsByTag = null;
        if (tag != null) {
            problemsByTag = fetchProblems(Collections.singletonList(tag));
        }else{
            problemsByTag = problemMetricsRepository.getAll();
        }

        // Add all problem metrics to the min heap
        for (ProblemMetrics problemMetrics : problemsByTag) {
            minHeap.offer(problemMetrics);
            if (minHeap.size() > n) {
                minHeap.poll();
            }
        }

        // Retrieve top N problems in descending order of likes
        List<Problem> topNProblems = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            topNProblems.add(minHeap.poll().getProblem());
        }
        return topNProblems;
    }

    @Override
    public List<Problem> getNRecommendedProblems(Problem problem, int n) {
        List<Problem> problemList = problemRepository.getNProblemsByTag(problem, n);

        return problemList;
    }

    @Override
    public List<ProblemMetrics> fetchProblems(ProblemDifficulty difficulty) {
        List<ProblemMetrics> problemMetricsList = new ArrayList<>();

        for(Problem problem : problemRepository.getAll()) {
            if(problem.getDifficultyLevel().equals(difficulty)) {
                problemMetricsList.add(problemMetricsRepository.fetchMetrics(problem));
            }
        }
        // sort by score
        problemMetricsList.sort((a, b) -> b.getProblem().getScore().compareTo(a.getProblem().getScore()));
        return problemMetricsList;
    }

    @Override
    public List<ProblemMetrics> fetchProblems(List<Tag> tags) {
        // generate java code to fetch problems based on tags
        List<ProblemMetrics> problemMetricsList = new ArrayList<>();

        for(Problem problem : problemRepository.getAll()) {
            if(problem.getTags().stream().anyMatch(tags::contains)) {
                problemMetricsList.add(problemMetricsRepository.fetchMetrics(problem));
            }
        }
        problemMetricsList.sort((a, b) -> b.getProblem().getScore().compareTo(a.getProblem().getScore()));
        return problemMetricsList;
    }

    @Override
    public void likeProblem(User user, Problem problem) {
        Problem currProblem = problemRepository.getById(problem.getId());

        if(currProblem == null)
            return ;

        ProblemMetrics problemMetrics = problemMetricsRepository.fetchMetrics(currProblem);
        problemMetrics.changeLikesCount(GlobalConstants.LIKE_ONE);
    }


    @Override
    public void disLikeProblem(User user, Problem problem) {
        Problem currProblem = problemRepository.getById(problem.getId());

        if(currProblem == null)
            return ;

        ProblemMetrics problemMetrics = problemMetricsRepository.fetchMetrics(currProblem);
        problemMetrics.changeLikesCount(GlobalConstants.DISLIKE_ONE);
    }


    private Long getScore(Problem problem, Long timeTaken) {
        if(timeTaken <= 5)
            return problem.getScore();

        else if(timeTaken <= 30)
            return (long) problem.getScore() * (100 - timeTaken) / 100;
        else
            return (long) (problem.getScore() * 0.5);
    }
}
