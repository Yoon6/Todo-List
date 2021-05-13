package com.example.auth1.controller;

import com.example.auth1.dto.MemberDto;
import com.example.auth1.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

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
    public String dispSignup(MemberDto memberDto) {
        return "/signup";
    }

    // sign up
    @PostMapping("/user/signup")
    public String execSignup(@Valid MemberDto memberDto, Errors errors, Model model) {

        if (errors.hasErrors()) {
            // 회원가입 실패 시, 입력 데이터를 유지
            model.addAttribute("memberDto", memberDto);

            // 유효성 검사 통과 못한 필드와 메세지 핸들링
            Map<String, String> validatorResult = memberService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }

            return "/signup";

        }

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
