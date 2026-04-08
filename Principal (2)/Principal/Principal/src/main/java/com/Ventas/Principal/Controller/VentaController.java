package com.Ventas.Principal.Controller;

import com.Ventas.Principal.Entity.Ventas;
import com.Ventas.Principal.Service.VentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ventas")
public class VentaController {
    private final VentaService ventaService;
    public VentaController (VentaService ventaService){
        this.ventaService = ventaService;
    }

    @GetMapping
    public List<Ventas> getAllVentas(){return ventaService.getAllVentas();}

    @PostMapping
    public ResponseEntity<Object> createVentas(@Valid @RequestBody Ventas ventas){
        try{
            Ventas createdVentas = ventaService.saveVentas(ventas);
            return new ResponseEntity<>(createdVentas, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVentas(@PathVariable Integer id){
        try {
            ventaService.deleteVentas(id);
            return ResponseEntity.ok("Venta Eliminado Correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVentas(@PathVariable Integer id, @RequestBody Ventas ventas) {

        try {
            Ventas actualizado = ventaService.updateVentas(id, ventas);
            return ResponseEntity.ok(actualizado);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
