package com.Ventas.Principal.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_detalle_venta")
    private Integer codigo_detalle_venta;

    @NotNull(message = "El campo no debe ir vacio")
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull(message = "El campo no debe ir vacio")
    @Column(name = "precio_unitario")
    private Float precio_unitario;

    @NotNull(message = "El campo no debe ir vacio")
    @Column(name = "subtotal")
    private Float subtotal;

    @NotNull(message = "El campo no debe ir vacio")
    @Column(name = "productos_codigo_producto")
    private Integer productos_codigo_producto;

    @NotNull(message = "El campo no debe ir vacio")
    @Column(name = "ventas_codigo_venta")
    private Integer ventas_codigo_venta;

    public Integer getCodigo_detalle_venta() {
        return codigo_detalle_venta;
    }

    public void setCodigo_detalle_venta(Integer codigo_detalle_venta) {
        this.codigo_detalle_venta = codigo_detalle_venta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getProductos_codigo_producto() {
        return productos_codigo_producto;
    }

    public void setProductos_codigo_producto(Integer productos_codigo_producto) {
        this.productos_codigo_producto = productos_codigo_producto;
    }

    public Integer getVentas_codigo_venta() {
        return ventas_codigo_venta;
    }

    public void setVentas_codigo_venta(Integer ventas_codigo_venta) {
        this.ventas_codigo_venta = ventas_codigo_venta;
    }
}
