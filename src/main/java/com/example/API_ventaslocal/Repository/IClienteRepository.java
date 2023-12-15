package com.example.API_ventaslocal.Repository;

import ch.qos.logback.core.net.server.Client;
import com.example.API_ventaslocal.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
