package edu.utez.mx.citiutez.controller;

import edu.utez.mx.citiutez.entity.Employee;
import edu.utez.mx.citiutez.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String enter(@ModelAttribute(name = "loginForm") Employee login, HttpSession sessionUser) {
        Map<String, Object> session = employeeService.checkUser(login);
        if (session.get("noUser") == "false") {
            if (session.get("isAdmin") == "true") {
                sessionUser.setAttribute("idUser", session.get("idUser"));
                return "redirect:/session";
            } else if (session.get("isAdmin") == "false") {
                sessionUser.setAttribute("idUser", session.get("idUser"));
                return "redirect:/client/allClient";
            }
        }
        return "redirect:/";
    }

}
