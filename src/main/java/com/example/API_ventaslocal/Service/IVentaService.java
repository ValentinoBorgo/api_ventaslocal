package com.example.API_ventaslocal.Service;

import com.example.API_ventaslocal.Model.Producto;
import com.example.API_ventaslocal.Model.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> getSales();

    public void saveSale(Venta venta);

    public String deleteSale(Long id);

    public Venta editSale(Long id, Venta ventaModi);

    public Venta searchSale(Long id);

}
