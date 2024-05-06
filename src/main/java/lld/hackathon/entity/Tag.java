package lld.hackathon.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Tag {
    private String name;

    public Tag(String name) {
        this.name = name;
    }
}
