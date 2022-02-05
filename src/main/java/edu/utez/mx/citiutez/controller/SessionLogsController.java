package edu.utez.mx.citiutez.controller;

import edu.utez.mx.citiutez.entity.Employee;
import edu.utez.mx.citiutez.service.SessionLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;

@Controller
public class SessionLogsController {
    @Autowired
    private SessionLogsService sessionLogsService;

    @GetMapping("/session")
    public String session(Model model){
        model.addAttribute("mysessions", sessionLogsService.getAll());
        return "sessionLogs";
    }
}
