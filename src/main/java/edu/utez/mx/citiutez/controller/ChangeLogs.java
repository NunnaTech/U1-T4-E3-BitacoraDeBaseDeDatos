package edu.utez.mx.citiutez.controller;

import edu.utez.mx.citiutez.service.ChangeLogsService;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChangeLogs {
    @Autowired
    private ChangeLogsService changeLogsService;

    @GetMapping("/changes")
    public String historychanges(Model model){
        model.addAttribute("mychanges", changeLogsService.getAll());
        return "changeLogs";
    }
}
