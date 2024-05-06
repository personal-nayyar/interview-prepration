package lld.hackathon.repository;


import lld.hackathon.entity.Problem;
import lld.hackathon.entity.ProblemMetrics;

import java.util.List;

public interface ProblemMetricsRepo {
    void addOrUpdateProblemMetrics(ProblemMetrics problemMetrics);

    ProblemMetrics fetchMetrics(Problem problem);

    List<ProblemMetrics> getAll();
}
