package com.example.API_ventaslocal.Service;


import com.example.API_ventaslocal.Model.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> getProducts();
    
    public void saveProduct(Producto producto);

    public void deleteProduct(Long id);

    public Producto editProduct(Long id, Producto proModi);

    public Producto searchProduct(Long id);

    public List<Producto> getProductsLessThan5();

}
