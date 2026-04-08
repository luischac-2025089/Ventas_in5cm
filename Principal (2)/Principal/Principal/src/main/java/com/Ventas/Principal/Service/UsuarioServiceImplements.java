package com.Ventas.Principal.Service;

import com.Ventas.Principal.Entity.Usuarios;
import com.Ventas.Principal.Repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;


@Service
public class UsuarioServiceImplements implements UsuarioService, UserDetailsService{
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImplements(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuarios> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    @Override
    public Usuarios getUsuariosById (Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuarios saveUsuarios(Usuarios usuarios) throws RuntimeException{
        return usuarioRepository.save(usuarios);
    }

    @Override
    public void deleteUsuarios(Integer id){
        if (!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuario no existe");
        }
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuarios updateUsuarios (Integer id, Usuarios usuarios){
        Usuarios existingUsuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("El usuario no existe"));

        existingUsuario.setUsername(usuarios.getUsername());
        existingUsuario.setPasword(usuarios.getPasword());
        existingUsuario.setEmail(usuarios.getEmail());
        existingUsuario.setRol(usuarios.getRol());
        existingUsuario.setEstado(usuarios.getEstado());

        return usuarioRepository.save(existingUsuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuarios usuario = usuarioRepository.findByUsername(username);

        if(usuario == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return new User(
                usuario.getUsername(),
                usuario.getPasword(),
                new ArrayList<>()
        );
    }
}
