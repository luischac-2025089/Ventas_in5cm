package com.Ventas.Principal.Service;

import com.Ventas.Principal.Entity.Productos;
import com.Ventas.Principal.Entity.Ventas;
import com.Ventas.Principal.Repository.ProductoRepository;
import com.Ventas.Principal.Repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImplements implements VentaService{
    private final VentaRepository ventaRepository;

    public VentaServiceImplements(VentaRepository ventaRepository){
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<Ventas> getAllVentas(){
        return ventaRepository.findAll();
    }

    @Override
    public Ventas getVentasById (Integer id){
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public Ventas saveVentas(Ventas ventas) throws RuntimeException{
        return ventaRepository.save(ventas);
    }

    @Override
    public void deleteVentas(Integer id){
        if (!ventaRepository.existsById(id)){
            throw new RuntimeException("Venta no existe");
        }
        ventaRepository.deleteById(id);
    }

    @Override
    public Ventas updateVentas (Integer id, Ventas ventas){
        Ventas existingVenta = ventaRepository.findById(id).orElseThrow(() -> new RuntimeException("La venta no existe"));

        existingVenta.setFecha_venta(ventas.getFecha_venta());
        existingVenta.setTotal(ventas.getTotal());
        existingVenta.setEstado(ventas.getEstado());
        existingVenta.setClientes_dpi_cliente(ventas.getClientes_dpi_cliente());
        existingVenta.setUsuarios_codigo_usuario(ventas.getUsuarios_codigo_usuario());

        return ventaRepository.save(existingVenta);
    }
}
