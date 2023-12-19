package com.example.API_ventaslocal.Service;

import com.example.API_ventaslocal.Model.Producto;
import com.example.API_ventaslocal.Model.Venta;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    public List<Venta> getSales();

    public List<Producto> getListOfProductosOfSale(Long id);

    public String saveSale(Venta venta);

    public String deleteSale(Long id);

    public Venta editSale(Long id, Venta ventaModi);

    public Venta searchSale(Long id);

    public String getAmountAndTotalOfSalesInADay(LocalDate date);

    public String getDataOfTheMostExpensiveSale();

}
