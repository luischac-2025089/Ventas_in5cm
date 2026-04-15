package com.Ventas.Principal.Service;

import com.Ventas.Principal.Entity.Clientes;
import com.Ventas.Principal.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplements implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImplements(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Clientes> getAllClientes(){
        return clienteRepository.findAll();
    }

    @Override
    public Clientes getClientesById(Integer id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public Clientes saveClientes(Clientes clientes){
        return clienteRepository.save(clientes);
    }

    @Override
    public Clientes updateClientes(Integer id, Clientes clientes){

        Clientes existente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        existente.setNombre_cliente(clientes.getNombre_cliente());
        existente.setApellido_cliente(clientes.getApellido_cliente());
        existente.setDireccion(clientes.getDireccion());
        existente.setEstado(clientes.getEstado());

        return clienteRepository.save(existente);
    }

    @Override
    public void deleteClientes(Integer id){
        clienteRepository.deleteById(id);
    }
}