package com.Ventas.Principal.Service;

import com.Ventas.Principal.Entity.DetalleVenta;
import com.Ventas.Principal.Repository.DetalleVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServiceImplements implements DetalleVentaService{
    private final DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaServiceImplements(DetalleVentaRepository detalleVentaRepository){
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    public List<DetalleVenta> getAllDetalleVenta(){
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta getDetalleVentaById (Integer id){
        return detalleVentaRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta) throws RuntimeException{
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public void deleteDetalleVenta(Integer id){
        if (!detalleVentaRepository.existsById(id)){
            throw new RuntimeException("Detalle de venta no existe");
        }
        detalleVentaRepository.deleteById(id);
    }

    @Override
    public DetalleVenta updateDetalleVenta (Integer id, DetalleVenta detalleVenta){
        DetalleVenta existingDetalleVenta = detalleVentaRepository.findById(id).orElseThrow(() -> new RuntimeException("El detalle de venta no existe"));

        existingDetalleVenta.setCantidad(detalleVenta.getCantidad());
        existingDetalleVenta.setPrecio_unitario(detalleVenta.getPrecio_unitario());
        existingDetalleVenta.setSubtotal(detalleVenta.getSubtotal());
        existingDetalleVenta.setProductos_codigo_producto(detalleVenta.getProductos_codigo_producto());
        existingDetalleVenta.setVentas_codigo_venta(detalleVenta.getVentas_codigo_venta());

        return detalleVentaRepository.save(existingDetalleVenta);
    }
}
