package com.sahan.workerslobby.Services;

import com.sahan.workerslobby.Entities.User;
import com.sahan.workerslobby.Exceptions.EmailExistsException;
import com.sahan.workerslobby.Exceptions.UserNameExistsException;
import com.sahan.workerslobby.Exceptions.UserNotFoundException;

import java.util.List;

public interface UserService
{
    User register(String firstName,
                  String lastName,
                  String username,
                  String email) throws UserNameExistsException, EmailExistsException, UserNotFoundException;

    List<User> getUsers();

    User findByUserName(String username);

    User findUserByEmail(String email);
}
