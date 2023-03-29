package com.projekt.s2e4.repository;

import com.projekt.s2e4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
