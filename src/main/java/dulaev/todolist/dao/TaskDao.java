package dulaev.todolist.dao;

import dulaev.todolist.model.ToDoTask;
import dulaev.todolist.model.ToDoTasksList;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskDao {
    private final AtomicInteger curId = new AtomicInteger(0);
    private final List<ToDoTask> tasks = new CopyOnWriteArrayList<>();

    public void addTask(ToDoTasksList list, ToDoTask task) {
        int id = curId.getAndIncrement();
        task.setId(id);
        task.setCompleted(false);
        list.addTask(task);
        tasks.add(task);
    }

    public void completeTask(int id) {
        tasks.get(id).setCompleted(true);
    }

    public ToDoTask getTask(int id) {
        return tasks.get(id);
    }


}
