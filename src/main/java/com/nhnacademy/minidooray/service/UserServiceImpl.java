package com.nhnacademy.minidooray.service;

import com.nhnacademy.minidooray.dto.UserEditRequest;
import com.nhnacademy.minidooray.dto.UserRegisterRequest;
import com.nhnacademy.minidooray.entity.User;
import com.nhnacademy.minidooray.exception.UserAlreadyExistsException;
import com.nhnacademy.minidooray.exception.UserNotFoundException;
import com.nhnacademy.minidooray.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void registerUser(UserRegisterRequest user) {
        User savedUser = new User(user.getUserId(), user.getPassword(), user.getEmail());
        userRepository.save(savedUser);
    }

    @Override
    @Transactional
    public User doLogin(String userId) {
        Optional<User> user = userRepository.findByUserId(userId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        user.get().setLastLoginAt(LocalDateTime.parse(formattedDateTime, formatter));

        if(Objects.isNull(user)) {
            throw new UserNotFoundException();
        }
        return user.get();
    }

    @Override
    public User getUser(String userId) {
        Optional<User> user = userRepository.findByUserId(userId);

        return user.get();
    }

    @Override
    public void editUser(String userId, UserEditRequest request) {
        Optional<User> user = userRepository.findByUserId(userId);
//        user.get().setUserId(request.);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
