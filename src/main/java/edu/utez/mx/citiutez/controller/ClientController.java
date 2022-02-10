package edu.utez.mx.citiutez.controller;

import edu.utez.mx.citiutez.entity.Customer;
import edu.utez.mx.citiutez.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {
    @Autowired
    private CustomerService customerService;


    @GetMapping("/client/register")
    public String registerClientes(Model model) {
        Customer customer = new Customer();
        model.addAttribute("newclient", customer);
        return "registerClient";
    }

    @PostMapping("/client/save")
    public String saveClient(@ModelAttribute("customer") Customer customer, @RequestParam("idUser") int idUser) {
        customerService.save(customer,idUser);
        return "redirect:/client/allClient";
    }

    @GetMapping("/client/allClient")
    public String listAllClient(Model model) {
        model.addAttribute("listclientes",customerService.getAll());
        return "allClient";
    }

    @GetMapping("/client/edit/{id}")
    public String editClient(@PathVariable Integer id, Model model) {
        model.addAttribute("customerEdit", customerService.getOne(id));
        return "editClient";
    }

    @PostMapping("/client/update/{id}")
    public String updateClient(@PathVariable Integer id, @ModelAttribute("customer") Customer customer,@RequestParam("idUser") int idUser) {
        customerService.update(id, customer,  idUser );
        return "redirect:/client/allClient";
    }

    @GetMapping("/client/activate/{id}/{idUser}")
    public String activate(@PathVariable Integer id,@PathVariable(name = "idUser") int idUser){
        customerService.activate(id, idUser);
        return "redirect:/client/allClient";
    }

    @GetMapping("/client/delete/{id}/{idUser}")
    public String deleteClient(@PathVariable Integer id,@PathVariable(name = "idUser") int idUser) {
        customerService.delete(id,idUser);
        return "redirect:/client/allClient";
    }
}
