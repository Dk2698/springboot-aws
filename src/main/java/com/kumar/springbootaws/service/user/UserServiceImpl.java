package com.kumar.springbootaws.service.user;

import com.kumar.springbootaws.exception.DBExceptionOccur;
import com.kumar.springbootaws.exception.ResourceNotFoundException;
import com.kumar.springbootaws.model.User;
import com.kumar.springbootaws.payload.ApiResponse;
import com.kumar.springbootaws.payload.JwtAuthResponse;
import com.kumar.springbootaws.payload.SignUpInDto;
import com.kumar.springbootaws.payload.UserDto;
import com.kumar.springbootaws.repository.UserRepository;
import com.kumar.springbootaws.utilty.Constant;
import com.kumar.springbootaws.utilty.GenerateUid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public SignUpInDto createUser(User user) {
        ApiResponse apiResponse = new ApiResponse();
        SignUpInDto signUpInDto = new SignUpInDto();
        String uniqueId = GenerateUid.getUniqueId(Constant.USER_MODEL);
        user.setId(uniqueId);
        System.out.println(user.getPassword());
//        user.setPassword(); // set encrypt password
//        List<GoalDto> byDefaultGoallist = new ArrayList<>();
//        if (user.getLocation() == null || user.getLocation().isEmpty()) {
//            user.setLocation("");
//        }
//        by default passing value
//        if (user.getIsCurrentlyStaffed() == null) {
//            user.setIsCurrentlyStaffed("");
//            user.setAccountName("");
//        }
        try {
            userRepository.save(user);
            apiResponse.setMessage("user created!!");
            apiResponse.setSuccess(true);
//            JwtAuthRequest jwtAuthRequest = new JwtAuthRequest(user.getUsername(), passwordWithoutEncrypt);
//            ResponseEntity<JwtAuthResponse> createToken = authController.createToken(jwtAuthRequest);
//            System.out.println(createToken.toString());
//            signUpInDto.setSignup(apiResponse);
//            signUpInDto.setSignin(createToken.getBody());
            signUpInDto.setSignup(apiResponse);
            signUpInDto.setSignin(new JwtAuthResponse("12222","22222"));
            return signUpInDto;
        } catch (DuplicateKeyException e) {
            apiResponse.setMessage("user is already registered!!!!");
            apiResponse.setSuccess(false);
            signUpInDto.setSignup(apiResponse);
            signUpInDto.setSignin(null);
            return signUpInDto;
        } catch (Exception e) {
            apiResponse.setMessage("Error!!!!");
            apiResponse.setSuccess(false);
            signUpInDto.setSignup(apiResponse);
            signUpInDto.setSignin(null);
            return signUpInDto;
        }

    }

    @Override
    public UserDto getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("UserId", "Id", userId));
        return convertUserToUserDto(user);
    }

    @Override
    public List<User> getAllUSer() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new DBExceptionOccur("Error Occurred During The Operation Find !!");
        }
    }

    public UserDto convertUserToUserDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
//        userDto.setTotalGoal(user.getCurrentGoal().size());
        return userDto;
    }
}
