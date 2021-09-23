package com.example.java_sample.service;

import com.example.java_sample.dto.request.UserRegisterRequestDto;
import com.example.java_sample.dto.request.UserSelfAssesmentRequestDto;
import com.example.java_sample.entity.User;
import com.example.java_sample.exception.ExistingUserException;
import com.example.java_sample.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(UserRegisterRequestDto userRegisterRequestDto) {
        User user = User.builder()
                .name(userRegisterRequestDto.getName())
                .phoneNumber(userRegisterRequestDto.getPhoneNumber())
                .pinCode(userRegisterRequestDto.getPinCode())
                .build();

        // check if user already exists
        if (isExistingUser(user)) {
            throw new ExistingUserException();
        }

        return userRepository.save(user);
    }

    public User registerAdmin(UserRegisterRequestDto userRegisterRequestDto) {
        User user = User.builder()
                .name(userRegisterRequestDto.getName())
                .phoneNumber(userRegisterRequestDto.getPhoneNumber())
                .pinCode(userRegisterRequestDto.getPinCode())
                .build();

        // check if user already exists
        if (isExistingUser(user)) {
            throw new ExistingUserException();
        }

        return userRepository.save(user);
    }


    public int analyseRiskPercentage(UserSelfAssesmentRequestDto userSelfAssesmentRequestDto) {
        int percentage = 0;

        if (userSelfAssesmentRequestDto.getSymptoms().size() < 3) {
            percentage = userSelfAssesmentRequestDto.getSymptoms().size() * 2;
        } else {
            percentage = 75;
        }

        if (userSelfAssesmentRequestDto.isContactWithCovidPatient()) {
            percentage+= 10;
        }
        if (userSelfAssesmentRequestDto.isTravelHistory()) {
            percentage+= 10;
        }

        return percentage;
    }

    private boolean isExistingUser(User user) {
        return userRepository.findByPhoneNumber(user.getPhoneNumber()).isPresent();
    }

    public boolean isValidUser(Long useId) {
        return userRepository.findById(useId).isPresent();
    }
}
