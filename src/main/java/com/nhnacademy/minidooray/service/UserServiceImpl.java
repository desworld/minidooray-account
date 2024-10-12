package com.nhnacademy.minidooray.service;

import com.nhnacademy.minidooray.dto.UserRegisterRequest;
import com.nhnacademy.minidooray.entity.User;
import com.nhnacademy.minidooray.entity.UserStatus;
import com.nhnacademy.minidooray.exception.UserNotFoundException;
import com.nhnacademy.minidooray.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void registerUser(UserRegisterRequest user) {
        User savedUser = new User(user.getId(), user. getPassword(), user.getEmail());

        userRepository.save(savedUser);
    }

    @Override
    public User doLogin(String userId, String password) {
        Optional<User> user = userRepository.findByUserIdAndPassword(userId, password);
        if(user.isEmpty()) {
            throw new UserNotFoundException();
        }
        return user.get();
    }

    @Override
    public User getUser(String userId) {
        Optional<User> user = userRepository.findById(userId);

        return user.get();
    }

    @Override
    public void editUser(String userId) {

    }

    @Override
    public boolean deleteUser(String userId) {
        userRepository.deleteById(userId);
        return true;
    }
}
