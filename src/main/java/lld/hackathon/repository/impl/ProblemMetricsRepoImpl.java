package lld.hackathon.repository.impl;

import lld.hackathon.entity.Problem;
import lld.hackathon.entity.ProblemMetrics;
import lld.hackathon.repository.ProblemMetricsRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProblemMetricsRepoImpl implements ProblemMetricsRepo {
    private final HashMap<Problem, ProblemMetrics> problemMetricsHashMap;

    public ProblemMetricsRepoImpl() {
        this.problemMetricsHashMap = new HashMap<>();
    }

    @Override
    public void addOrUpdateProblemMetrics(ProblemMetrics problemMetrics) {
        problemMetricsHashMap.put(problemMetrics.getProblem(), problemMetrics);
    }

    @Override
    public ProblemMetrics fetchMetrics(Problem problem) {
        if(problemMetricsHashMap.containsKey(problem))
            return problemMetricsHashMap.get(problem);

        return null;
    }

    @Override
    public List<ProblemMetrics> getAll() {
        return new ArrayList<>();
    }
}
