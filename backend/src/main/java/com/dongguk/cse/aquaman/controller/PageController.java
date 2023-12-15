package com.dongguk.cse.aquaman.controller;


//import com.dongguk.cse.aquaman.security.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/")
public class PageController {

    @GetMapping("main")
    public String mainPage(){
        return "main";
    }
    @GetMapping("category")
    public String category(){
        return "category";
    }
    @GetMapping("login")
    public String login( ) {
         return "login";
    }
    @GetMapping("register")
    public String register(){
        return "register";
    }
    @GetMapping("moniter")
    public String moniter(){
        return "moniter";

    }
    @GetMapping("moniter_result")
    public String monitor_result(){
        return "moniter_result";
    }
}
