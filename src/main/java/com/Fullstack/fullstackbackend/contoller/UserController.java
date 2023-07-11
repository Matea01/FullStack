package com.Fullstack.fullstackbackend.contoller;

import com.Fullstack.fullstackbackend.exception.UserNotFoundException;
import com.Fullstack.fullstackbackend.model.User;
import com.Fullstack.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  // This means that this class is a Controller
//@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/api/user")
    User newUser(@RequestBody User newUser) {
    return userRepo.save(newUser);
    }

    @GetMapping("/api/users")
    List<User> gelAllUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/api/user/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/api/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepo.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepo.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/api/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepo.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepo.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }

}
