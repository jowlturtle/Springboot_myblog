package com.cos.myblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping({"","/"})
    public String index(){
        return "index";
    }

    @GetMapping("/user/joinForm")
    public String joinForm(){
        return "user/joinForm";
    }

    @GetMapping("/user/loginForm")
    public String loginForm(){
        return "user/loginForm";
    }
}

