package com.Ventas.Principal.Controller;

import com.Ventas.Principal.Entity.DetalleVenta;
import com.Ventas.Principal.Service.DetalleVentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/detalleventas")
public class DetalleVentaController {

    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService){
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping
    public String mostrarDetalleVenta(Model model){
        List<DetalleVenta> lista = detalleVentaService.getAllDetalleVenta();
        model.addAttribute("detalleventas", lista);
        return "detalleVenta";
    }

    @PostMapping
    public ResponseEntity<?> createDetalleVenta(@Valid @RequestBody DetalleVenta detalleVenta){
        DetalleVenta created = detalleVentaService.saveDetalleVenta(detalleVenta);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDetalleVenta(@PathVariable Integer id){
        detalleVentaService.deleteDetalleVenta(id);
        return ResponseEntity.ok("Detalle eliminado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDetalleVenta(@PathVariable Integer id,
                                                @RequestBody DetalleVenta detalleVenta){

        DetalleVenta actualizado = detalleVentaService.updateDetalleVenta(id, detalleVenta);
        return ResponseEntity.ok(actualizado);
    }
}