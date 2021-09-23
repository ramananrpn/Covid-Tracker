package com.example.java_sample.controller;

import com.example.java_sample.dto.request.UserRegisterRequestDto;
import com.example.java_sample.dto.request.UserSelfAssesmentRequestDto;
import com.example.java_sample.dto.response.UserResgisterResponseDto;
import com.example.java_sample.dto.response.UserSelfAssessmentResponseDto;
import com.example.java_sample.entity.User;
import com.example.java_sample.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/user/register")
    public UserResgisterResponseDto createUser(@Validated @RequestBody UserRegisterRequestDto userRegisterRequestDto) {
        User user = userService.registerUser(userRegisterRequestDto);

        return UserResgisterResponseDto.builder().userId(user.getId()).build();
    }

    @PostMapping("/api/user/assessment")
    public UserSelfAssessmentResponseDto selfAssessment(@Validated @RequestBody UserSelfAssesmentRequestDto userSelfAssesmentRequestDto) {
        if(userService.isValidUser(userSelfAssesmentRequestDto.getUserId())){
            return UserSelfAssessmentResponseDto.builder()
                    .riskPercentage(userService.analyseRiskPercentage(userSelfAssesmentRequestDto))
                    .build();
        }
        return UserSelfAssessmentResponseDto.builder().build();
    }

}
