package com.Ventas.Principal.Controller;

import com.Ventas.Principal.Entity.Usuarios;
import com.Ventas.Principal.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController (UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuarios> getAllUsuarios(){return usuarioService.getAllUsuarios();}

    @PostMapping
    public ResponseEntity<Object> createUsuarios(@Valid @RequestBody Usuarios usuarios){
        try{
            Usuarios createdUsuario = usuarioService.saveUsuarios(usuarios);
            return new ResponseEntity<>(createdUsuario, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuarios(@PathVariable Integer id){
        try {
            usuarioService.deleteUsuarios(id);
            return ResponseEntity.ok("Usuario Eliminado Correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsuarios(@PathVariable Integer id, @RequestBody Usuarios usuarios) {

        try {
            Usuarios actualizado = usuarioService.updateUsuarios(id, usuarios);
            return ResponseEntity.ok(actualizado);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
