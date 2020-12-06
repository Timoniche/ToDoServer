package dulaev.todolist.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ToDoTasksList {
    private int id;
    private String name;
    private List<ToDoTask> tasks = new ArrayList<ToDoTask>();

    public void addTask(ToDoTask task) {
        tasks.add(task);
    }
}
