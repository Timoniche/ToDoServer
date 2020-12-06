package dulaev.todolist.controller;

import dulaev.todolist.dao.ListTasksDao;
import dulaev.todolist.model.ToDoTasksList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ToDoListsController {
    private final ListTasksDao listTasksDao;

    public ToDoListsController(ListTasksDao listTasksDao) {
        this.listTasksDao = listTasksDao;
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
}
