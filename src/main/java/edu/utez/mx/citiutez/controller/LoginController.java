package edu.utez.mx.citiutez.controller;

import edu.utez.mx.citiutez.entity.Employee;
import edu.utez.mx.citiutez.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String login(Model model){
        return "login";
    }

    @PostMapping("/login")
    public String enter(@ModelAttribute(name="loginForm") Employee login){
        Employee session = employeeService.getByEmail(login.getEmail());
        if (session.isIsadmin()==true){
            return "sessionLogs";
        }else {
            return "AllEmployee";
        }
    }
}
