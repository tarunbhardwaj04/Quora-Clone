package com.App.Quora.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/Quora")
public class AuthController {

    @GetMapping("/about")
    public String getAbout()
    {
        return "about";
    }
    @GetMapping("/login")
    public String getLogin()
    {
        return "login";
    }
    @GetMapping("/register")
    public String getRegister()
    {
        return "register";
    }
    @PostMapping("/register")
    public String registerUser()
    {
        return "register";
    }
}
