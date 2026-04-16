package com.Ventas.Principal.Controller;

import com.Ventas.Principal.Entity.Ventas;
import com.Ventas.Principal.Service.VentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService){
        this.ventaService = ventaService;
    }

    @GetMapping
    public String mostrarVentas(Model model){
        model.addAttribute("ventas", ventaService.getAllVentas());
        return "ventas";
    }

    @GetMapping("/nuevo")
    public String nuevaVenta(Model model){
        model.addAttribute("venta", new Ventas());
        return "ventasForm";
    }

    @PostMapping("/guardar")
    public String guardarVenta(@ModelAttribute Ventas venta){
        ventaService.saveVentas(venta);
        return "redirect:/ventas";
    }

    @GetMapping("/editar/{id}")
    public String editarVenta(@PathVariable Integer id, Model model){
        model.addAttribute("venta", ventaService.getVentasById(id));
        return "ventasForm";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarVenta(@PathVariable Integer id){
        ventaService.deleteVentas(id);
        return "redirect:/ventas";
    }
}