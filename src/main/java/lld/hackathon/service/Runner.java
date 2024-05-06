package lld.hackathon.service;

import lld.hackathon.entity.Problem;
import lld.hackathon.entity.ProblemMetrics;
import lld.hackathon.entity.Tag;
import lld.hackathon.entity.User;
import lld.hackathon.enums.Department;
import lld.hackathon.enums.ProblemDifficulty;
import lld.hackathon.enums.SubmissionStatus;
import lld.hackathon.exceptions.UserNotFoundException;
import lld.hackathon.repository.ProblemMetricsRepo;
import lld.hackathon.repository.ProblemRepo;
import lld.hackathon.repository.SubmissionRepo;
import lld.hackathon.repository.UserRepo;
import lld.hackathon.repository.impl.ProblemMetricsRepoImpl;
import lld.hackathon.repository.impl.ProblemRepoImpl;
import lld.hackathon.repository.impl.SubmissionRepoImpl;
import lld.hackathon.repository.impl.UserRepoImpl;
import lld.hackathon.service.impl.HackathonServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws UserNotFoundException {
        UserRepo userRepo = new UserRepoImpl();
        ProblemRepo problemRepo = new ProblemRepoImpl();
        ProblemMetricsRepo problemMetricsRepo = new ProblemMetricsRepoImpl();
        SubmissionRepo submissionRepo = new SubmissionRepoImpl();
        HackathonService hackathonService = new HackathonServiceImpl(userRepo,
                problemRepo,
                problemMetricsRepo,
                submissionRepo);

        // Test the addUser() method
        User user = new User("1", "John Doe", Department.IT);
        hackathonService.addUser(user);

        // Test the addProblem() method
        Problem problem = new Problem("1", "Sample Problem", Collections.singletonList(new Tag("Algorithm")), ProblemDifficulty.EASY, 5L);
        hackathonService.addProblem(problem);

        // Test the solve() method
        SubmissionStatus status = SubmissionStatus.SUCCESS;
        Long timeTaken = 10L;
        hackathonService.solve(user, problem, status, timeTaken);

        // Test the fetchSolvedProblem() method
        List<Problem> solvedProblems = hackathonService.fetchSolvedProblems(user);
        System.out.println("Solved problem: ");
        solvedProblems.stream().forEach(System.out::println);

        // Test the fetchProblems(List<Tag> tags) method
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag("Algorithm")); // tag can be enum
        tags.add(new Tag("DATA_STRUCTURE"));
        List<ProblemMetrics> problems = hackathonService.fetchProblems(tags);
        for (ProblemMetrics fetchedProblem : problems) {
            System.out.println("Fetched problem: ");
            System.out.println(fetchedProblem.getProblem());
        }

        // Test the fetchProblemsByDifficulty() method
        List<ProblemMetrics> problemsByDifficulty = hackathonService.fetchProblems(ProblemDifficulty.EASY);
        for (ProblemMetrics fetchedProblem : problemsByDifficulty) {
            System.out.println("Fetched problem: ");
            System.out.println(fetchedProblem.getProblem());
        }

        // Test the getLeader() method
        User leader = hackathonService.getLeader();
        System.out.println("Leader: ");
        System.out.println(leader);

        // Test the getTopNProblems() method
        List<Problem> topNProblems = hackathonService.getTopNProblems(new Tag("Algorithm"), 3);
        System.out.println("Top N problems: ");
        topNProblems.stream().forEach(System.out::println);

        // Test the getNRecommendedProblems() method
        List<Problem> recommendedProblems = hackathonService.getNRecommendedProblems(problem, 3);
        System.out.println("Recommended problems: ");
        recommendedProblems.stream().forEach(System.out::println);

        // Test the likeProblem() method
        hackathonService.likeProblem(user, problem);

        // Test the dislikeProblem() method
        hackathonService.disLikeProblem(user, problem);

    }
}
