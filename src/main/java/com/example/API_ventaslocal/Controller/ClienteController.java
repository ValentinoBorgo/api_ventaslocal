package com.example.API_ventaslocal.Controller;

import com.example.API_ventaslocal.Model.Cliente;
import com.example.API_ventaslocal.Service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getClient(@PathVariable Long id_cliente){
        Cliente cliente = iClienteService.getClient(id_cliente);

        if(cliente == null){
            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
    }

    @PostMapping("/clientes/crear")
    public Cliente saveClient(@RequestBody Cliente cliente){
        return iClienteService.saveClient(cliente);
    }

    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteClient(@PathVariable Long id_cliente){
        return iClienteService.deleteClient(id_cliente);
    }

    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editClient(@PathVariable Long id_cliente, @RequestBody Cliente cliente){
        return iClienteService.editClient(id_cliente, cliente);
    }

}
