package com.example.auth1.controller;

import com.example.auth1.dto.MemberDto;
import com.example.auth1.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    // main page
    @GetMapping("/")
    public String index() {
        return "/index";
    }

    // sign up page
    @GetMapping("/user/signup")
    public String dispSignup() {
        return "/signup";
    }

    // sign up
    @PostMapping("/user/signup")
    public String execSignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);

        return "redirect:/user/login";
    }

    // login page
    @GetMapping("/user/login")
    public String dispLogin() {
        return "/login";
    }

    // after login page
    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "/loginSuccess";
    }

    // after logout page
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/logout";
    }

    // 접근 거부
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }

    // info
    @GetMapping("/user/info")
    public String dispMyInfo() {
        return "/myinfo";
    }

    // admin page
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/admin";
    }
}
