package com.example.API_ventaslocal.Service;

import com.example.API_ventaslocal.Model.Cliente;
import com.example.API_ventaslocal.Repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository iClienteRepository;


    @Override
    public List<Cliente> getClients() {
        return iClienteRepository.findAll();
    }

    @Override
    public Cliente getClient(Long id) {
        return iClienteRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteClient(Long id) {
        iClienteRepository.deleteById(id);
        return "Cliente Eliminado efectivamente";
    }

    @Override
    public Cliente saveClient(Cliente client) {
        return iClienteRepository.save(client);
    }

    @Override
    public Cliente editClient(Long id, Cliente client) {
        return null;
    }
}
