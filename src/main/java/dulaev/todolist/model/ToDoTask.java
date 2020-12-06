package dulaev.todolist.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDoTask {
    private int id;
    private String name;
    private boolean isCompleted;
}
