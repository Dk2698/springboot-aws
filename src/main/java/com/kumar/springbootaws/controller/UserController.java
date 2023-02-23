package com.kumar.springbootaws.controller;

import com.kumar.springbootaws.model.User;
import com.kumar.springbootaws.payload.SignUpInDto;
import com.kumar.springbootaws.payload.UserDto;
import com.kumar.springbootaws.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create") //@Valid
    public SignUpInDto addUser( @RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/get")
    public UserDto getUserById(@RequestParam String userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/list")
    public List<User> getAllUser() {
        return userService.getAllUSer();
    }
}
