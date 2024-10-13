package com.nhnacademy.minidooray.repository;

import com.nhnacademy.minidooray.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserIdAndPassword(String userId, String password);
//    Optional<User> findByUserId(String userId);
    User findByUserId(String userId);

}
