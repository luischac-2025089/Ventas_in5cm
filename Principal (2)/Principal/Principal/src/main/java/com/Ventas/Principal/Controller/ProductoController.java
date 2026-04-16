package com.Ventas.Principal.Controller;

import com.Ventas.Principal.Entity.Productos;
import com.Ventas.Principal.Service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping
    public String mostrarProductos(Model model){

        model.addAttribute("productos", productoService.getAllProductos());

        return "productos";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("producto", new Productos());
        return "productosForm";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Productos productos){
        productoService.saveProductos(productos);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        model.addAttribute("producto", productoService.getProductosById(id));
        return "productosForm";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        productoService.deleteProductos(id);
        return "redirect:/productos";
    }
}