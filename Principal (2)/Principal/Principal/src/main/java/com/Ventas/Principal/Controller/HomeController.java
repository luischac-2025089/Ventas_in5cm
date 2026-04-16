package com.Ventas.Principal.Controller;

import com.Ventas.Principal.Entity.Usuarios;
import com.Ventas.Principal.Repository.UsuarioRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UsuarioRepository usuarioRepository;

    public HomeController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping({"/","/home"})
    public String dashboard(Model model, Authentication authentication){

        String username = authentication.getName();

        Usuarios usuario = usuarioRepository.findByUsername(username);

        model.addAttribute("username", username);
        model.addAttribute("rol", usuario.getRol());

        return "home";
    }
}