package com.Ventas.Principal.Service;

import com.Ventas.Principal.Entity.Clientes;
import com.Ventas.Principal.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplements implements ClienteService{
    private final ClienteRepository clienteRepository;

    public ClienteServiceImplements(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Clientes> getAllClientes(){
        return clienteRepository.findAll();
    }

    @Override
    public Clientes getClientesById (Integer id){
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Clientes saveClientes(Clientes clientes) throws RuntimeException{
        return clienteRepository.save(clientes);
    }

    @Override
    public void deleteClientes(Integer id){
        if (!clienteRepository.existsById(id)){
            throw new RuntimeException("Cliente no existe");
        }
        clienteRepository.deleteById(id);
    }

    @Override
    public Clientes updateClientes (Integer id, Clientes clientes){
        Clientes existingCliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("El cliente no existe"));

        existingCliente.setNombre_cliente(clientes.getNombre_cliente());
        existingCliente.setApellido_cliente(clientes.getApellido_cliente());
        existingCliente.setDireccion(clientes.getDireccion());
        existingCliente.setEstado(clientes.getEstado());

        return clienteRepository.save(existingCliente);
    }
}
