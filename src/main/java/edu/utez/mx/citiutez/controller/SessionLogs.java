package edu.utez.mx.citiutez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionLogs {
    @GetMapping("/session")
    public String session(Model model){
        return "sessionLogs";
    }
}
