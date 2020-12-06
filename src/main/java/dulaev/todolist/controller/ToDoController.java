package dulaev.todolist.controller;

import dulaev.todolist.dao.ListTasksDao;
import dulaev.todolist.dao.TaskDao;
import dulaev.todolist.model.ToDoTask;
import dulaev.todolist.model.ToDoTasksList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ToDoController {
    private final ListTasksDao listTasksDao;
    private final TaskDao taskDao;

    @Autowired
    public ToDoController(ListTasksDao listTasksDao, TaskDao taskDao) {
        this.listTasksDao = listTasksDao;
        this.taskDao = taskDao;
    }

    @RequestMapping(value = "/toDoLists", method = RequestMethod.GET)
    public String getToDoLists(ModelMap modelMap) {
        modelMap.addAttribute("toDoLists", listTasksDao.getToDoLists());
        modelMap.addAttribute("newToDoList", new ToDoTasksList());
        return "index";
    }

    @RequestMapping(value = "/add-tasksList", method = RequestMethod.POST)
    public String addToDoList(@ModelAttribute("toDoList") ToDoTasksList toDoList) {
        listTasksDao.addTasksList(toDoList);
        return "redirect:/toDoLists";
    }

    @RequestMapping(value = "/toDoLists/{listId}", method = RequestMethod.GET)
    public String getListToDos(ModelMap map, @PathVariable int listId) {
        map.addAttribute("curList", listTasksDao.getTasksListById(listId));
        map.addAttribute("curTasks", listTasksDao.getTasksByListId(listId));
        map.addAttribute("task", new ToDoTask());
        return "toDoList";
    }

    @RequestMapping(value = "toDoLists/{listId}/add-todo", method = RequestMethod.POST)
    public String addToDo(@PathVariable int listId, @ModelAttribute("ToDo") ToDoTask toDoTask) {
        taskDao.addTask(listTasksDao.getTasksListById(listId), toDoTask);
        return "redirect:/toDoLists/{listId}";
    }

}
