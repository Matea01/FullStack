package com.Fullstack.fullstackbackend.contoller;

import com.Fullstack.fullstackbackend.model.User;
import com.Fullstack.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // This means that this class is a Controller
//@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
    return userRepo.save(newUser);
    }

    @GetMapping("users")
    List<User> gelAllUsers(){
        return userRepo.findAll();
    }


}
