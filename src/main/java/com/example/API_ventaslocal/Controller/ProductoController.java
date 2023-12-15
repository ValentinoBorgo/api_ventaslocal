package com.example.API_ventaslocal.Controller;

import com.example.API_ventaslocal.Model.Producto;
import com.example.API_ventaslocal.Service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Period;
import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService IProductoService;

    @GetMapping("/productos")
    public List<Producto> getProducts(){
        List<Producto> productoList = IProductoService.getProducts();
        return productoList;
    }

    @GetMapping("/productos/{codigo_producto}")
    public Producto getProduct(@PathVariable Long codigo_producto){
        return IProductoService.searchProduct(codigo_producto);
    }

    @PostMapping("/productos/crear")
    public String saveProduct(@RequestBody Producto producto){
        IProductoService.saveProduct(producto);
        return "Producto agregado :)";
    }

    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProduct(@PathVariable Long codigo_producto){
        IProductoService.deleteProduct(codigo_producto);
        return "Producto Eliminado efectivamente";
    }

    @PutMapping("productos/editar/{codigo_producto}")
    public Producto editProduct(@PathVariable Long codigo_producto, @RequestBody Producto proModi){
        return IProductoService.editProduct(codigo_producto, proModi);
    }


}
