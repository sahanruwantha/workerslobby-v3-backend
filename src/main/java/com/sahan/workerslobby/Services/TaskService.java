package com.sahan.workerslobby.Services;

import com.sahan.workerslobby.Entities.Task;
import com.sahan.workerslobby.Exceptions.TaskNotFoundException;
import com.sahan.workerslobby.Exceptions.UserNameExistsException;
import com.sahan.workerslobby.Exceptions.UserNotFoundException;

import java.io.IOException;

public interface TaskService
{
    Task createTask(long id) throws UserNameExistsException;
    void deleteTask(long id) throws TaskNotFoundException;
    Task updateTask(long engineerId, long taskId, long newEngineerId) throws TaskNotFoundException, UserNotFoundException, IOException;

}
