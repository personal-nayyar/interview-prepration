package lld.hackathon.repository;

import lld.hackathon.entity.Problem;
import java.util.List;

public interface ProblemRepo {
    void addProblem(Problem problem);

    List<Problem> getAll();

    Problem getById(String id);

    List<Problem> getNProblemsByTag(Problem problem, int n);
}
