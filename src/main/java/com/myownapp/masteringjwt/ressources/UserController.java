package com.myownapp.masteringjwt.ressources;

import com.myownapp.masteringjwt.exceptions.UserNotFoundException;
import com.myownapp.masteringjwt.exceptions.UserNotFoundExceptionToDelete;
import com.myownapp.masteringjwt.repositories.UserRepository;
import com.myownapp.masteringjwt.services.UserService;
import com.myownapp.masteringjwt.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = "/users" )
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users" )
    public List<User> displayAllUsers(){
        return userService.displayAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET , path = "/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return userService.retriveUser(id);
    }

    @RequestMapping(method = RequestMethod.GET , path = "/users/firstname/{firstname}")
    public List<User> retrieveUserByFirstname(@PathVariable String firstname){
        return userService.retrieveUserByFirstname(firstname);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/users/{id}" )
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/users" )
    public void deleteAllUsers(){
        userService.deleteAllUsers();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/users/{id}" )
    public User updateUser(@RequestBody User user, @PathVariable int id){
        return userService.updateUser(user,id);

    }

}
