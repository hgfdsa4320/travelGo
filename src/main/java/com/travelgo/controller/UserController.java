package com.travelgo.controller;

import com.travelgo.domain.User;
import com.travelgo.dto.LoginDto;
import com.travelgo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("travel-go/login")
    public String login(@Valid @ModelAttribute LoginDto loginDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login-form"; // 공백일 떄
        }

        User user = userService.login(loginDto.getEmailAddress(), loginDto.getPassword());

        if (user == null) { //아이디 또는 비밀번호가 맞지 않을 때
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다." );
            log.info("아이디 또는 비밀번호가 맞지 않습니다.");
            return "login-form";
        }

        log.info("로그인 성공"); // 로그인 성공했을 때
        return "login-success";
    }
}
