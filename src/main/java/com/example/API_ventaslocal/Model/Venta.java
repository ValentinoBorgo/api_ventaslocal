package com.example.API_ventaslocal.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;
    @OneToMany
    private List<Producto> listaProductos;

    @OneToOne
    @JoinColumn(name = "venta_id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

}
