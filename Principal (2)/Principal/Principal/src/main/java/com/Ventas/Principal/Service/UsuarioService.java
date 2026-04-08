package com.Ventas.Principal.Service;

import com.Ventas.Principal.Entity.Usuarios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {
    List<Usuarios> getAllUsuarios();
    Usuarios getUsuariosById (Integer id);
    Usuarios saveUsuarios (Usuarios usuarios) throws RuntimeException;
    Usuarios updateUsuarios (Integer id, Usuarios usuarios);
    void deleteUsuarios (Integer id);
}
