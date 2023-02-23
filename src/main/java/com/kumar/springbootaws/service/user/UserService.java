package com.kumar.springbootaws.service.user;

import com.kumar.springbootaws.model.User;
import com.kumar.springbootaws.payload.SignUpInDto;
import com.kumar.springbootaws.payload.UserDto;

import java.util.List;

public interface UserService {
    SignUpInDto createUser(User user);
    UserDto getUserById(String userId);
    List<User> getAllUSer();

}
