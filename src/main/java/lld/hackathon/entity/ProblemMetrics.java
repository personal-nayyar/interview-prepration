package lld.hackathon.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class ProblemMetrics {
    private Problem problem;
    private Long likesCount; // number of likes
    private Long dislikesCount;
    private Long avgSolveTimeInMin;
    private List<User> solvedUsers;

    public ProblemMetrics(Problem problem) {
        this.problem = problem;
        this.likesCount = Long.valueOf(0);
        this.dislikesCount = Long.valueOf(0);
        this.avgSolveTimeInMin = Long.valueOf(0);
        this.solvedUsers = new ArrayList<>();
    }

    public void successSubmission(User user, Long timeTaken) {
        this.solvedUsers.add(user);
        this.avgSolveTimeInMin = (this.avgSolveTimeInMin + timeTaken) / this.solvedUsers.size();
    }

    public void changeLikesCount(int n) {
        this.likesCount = this.likesCount + n;
    }
}
