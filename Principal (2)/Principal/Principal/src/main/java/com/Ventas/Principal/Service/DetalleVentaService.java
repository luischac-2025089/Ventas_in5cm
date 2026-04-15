package com.Ventas.Principal.Service;

import com.Ventas.Principal.Entity.DetalleVenta;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DetalleVentaService {
    List<DetalleVenta> getAllDetalleVenta();
    DetalleVenta getDetalleVentaById(Integer id);
    DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta);
    DetalleVenta updateDetalleVenta(Integer id, DetalleVenta detalleVenta);
    void deleteDetalleVenta(Integer id);
}
