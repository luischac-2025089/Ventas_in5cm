package com.Ventas.Principal.Controller;

import com.Ventas.Principal.Entity.DetalleVenta;
import com.Ventas.Principal.Service.DetalleVentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/detalleventas")
public class DetalleVentaController {
    private final DetalleVentaService detalleVentaService;
    public DetalleVentaController (DetalleVentaService detalleVentaService){
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping
    public List<DetalleVenta> getAllDetalleVenta(){return detalleVentaService.getAllDetalleVenta();}

    @PostMapping
    public ResponseEntity<Object> createDetalleVenta(@Valid @RequestBody DetalleVenta detalleVenta){
        try{
            DetalleVenta createdDetalleVenta = detalleVentaService.saveDetalleVenta(detalleVenta);
            return new ResponseEntity<>(createdDetalleVenta, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDetalleVenta(@PathVariable Integer id){
        try {
            detalleVentaService.deleteDetalleVenta(id);
            return ResponseEntity.ok("Detalle de Venta Eliminado Correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDetalleVenta(@PathVariable Integer id, @RequestBody DetalleVenta detalleVenta) {

        try {
            DetalleVenta actualizado = detalleVentaService.updateDetalleVenta(id, detalleVenta);
            return ResponseEntity.ok(actualizado);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
