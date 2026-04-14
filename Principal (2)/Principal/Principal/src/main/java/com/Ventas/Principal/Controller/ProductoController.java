package com.Ventas.Principal.Controller;

import com.Ventas.Principal.Entity.Productos;
import com.Ventas.Principal.Service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("api/productos")
public class ProductoController {
    private final ProductoService productoService;
    public ProductoController (ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping
    public String mostrarProductos(){
        return "productos";
    }

    @PostMapping
    public ResponseEntity<Object> createProductos(@Valid @RequestBody Productos productos){
        try{
            Productos createdProducto = productoService.saveProductos(productos);
            return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductos(@PathVariable Integer id){
        try {
            productoService.deleteProductos(id);
            return ResponseEntity.ok("Producto Eliminado Correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductos(@PathVariable Integer id, @RequestBody Productos productos) {

        try {
            Productos actualizado = productoService.updateProductos(id, productos);
            return ResponseEntity.ok(actualizado);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
