package com.projekt.s2e4.service.validation.user;

import com.projekt.s2e4.dto.user.request.UserRegisterRequest;
import com.projekt.s2e4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRegisterValidation {
    private final UserRepository userRepository;
    public boolean validation(UserRegisterRequest request) {


    }

    private boolean userNameValidation(String userName) {
        boolean isLengthUnderEight = userName.length() <= 8;
        boolean isOnlyEnglish = userName.equals("^[a-zA-Z]*$");
        boolean isNotDuplicateOtherUser = userName.
    }

}
