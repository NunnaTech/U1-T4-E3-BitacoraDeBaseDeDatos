package edu.utez.mx.citiutez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {
    @GetMapping("/client/registerClient")
    public String registerClient(){

        return "registerClient";
    }

    @GetMapping("/client/allClient")
    public String listAllClient()
    {
        return "allClient";
    }
}
