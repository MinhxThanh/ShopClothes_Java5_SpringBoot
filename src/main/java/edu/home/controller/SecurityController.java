package edu.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "security")
public class SecurityController {
    @RequestMapping("login/form")
    public String loginForm(Model model){
        model.addAttribute("error", "Please login!");
        return "security/login";
    }

    @RequestMapping(value = "login/success")
    public String loginSuccess(Model model){
        model.addAttribute("message", "Login Successfully!");
        return "security/login";
    }

    @RequestMapping(value = "login/error")
    public String loginFail(Model model){
        model.addAttribute("error", "Incorrect username or password!");
        return "security/login";
    }

    @RequestMapping(value = "unauthorized")
    public String unauthorized(Model model){
        model.addAttribute("error", "You account don't unauthorized!");
        return "security/login";
    }

    @RequestMapping(value = "logout/success")
    public String logout(Model model){
        model.addAttribute("message", "Logout successfully!");
        return "security/login";
    }
}
