package com.myownapp.masteringjwt.services;

import com.myownapp.masteringjwt.exceptions.UserNotFoundException;
import com.myownapp.masteringjwt.exceptions.UserNotFoundExceptionToDelete;
import com.myownapp.masteringjwt.repositories.UserRepository;
import com.myownapp.masteringjwt.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User retriveUser(int id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            throw new UserNotFoundException("userid to get was : "+id);
        }
        return user.get();
    }

    public List<User> retrieveUserByFirstname(String firstname){
        String Firstname = firstname.trim();
        Optional<List<User>> users = userRepository.findByFirstname(Firstname);
        if(!users.isPresent()){
            throw new UserNotFoundException("user by firstname to get was : "+firstname);
        }

        return users.get();
    }

    public void deleteUser(int id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            throw new UserNotFoundExceptionToDelete("userid to delete was : "+id);
        }

        userRepository.deleteById(id);
    }

    public List<User> displayAllUsers(){
        List<User> users = userRepository.findByOrderById();
        return users;
    }

    public ResponseEntity<User> createUser(@Valid @RequestBody User user){

        User user1 = userRepository.save(user);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    public void deleteAllUsers(){
        userRepository.deleteAll();
    }

    public User updateUser(User user, int id){
        User user1 = retriveUser(id);
        if(user.getFirstname() != null){user1.setFirstname(user.getFirstname());}
        else {user1.setFirstname(user1.getFirstname());}

        if(user.getLastname() != null){user1.setLastname(user.getLastname());}
        else {user1.setLastname(user1.getLastname());}
        return userRepository.save(user1);
    }

}
