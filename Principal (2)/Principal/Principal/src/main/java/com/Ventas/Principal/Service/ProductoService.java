package com.Ventas.Principal.Service;

import com.Ventas.Principal.Entity.Productos;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductoService {
    List<Productos> getAllProductos();
    Productos getProductosById(Integer id);
    Productos saveProductos(Productos productos);
    Productos updateProductos(Integer id, Productos productos);
    void deleteProductos(Integer id);
}
