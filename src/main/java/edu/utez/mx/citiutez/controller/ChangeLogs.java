package edu.utez.mx.citiutez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChangeLogs {

    @GetMapping("/changes")
    public String changes(Model model){
        return "changeLogs";
    }
}
