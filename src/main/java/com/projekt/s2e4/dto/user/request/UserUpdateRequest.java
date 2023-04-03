package com.projekt.s2e4.dto.user.request;

import com.projekt.s2e4.model.Grade;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserUpdateRequest {
    private String userName;
    private String loginId;
    private String loginPassword;
    private Long money;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Grade grade;
}