package dulaev.todolist.dao;

import dulaev.todolist.model.ToDoTasksList;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class ListTasksDao {
    private final AtomicInteger curId = new AtomicInteger();
    private final LinkedHashMap<Integer, ToDoTasksList> idListMap = new LinkedHashMap<>();

    public void addTasksList(ToDoTasksList list) {
        int id = curId.getAndIncrement();
        list.setId(id);
        idListMap.put(id, list);
    }

    public List<ToDoTasksList> getToDoLists() {
        return new ArrayList<>(idListMap.values());
    }

}
