package edu.utez.mx.citiutez.controller;

import edu.utez.mx.citiutez.entity.Employee;
import edu.utez.mx.citiutez.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/registerEmployee")
    public String registerEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "registerEmployee";
    }

    @GetMapping("/employee/allEmployee")
    public String listAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "allEmployee";
    }

    @PostMapping("/employee/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee/allEmployee";
    }

    @GetMapping("/employee/edit/{id}")
    public String editEmployee(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", employeeService.getOne(id));
        return "editEmployee";
    }

    @PostMapping("/employee/update/{id}")
    public String updateEmployee(@PathVariable Integer id, @ModelAttribute("employee") Employee employee) {
        employeeService.update(id, employee);
        return "redirect:/employee/allEmployee";
    }

    @GetMapping("/employee/activate/{id}")
    public String activate(@PathVariable Integer id){
        employeeService.activate(id);
        return "redirect:/employee/allEmployee";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.delete(id);
        return "redirect:/employee/allEmployee";
    }
}
