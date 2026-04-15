package com.Ventas.Principal.Service;

import com.Ventas.Principal.Entity.Clientes;
import java.util.List;

public interface ClienteService {
    List<Clientes> getAllClientes();
    Clientes getClientesById(Integer id);
    Clientes saveClientes(Clientes clientes);
    Clientes updateClientes(Integer id, Clientes clientes);
    void deleteClientes(Integer id);
}