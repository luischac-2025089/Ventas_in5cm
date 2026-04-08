package com.Ventas.Principal.Repository;

import com.Ventas.Principal.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Integer> {
}
