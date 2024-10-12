package com.nhnacademy.minidooray.controller;

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
    public UserRegisterResponse registerUser(@Valid @RequestBody UserRegisterRequest request) {
        userService.registerUser(request);
        return new UserRegisterResponse(request.getId());
    }

    //로그인 처리
    @PostMapping
    public UserLoginResponse login() {

        return  null;
    }

    //회원정보 조회
    @GetMapping("/api/mypage/{userId}")
    public User mypage(@PathVariable String userId) {
        return null;
    }

    //회원 탈퇴




}
