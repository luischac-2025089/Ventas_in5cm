package com.Ventas.Principal.Service;

import com.Ventas.Principal.Entity.DetalleVenta;
import com.Ventas.Principal.Entity.Productos;
import com.Ventas.Principal.Repository.DetalleVentaRepository;
import com.Ventas.Principal.Repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImplements implements ProductoService{
    private final ProductoRepository productoRepository;

    public ProductoServiceImplements(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Productos> getAllProductos(){
        return productoRepository.findAll();
    }

    @Override
    public Productos getProductosById (Integer id){
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Productos saveProductos(Productos productos) throws RuntimeException{
        return productoRepository.save(productos);
    }

    @Override
    public void deleteProductos(Integer id){
        if (!productoRepository.existsById(id)){
            throw new RuntimeException("Producto no existe");
        }
        productoRepository.deleteById(id);
    }

    @Override
    public Productos updateProductos (Integer id, Productos productos){
        Productos existingProducto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("El producto no existe"));

        existingProducto.setNombre_producto(productos.getNombre_producto());
        existingProducto.setPrecio(productos.getPrecio());
        existingProducto.setStock(productos.getStock());
        existingProducto.setEstado(productos.getEstado());

        return productoRepository.save(existingProducto);
    }
}
