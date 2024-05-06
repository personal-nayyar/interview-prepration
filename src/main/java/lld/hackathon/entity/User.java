package lld.hackathon.entity;

import lld.hackathon.enums.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String id; // refer to the employeeId
    private String name;
    private Department department;
    private Long score;

    public User(String id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.score = Long.valueOf(0);
    }
}
