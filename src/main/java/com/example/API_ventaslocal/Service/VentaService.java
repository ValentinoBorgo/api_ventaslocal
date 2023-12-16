package com.example.API_ventaslocal.Service;

import com.example.API_ventaslocal.Model.Venta;
import com.example.API_ventaslocal.Repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepository;


    @Override
    public List<Venta> getSales() {
        return ventaRepository.findAll();
    }

    @Override
    public void saveSale(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public String deleteSale(Long id) {
        ventaRepository.deleteById(id);
        return "Venta eliminada correctamente";
    }

    @Override
    public Venta editSale(Long id, Venta ventaModi) {
        Venta venta = this.searchSale(id);
        venta.setFecha_venta(ventaModi.getFecha_venta());
        venta.setTotal(ventaModi.getTotal());
        venta.setCliente(ventaModi.getCliente());
        venta.setListaProductos(ventaModi.getListaProductos());
        this.saveSale(venta);
        return venta;
    }

    @Override
    public Venta searchSale(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }
}
