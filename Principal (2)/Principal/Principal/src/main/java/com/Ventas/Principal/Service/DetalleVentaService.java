package com.Ventas.Principal.Service;

import com.Ventas.Principal.Entity.DetalleVenta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetalleVentaService {
    List<DetalleVenta> getAllDetalleVenta();
    DetalleVenta getDetalleVentaById(Integer id);
    DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta) throws RuntimeException;
    DetalleVenta updateDetalleVenta(Integer id, DetalleVenta detalleVenta);
    void deleteDetalleVenta(Integer id);
}
