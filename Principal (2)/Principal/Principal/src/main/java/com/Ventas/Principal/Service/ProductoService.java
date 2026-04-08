package com.Ventas.Principal.Service;

import com.Ventas.Principal.Entity.Productos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductoService {
    List<Productos> getAllProductos();
    Productos getProductosById(Integer id);
    Productos saveProductos(Productos productos) throws RuntimeException;
    Productos updateProductos(Integer id, Productos productos);
    void deleteProductos(Integer id);
}
