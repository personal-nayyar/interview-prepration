package lld.hackathon.repository;

import lld.hackathon.entity.Submission;
import lld.hackathon.entity.User;

import java.util.List;

public interface SubmissionRepo {
    public List<Submission> findByUser(User user);

    public void addSubmission(User user, Submission submission);
}
