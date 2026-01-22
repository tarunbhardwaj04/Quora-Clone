package com.App.Quora.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/about")
public class AboutController {

    @GetMapping
    public String getAbout()
    {
        return "about";
    }
    
}
