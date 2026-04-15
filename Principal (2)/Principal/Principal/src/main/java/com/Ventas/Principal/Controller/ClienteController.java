package com.Ventas.Principal.Controller;

import com.Ventas.Principal.Entity.Clientes;
import com.Ventas.Principal.Service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping
    public String mostrarClientes(Model model){

        List<Clientes> listaClientes = clienteService.getAllClientes();

        model.addAttribute("clientes", listaClientes);

        return "clientes";
    }

    @GetMapping("/nuevo")
    public String nuevoCliente(Model model){

        model.addAttribute("cliente", new Clientes());

        return "clientesForm";
    }

    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute Clientes cliente){

        clienteService.saveClientes(cliente);

        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable Integer id, Model model){

        Clientes cliente = clienteService.getClientesById(id);

        model.addAttribute("cliente", cliente);

        return "clientesForm";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Integer id){

        clienteService.deleteClientes(id);

        return "redirect:/clientes";
    }
}