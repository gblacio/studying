package com.example.studying.Web;

import com.example.studying.Entities.Cliente;
import com.example.studying.Repositories.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controlador {
    @Autowired
    private DAO dao;

    @GetMapping(path = "/")
    public String inicio(Model model){
        var clientes = dao.findAll();
        model.addAttribute("clientes", clientes);
        return "index";
    }

    @GetMapping(path = "/add")
    public String addCustomer(Model model){
        model.addAttribute("cliente", new Cliente());
        return "modify";
    }

    @PostMapping(path = "/save")
    public String saveCustomer(Cliente cliente){
        dao.save(cliente);
        return "redirect:/";
    }

    @GetMapping(path = "/edit/{idcliente}")
    public String editCustomer(Cliente cliente, Model model){
        cliente = dao.findById(cliente.getIdcliente()).orElse(null);;
        model.addAttribute("cliente", cliente);
        return "modify";
    }

    @GetMapping(path = "/delete")
    public String deleteCustomer(Cliente cliente){
        dao.delete(cliente);
        return "redirect:/";
    }

}
