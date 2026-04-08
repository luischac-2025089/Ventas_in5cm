package com.Ventas.Principal.Repository;

import com.Ventas.Principal.Entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Ventas, Integer> {
}
