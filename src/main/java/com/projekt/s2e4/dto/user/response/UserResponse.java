package com.projekt.s2e4.dto.user.response;

import com.projekt.s2e4.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.projekt.s2e4.model.Grade;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String userName;
    private String loginId;
    private String loginPassword;
    private Long money;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    protected Grade grade;


    public static UserResponse from(User user){
        return new UserResponse(
                user.getId(),
                user.getUserName(),
                user.getLoginId(),
                user.getLoginPassword(),
                user.getMoney(),
                user.getCreatedAt(),
                user.getModifiedAt(),
                user.getGrade()
        );
    }
}