package com.projekt.s2e4.service.validation.user;

import com.projekt.s2e4.dto.user.request.UserRegisterRequest;
import com.projekt.s2e4.entity.User;
import com.projekt.s2e4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRegisterValidation {
    private final UserRepository userRepository;

    public boolean validation(UserRegisterRequest request) {
        return userNameValidation(request.getUserName());
    }

    private boolean userNameValidation(String userName) {
        boolean isLengthUnderEight = userName.length() <= 8;
        boolean isOnlyEnglish = userName.equals("^[a-zA-Z]*$");


        return isLengthUnderEight & isOnlyEnglish;
    }

    private boolean isNotDuplicateUserName(String userName) {
        List<String> userNames = getUsernamesFromRepository();

        for (String name : userNames) {
            if (name.equals(userName)) return false;
        }
        return true;
    }

    private List<String> getUsernamesFromRepository() {
        List<User> users = userRepository.getAllUserName();

        List<String> userNames = new LinkedList<>();

        users.forEach(
                user -> userNames.add(user.getUserName())
        );

        return userNames;
    }

}
