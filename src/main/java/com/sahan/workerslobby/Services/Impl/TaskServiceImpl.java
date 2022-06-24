package com.sahan.workerslobby.Services.Impl;

import com.sahan.workerslobby.Entities.Task;
import com.sahan.workerslobby.Entities.TaskAndTicket;
import com.sahan.workerslobby.Entities.User;
import com.sahan.workerslobby.Exceptions.TaskNotFoundException;
import com.sahan.workerslobby.Exceptions.UserNotFoundException;
import com.sahan.workerslobby.Repositories.TaskAndTicketRepository;
import com.sahan.workerslobby.Repositories.TaskRepository;
import com.sahan.workerslobby.Services.TaskAndTicketService;
import com.sahan.workerslobby.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TaskServiceImpl implements TaskService
{
    private UserService userService;

    private TaskRepository taskRepository;

    private TaskAndTicketRepository taskAndTicketRepository;

    private TaskAndTicketService taskAndTicketService;

    @Autowired
    public TaskServiceImpl(UserService userService,
                           TaskRepository taskRepository,
                           TaskAndTicketRepository taskAndTicketRepository,
                           TaskAndTicketService taskAndTicketService)
    {
        this.userService = userService;
        this.taskRepository = taskRepository;
        this.taskAndTicketRepository = taskAndTicketRepository;
        this.taskAndTicketService = taskAndTicketService;
    }

    @Override
    public Task createTask(long engineerID)
    {
        User engineer = userService.findUserByUserID(engineerID);
        if (engineer == null)
        {
            throw new UsernameNotFoundException("NO ENGINEER FOUND BY GIVEN USERNAME");
        }
        Task newTask = new Task();
        TaskAndTicket taskAndTicket = new TaskAndTicket();
        newTask.setAssignedUser(engineer);
        taskAndTicket.setTask(newTask);
        taskRepository.save(newTask);
        taskAndTicketRepository.save(taskAndTicket);

        return newTask;
    }

    @Override
    public void deleteTask(long id) throws TaskNotFoundException
    {
        Task task = taskRepository.findById(id).orElse(null);
        taskAndTicketService.deleteTaskAndTicketByTask(task);
        deleteTaskByTaskID(id);
    }



    @Override
    public Task updateTask(long engineerId, long taskId, long newEngineerId) throws TaskNotFoundException, UserNotFoundException, IOException {
        User engineer = userService.findUserByUserID(engineerId);
        Task updateTask = taskRepository.findById(taskId).orElse(null);
        User newEngineer = userService.findUserByUserID(newEngineerId);
        TaskAndTicket taskAndTicket =  taskAndTicketRepository.findTaskAndTicketByTask(updateTask);
        if (engineer == null)
        {
            throw new UserNotFoundException("invalid user id");
        }
        if (updateTask == null)
        {
            throw new TaskNotFoundException("invalid task");
        }

        if (newEngineer == null)
        {
            throw new UserNotFoundException("invalid user id for new engineer");
        }
        if (taskAndTicket == null)
        {
            throw new IOException("Error Occurred cannot process");
        }
        updateTask.setAssignedUser(newEngineer);
        taskAndTicket.setTask(updateTask);
        taskRepository.save(updateTask);
        taskAndTicketRepository.save(taskAndTicket);
        return updateTask;
    }

    private void deleteTaskByTaskID(long id) throws TaskNotFoundException
    {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null)
            throw new TaskNotFoundException("invalid task Id");
    }
}
