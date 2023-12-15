package com.example.API_ventaslocal.Controller;

import com.example.API_ventaslocal.Model.Cliente;
import com.example.API_ventaslocal.Service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @GetMapping("/clientes")
    public List<Cliente> getClients(){
        return iClienteService.getClients();
    }

    @GetMapping("/clientes/{id_cliente}")
    public Cliente getClient(@PathVariable Long id){
        return iClienteService.getClient(id);
    }

    @PostMapping("/clientes/crear")
    public Cliente saveClient(@RequestBody Cliente cliente){
        return iClienteService.saveClient(cliente);
    }

}
