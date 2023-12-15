package com.example.API_ventaslocal.Service;

import com.example.API_ventaslocal.Model.Producto;
import com.example.API_ventaslocal.Repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepository;


    @Override
    public List<Producto> getProducts() {
        List<Producto> productoList = productoRepository.findAll();
        return productoList;
    }

    @Override
    public void saveProduct(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteProduct(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto editProduct(Long id, Producto proModi) {
        Producto pro = this.searchProduct(id);
        pro.setNombre(proModi.getNombre());
        pro.setCosto(proModi.getCosto());
        pro.setMarca(proModi.getMarca());
        pro.setCantidad_disponible(proModi.getCantidad_disponible());
        this.saveProduct(pro);
        return pro;
    }

    @Override
    public Producto searchProduct(Long id) {
        Producto pro = productoRepository.findById(id).orElse(null);
        return pro;
    }
}
