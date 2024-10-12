package com.nhnacademy.minidooray.controller;

import com.nhnacademy.minidooray.dto.UserLoginRequest;
import com.nhnacademy.minidooray.dto.UserLoginResponse;
import com.nhnacademy.minidooray.dto.UserRegisterRequest;
import com.nhnacademy.minidooray.dto.UserRegisterResponse;
import com.nhnacademy.minidooray.entity.User;
import com.nhnacademy.minidooray.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class UserController {

    private final UserService userService;

    //회원가입 처리
    @PostMapping("/api/account/register")
    public ResponseEntity<UserRegisterResponse> registerUser(@Valid @RequestBody UserRegisterRequest request) {
        userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.OK).body(new UserRegisterResponse(request.getUserId()));
    }

    //로그인 처리
    @PostMapping("/api/login")
    public ResponseEntity<UserLoginResponse> login(@Valid @RequestBody UserLoginRequest request) {
        User user = userService.doLogin(request.getUserId());
        return ResponseEntity.status(HttpStatus.OK).body(new UserLoginResponse(user));
    }

    //회원정보 조회
    @GetMapping("/api/mypage/{userId}")
    public User mypage(@PathVariable String userId) {
        return null;
    }

    //회원 탈퇴




}
