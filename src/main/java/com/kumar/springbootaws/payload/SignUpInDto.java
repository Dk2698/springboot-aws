package com.kumar.springbootaws.payload;

import com.kumar.springbootaws.payload.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpInDto {

    private ApiResponse signup;
    private JwtAuthResponse signin;

}
