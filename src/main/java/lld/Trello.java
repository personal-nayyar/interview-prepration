package lld;

import java.util.List;

// like Jira
public class Trello {
}

class UserJira{}

enum ProjectPrivacy{
    PRIVATE,
    PUBLIC,
}
class BoardProject{
    String id;
    String url;
    ProjectPrivacy privacy;
    List<UserJira> members;
}

class Sprint{
    String id;
    BoardProject board;
    String name;
    String description;
    String startDate;
    String endDate;
    String state;
}

enum TaskState{
    TODO,
    IN_PROGRESS,
    HOLD,
    DONE
}

enum TaskType{}

class Task{
    String id;
    String description;
    TaskState state;
    UserJira assignedTo;

    Sprint sprint;
}

class SprintManager{
    Sprint createSprint(Sprint sprint){
        return null;
    }

    Sprint addTaskToSprint(Sprint sprint, Task task){
        return null;
    }
}

class TaskManager{
    // createTask
    Task create(Task task){
        return null;
    }

    Task assingTask(Task task, UserJira user){
        return null;
    }

    Task addSprint(Task task, Sprint sprint){
        return null;
    }

    Task changeSprint(Task task, Sprint sprint){
        return null;
    }
}