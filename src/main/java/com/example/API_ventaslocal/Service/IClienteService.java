package com.example.API_ventaslocal.Service;


import com.example.API_ventaslocal.Model.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> getClients();

    public Cliente getClient(Long id);

    public String deleteClient(Long id);

    public Cliente saveClient(Cliente client);

    public Cliente editClient(Long id, Cliente client);

}
