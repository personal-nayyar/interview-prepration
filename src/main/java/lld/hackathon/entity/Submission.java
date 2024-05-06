package lld.hackathon.entity;

import lld.hackathon.enums.SubmissionStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class Submission {
    private User user;
    private Problem problem;
    private SubmissionStatus status;

    public Submission(User user, Problem problem, SubmissionStatus status) {
        this.user = user;
        this.problem = problem;
        this.status = status;
    }
}
