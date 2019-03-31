package com.github.prova.controller;


import com.github.prova.entity.Cliente;
import com.github.prova.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping("/listar")
    public String list(Model model){
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "cliente/cliente";
    }


    @RequestMapping("/novo")
    public String novo(Model model){
        model.addAttribute("cliente", novoCliente());
        return "cliente/cliente-form";
    }

    @RequestMapping("/salvarCliente")
    public String salvarCliente(@Valid Cliente cliente, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
                return "cliente/cliente-form";
        }
        clienteRepository.save(cliente);
        return "redirect:/listar";
    }

    @RequestMapping("/pesquisar")
    public String pesquisar(Model model,
                            @RequestParam String pesquisa,
                            @RequestParam String parametro){
        List<Cliente> clientes = null;
        if(parametro.equals("nome")){
             clientes = clienteRepository.findByNomeContaining(pesquisa);
        }else{
            clientes = clienteRepository.findByCpfEquals(pesquisa);
        }

        if(clientes != null){
            model.addAttribute("clientes", clientes);
        }else{
            clientes = new ArrayList<>();
            model.addAttribute("clientes", clientes);
        }
        return "cliente/cliente";
    }



    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Cliente cliente = clienteRepository.getOne(id);
        model.addAttribute("cliente", cliente);
        return "cliente/cliente-form";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        Cliente cliente = clienteRepository.getOne(id);
        clienteRepository.delete(cliente);
        return "redirect:/listar";
    }



    public Cliente novoCliente(){
        Cliente cliente = new Cliente();
        cliente.setSexo("M");
        cliente.setStatus(true);
        return cliente;
    }
}
