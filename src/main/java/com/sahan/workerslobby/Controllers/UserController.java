package com.sahan.workerslobby.Controllers;

import com.sahan.workerslobby.Entities.User;
import com.sahan.workerslobby.Exceptions.EmailExistsException;
import com.sahan.workerslobby.Exceptions.ExceptionHandling;
import com.sahan.workerslobby.Exceptions.UserNameExistsException;
import com.sahan.workerslobby.Exceptions.UserNotFoundException;
import com.sahan.workerslobby.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping(path = { "/","/user"})
public class UserController extends ExceptionHandling
{
    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String showUser() throws EmailExistsException {
        throw new EmailExistsException("boom chaka laka");
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) throws UserNameExistsException, EmailExistsException, UserNotFoundException
    {
        log.info(String.valueOf(user));
       User newUser =  userService.register(user.getFirstName(), user.getLastName(), user.getUserName(), user.getEmail());
       return new ResponseEntity<>(newUser, OK);
    }
}
