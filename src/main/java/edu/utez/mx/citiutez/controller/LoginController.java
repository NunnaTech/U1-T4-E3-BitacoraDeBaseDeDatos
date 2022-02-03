package edu.utez.mx.citiutez.controller;

import edu.utez.mx.citiutez.entity.Employee;
import edu.utez.mx.citiutez.entity.SessionLogs;
import edu.utez.mx.citiutez.service.EmployeeService;
import edu.utez.mx.citiutez.service.SessionLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;


@Controller
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SessionLogsService sessionLogsService;

    @GetMapping("/")
    public String login(Model model){
        return "login";
    }

    @PostMapping("/login")
    public String enter(@ModelAttribute(name="loginForm") Employee login){
        Employee session = employeeService.getByEmail(login.getEmail());
        if (session.isIsadmin()==true){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            SessionLogs logs = new SessionLogs(timestamp,session);
            sessionLogsService.save(logs);
            return "redirect:/session";
        }else {
            return "redirect:/employee/allEmployee";
        }
    }
}
