package com.example.API_ventaslocal.Service;

import com.example.API_ventaslocal.Model.Producto;
import com.example.API_ventaslocal.Model.Venta;
import com.example.API_ventaslocal.Repository.IProductoRepository;
import com.example.API_ventaslocal.Repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    private ProductoService productoService;



    @Override
    public List<Venta> getSales() {
        return ventaRepository.findAll();
    }

    @Override
    public String saveSale(Venta venta) {
        Map<Producto, Double> mapOfProducts = new HashMap<>();
        List<Producto> listProducts = venta.getListaProductos();
        List<Producto> listProductsNoAmount;
        listProductsNoAmount = new ArrayList<>();
        for (Producto p : listProducts){
            Producto cantProd = productoService.searchProduct(p.getCodigo_producto());
            if(p.getCantidad_disponible() <= cantProd.getCantidad_disponible()){
                //AMOUT OF PRODUCTS
                Double newAmount = cantProd.getCantidad_disponible() - p.getCantidad_disponible();
                //Save products and amounts
                mapOfProducts.put(cantProd, newAmount);
            }else {
                listProductsNoAmount.add(p);
            }
        }

        //I go through the HashMap to see if the number of products
        // it contains matches the number of products from the sale brought
        int contProducts = 0;
        for (Map.Entry<Producto, Double> entry : mapOfProducts.entrySet()){
            Producto product = entry.getKey();
            contProducts++;
        }


        //I validate that the size of the array of the list of products is equal to the size of the product type
        //objects in the previous hashmap and then I modify the product and make the sale
        if(listProducts.size() == contProducts){
            for (Map.Entry<Producto, Double> entry : mapOfProducts.entrySet()){
                Producto product = entry.getKey();
                Double newAmount = entry.getValue();
                product.setCantidad_disponible(newAmount);
                productoService.editProduct(product.getCodigo_producto(), product);
            }
            ventaRepository.save(venta);
        }else {
            String valueError = "";
            for (Producto p : listProductsNoAmount){
                valueError += "El Producto " + p.getNombre() + " exede la cantidad de mercaderia que indica "
                        + p.getCantidad_disponible() + "\n";
            }
            return valueError;
        }
        return "Venta Guardada con exito";
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
