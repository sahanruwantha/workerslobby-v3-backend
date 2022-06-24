package com.sahan.workerslobby.Repositories;

import com.sahan.workerslobby.Entities.Task;
import com.sahan.workerslobby.Entities.TaskAndTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskAndTicketRepository extends JpaRepository<TaskAndTicket, Long>
{
    TaskAndTicket findTaskAndTicketByTask(Task task);

    void deleteTaskAndTicketByTask(Task task);

//    @Query("delete from TaskAndTicket where TaskAndTicket.task.taskID = :taskId")
//    void deleteTaskAndTicketByTaskID(@Param("taskId")long taskId);
}
