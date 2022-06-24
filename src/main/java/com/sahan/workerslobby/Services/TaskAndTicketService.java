package com.sahan.workerslobby.Services;

import com.sahan.workerslobby.Entities.Task;
import com.sahan.workerslobby.Entities.TaskAndTicket;

public interface TaskAndTicketService
{
    TaskAndTicket findTaskAndTicketByTaskID(long Id);
    TaskAndTicket findTaskAndTicketByTicketID(long Id);

    void deleteTaskAndTicketByTask(Task task);

    Task findTaskAndTicketByTask(Task task);
}
