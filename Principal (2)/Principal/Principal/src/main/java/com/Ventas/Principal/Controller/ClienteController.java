package com.Ventas.Principal.Controller;

import com.Ventas.Principal.Entity.Clientes;
import com.Ventas.Principal.Service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;
    public ClienteController (ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Clientes> getAllClientes(){return clienteService.getAllClientes();}

    @PostMapping
    public ResponseEntity<Object> createClientes(@Valid @RequestBody Clientes clientes){
        try{
            Clientes createdClientes = clienteService.saveClientes(clientes);
            return new ResponseEntity<>(createdClientes, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClientes(@PathVariable Integer id){
        try {
            clienteService.deleteClientes(id);
            return ResponseEntity.ok("Cliente Eliminado Correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClientes(@PathVariable Integer id, @RequestBody Clientes clientes) {

        try {
            Clientes actualizado = clienteService.updateClientes(id, clientes);
            return ResponseEntity.ok(actualizado);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
