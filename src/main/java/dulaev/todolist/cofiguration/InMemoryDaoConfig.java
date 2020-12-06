package dulaev.todolist.cofiguration;

import dulaev.todolist.dao.ListTasksDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InMemoryDaoConfig {
    @Bean
    public ListTasksDao listTasksDao() {
        return new ListTasksDao();
    }
}
