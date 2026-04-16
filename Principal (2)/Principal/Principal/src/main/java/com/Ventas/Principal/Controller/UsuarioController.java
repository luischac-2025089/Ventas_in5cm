package com.Ventas.Principal.Controller;

import com.Ventas.Principal.Entity.Usuarios;
import com.Ventas.Principal.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String mostrarUsuarios(Model model){
        model.addAttribute("usuarios", usuarioService.getAllUsuarios());
        return "usuarios";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("usuario", new Usuarios());
        return "usuariosForm";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Usuarios usuarios){
        usuarioService.saveUsuarios(usuarios);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        model.addAttribute("usuario", usuarioService.getUsuariosById(id));
        return "usuariosForm";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        usuarioService.deleteUsuarios(id);
        return "redirect:/usuarios";
    }
}