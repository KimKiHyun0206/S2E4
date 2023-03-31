package com.projekt.s2e4.entity;

import com.projekt.s2e4.model.Grade;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "user")
@Getter
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "login_id", unique = true)
    private String loginId;

    @Column(name = "login_password")
    private String loginPassword;

    @Column(name = "money")
    private Long money;

    @Column(name = "grade")
    @Enumerated(EnumType.ORDINAL)
    private Grade grade;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public User(String userName, String loginId, String loginPassword, Long money, Grade grade) {
        this.userName = userName;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.money = money;
        this.grade = grade;
    }

    public void update(String userName, String loginId, String loginPassword, Long money, Grade grade){
        this.userName = userName;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.money = money;
        this.grade = grade;
    }
}
