package edu.utez.mx.citiutez.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/employee/registerEmployee")
    public String registerEmployee(){
        return "RegisterPersonal";
    }

    @GetMapping("/employee/allEmployee")
    public String listAllEmployees(){
        return "AllEmployee";
    }
}
