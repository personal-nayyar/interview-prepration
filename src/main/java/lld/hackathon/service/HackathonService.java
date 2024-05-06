package lld.hackathon.service;

import lld.hackathon.entity.Problem;
import lld.hackathon.entity.ProblemMetrics;
import lld.hackathon.entity.Tag;
import lld.hackathon.entity.User;
import lld.hackathon.enums.ProblemDifficulty;
import lld.hackathon.enums.SubmissionStatus;
import lld.hackathon.exceptions.UserNotFoundException;

import java.util.List;

public interface HackathonService {
    void addUser(User user);

    void addProblem(Problem problem);

    List<Problem> solve(User user, Problem problem, SubmissionStatus status, Long timeTaken) throws UserNotFoundException;

    List<Problem> fetchSolvedProblems(User user) throws UserNotFoundException;

    User getLeader();

    List<Problem> getTopNProblems(Tag tag, int n);

    List<Problem> getNRecommendedProblems(Problem problem, int n);

    // Fetch problems based on difficulty level
    List<ProblemMetrics> fetchProblems(ProblemDifficulty difficulty);

    // Fetch problems based on list of tags
    List<ProblemMetrics> fetchProblems(List<Tag> tags);

    void likeProblem(User user, Problem problem);

    void disLikeProblem(User user, Problem problem);
}
