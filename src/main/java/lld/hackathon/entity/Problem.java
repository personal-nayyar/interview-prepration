package lld.hackathon.entity;

import lld.hackathon.enums.ProblemDifficulty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class Problem {
    private String id;
    private String description;
    private List<lld.hackathon.entity.Tag> tags;
    private ProblemDifficulty difficultyLevel;
    private Long score;

    public Problem(String id, String description, List<Tag> tags, ProblemDifficulty difficultyLevel, Long score) {
        // code to auto-generate id
        this.id = id;
        this.description = description;
        this.tags = tags;
        this.difficultyLevel = difficultyLevel;
        this.score = score;
    }
}
