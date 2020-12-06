package dulaev.todolist.cofiguration;

import dulaev.todolist.dao.ListTasksDao;
import dulaev.todolist.dao.TaskDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InMemoryDaoConfig {
    @Bean
    public ListTasksDao listTasksDao() {
        return new ListTasksDao();
    }

    @Bean
    public TaskDao taskDao() {
        return new TaskDao();
    }
}
