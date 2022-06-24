package com.sahan.workerslobby.Repositories;

import com.sahan.workerslobby.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>
{
    void deleteTaskByTaskID(long id);
}
