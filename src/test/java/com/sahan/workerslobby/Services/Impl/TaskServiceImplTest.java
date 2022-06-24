package com.sahan.workerslobby.Services.Impl;

import com.sahan.workerslobby.Exceptions.UserNameExistsException;
import com.sahan.workerslobby.Services.TaskService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskServiceImplTest
{
    private TaskService taskService;

    @Autowired
    public TaskServiceImplTest(TaskService taskService) {
        this.taskService = taskService;
    }

    @Test
    void createTask() throws UserNameExistsException {
        taskService.createTask(1);
    }
}