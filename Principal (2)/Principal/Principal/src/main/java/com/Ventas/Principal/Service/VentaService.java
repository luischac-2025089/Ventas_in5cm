package com.Ventas.Principal.Service;

import com.Ventas.Principal.Entity.Ventas;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VentaService {
    List<Ventas> getAllVentas();
    Ventas getVentasById(Integer id);
    Ventas saveVentas(Ventas ventas);
    Ventas updateVentas (Integer id, Ventas ventas);
    void deleteVentas (Integer id);
}
