package com.sahan.workerslobby.Services.Impl;

import com.sahan.workerslobby.Entities.Task;
import com.sahan.workerslobby.Entities.TaskAndTicket;
import com.sahan.workerslobby.Services.TaskAndTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskAndTicketImpl implements TaskAndTicketService
{
    private com.sahan.workerslobby.Repositories.TaskAndTicketRepository taskAndTicketRepository;

    @Autowired
    public TaskAndTicketImpl(com.sahan.workerslobby.Repositories.TaskAndTicketRepository taskAndTicketRepository) {
        this.taskAndTicketRepository = taskAndTicketRepository;
    }

    @Override
    public TaskAndTicket findTaskAndTicketByTaskID(long Id)
    {
//        return taskAndTicketRepository.findTaskAndTicketByTaskID(Id);
        return null;
    }

    @Override
    public TaskAndTicket findTaskAndTicketByTicketID(long Id) {
        return null;
    }


    @Override
    public void deleteTaskAndTicketByTask(Task task)
    {
        taskAndTicketRepository.deleteTaskAndTicketByTask(task);
    }

    @Override
    public Task findTaskAndTicketByTask(Task task)
    {
        return findTaskAndTicketByTask(task);
    }

}
