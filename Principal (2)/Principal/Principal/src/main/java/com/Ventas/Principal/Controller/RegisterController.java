package com.Ventas.Principal.Controller;

import com.Ventas.Principal.Entity.Usuarios;
import com.Ventas.Principal.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/register")
    public String mostrarRegistro(){
        return "register";
    }

    @PostMapping("/register")
    public String registrarUsuario(Usuarios usuario){

        usuario.setRol("USER");
        usuario.setEstado(1);

        usuarioRepository.save(usuario);

        return "redirect:/login";
    }
}