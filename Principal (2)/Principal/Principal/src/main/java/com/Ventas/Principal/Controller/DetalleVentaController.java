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
@RequestMapping("/detalleventas")
public class DetalleVentaController {

    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService){
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping
    public String mostrarDetalleVenta(Model model){
        model.addAttribute("detalleventas", detalleVentaService.getAllDetalleVenta());
        return "detalleventa";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("detalleventa", new DetalleVenta());
        return "detalleventaForm";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute DetalleVenta detalleVenta){
        detalleVentaService.saveDetalleVenta(detalleVenta);
        return "redirect:/detalleventas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        model.addAttribute("detalleventa", detalleVentaService.getDetalleVentaById(id));
        return "detalleventaForm";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        detalleVentaService.deleteDetalleVenta(id);
        return "redirect:/detalleventas";
    }
}
