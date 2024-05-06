package lld.hackathon.repository.impl;

import lld.hackathon.entity.Submission;
import lld.hackathon.entity.User;
import lld.hackathon.repository.SubmissionRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubmissionRepoImpl implements SubmissionRepo {
    private final HashMap<User, List<Submission>> submissionHashMap;

    public SubmissionRepoImpl() {
        this.submissionHashMap = new HashMap<>();
    }

    @Override
    public List<Submission> findByUser(User user) {
        List<Submission> submissionList = new ArrayList<>();

        if( submissionHashMap.containsKey(user))
            submissionList = submissionHashMap.get(user);

        return submissionList;
    }

    @Override
    public void addSubmission(User user, Submission submission) {
        List<Submission> submissionList = new ArrayList<>();

        if( submissionHashMap.containsKey(user))
            submissionList = submissionHashMap.get(user);

        if( submissionList.contains(submission))
        {
            submissionList.remove(submission);
            submissionList.add(submission);
        }
        else
            submissionList.add(submission);

        submissionHashMap.put(user, submissionList);
    }
}
