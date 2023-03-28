package com.projeckt.s2e4.dto.user.request;

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
}
