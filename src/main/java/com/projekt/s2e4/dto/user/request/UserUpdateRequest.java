package com.projekt.s2e4.dto.user.request;

import com.projekt.s2e4.model.Grade;
import lombok.Data;

@Data
public class UserUpdateRequest {
    private String userName;
    private String loginId;
    private String loginPassword;
    private Long money;
    private Grade grade;
}