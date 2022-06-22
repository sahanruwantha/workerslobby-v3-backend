package com.sahan.workerslobby.Controllers;

import com.sahan.workerslobby.Entities.User;
import com.sahan.workerslobby.Exceptions.EmailExistsException;
import com.sahan.workerslobby.Exceptions.ExceptionHandling;
import com.sahan.workerslobby.Exceptions.UserNameExistsException;
import com.sahan.workerslobby.Exceptions.UserNotFoundException;
import com.sahan.workerslobby.Services.UserService;
import com.sahan.workerslobby.Utils.JWTTokenProvider;
import com.sahan.workerslobby.Utils.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import static com.sahan.workerslobby.Constants.SecurityConstants.JWT_TOKEN_HEADER;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping(path = { "/","/user"})
public class UserController extends ExceptionHandling
{
    private UserService userService;
    private AuthenticationManager authenticationManager;
    private JWTTokenProvider jwtTokenProvider;

    @Autowired
    public UserController(UserService userService,
                          AuthenticationManager authenticationManager,
                          JWTTokenProvider jwtTokenProvider)
    {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
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

    @PostMapping("/log-in")
    public ResponseEntity<User> login(@RequestBody User user)
    {
        authenticate(user.getUserName(), user.getPassword());
        User loginUser = userService.findByUserName(user.getUserName());
        UserPrincipal userPrincipal = new UserPrincipal(loginUser);
        HttpHeaders jwtHeader = getJwtHeader(userPrincipal);
        return new ResponseEntity<>(loginUser, jwtHeader, OK);
    }

    private HttpHeaders getJwtHeader(UserPrincipal user)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add(JWT_TOKEN_HEADER, jwtTokenProvider.generateJwtToken(user));
        return headers;
    }

    private void authenticate(String userName, String password)
    {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
    }
}
