package edu.utez.mx.citiutez.controller;

import edu.utez.mx.citiutez.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/")
    public String login(Model model){
        return "login";
    }

}
