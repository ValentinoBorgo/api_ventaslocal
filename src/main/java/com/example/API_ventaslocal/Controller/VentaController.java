package com.example.API_ventaslocal.Controller;

import com.example.API_ventaslocal.Model.Producto;
import com.example.API_ventaslocal.Model.Venta;
import com.example.API_ventaslocal.Service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService iVentaService;

    @GetMapping("/ventas")
    public List<Venta> getSales(){
        return iVentaService.getSales();
    }

    @GetMapping("/ventas/{codigo_venta}")
    public ResponseEntity<?> getSale(@PathVariable Long codigo_venta){
        Venta venta = iVentaService.searchSale(codigo_venta);

        if(venta == null){
            return new ResponseEntity<>("No se encontro la venta requerida", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(venta, HttpStatus.OK);
        }
    }

    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> getListOfProductosOfSale(@PathVariable Long codigo_venta){
        return iVentaService.getListOfProductosOfSale(codigo_venta);
    }

    @GetMapping("/ventas/dia/{fecha_venta}")
    public String getAmountAndTotalOfSalesInADay(@PathVariable LocalDate fecha_venta){
        return iVentaService.getAmountAndTotalOfSalesInADay(fecha_venta);
    }

    @GetMapping("/ventas/mayor_venta")
    public String getDataOfTheMostExpensiveSale(){
        return iVentaService.getDataOfTheMostExpensiveSale();
    }

    @PostMapping("/ventas/crear")
    public String saveSale(@RequestBody Venta venta){
        return iVentaService.saveSale(venta);
    }

    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public ResponseEntity<?> deleteSale(@PathVariable Long codigo_venta, Venta venta){

        Venta v = iVentaService.searchSale(codigo_venta);

        if(v != null && venta != null){
            return new ResponseEntity<>(iVentaService.deleteSale(codigo_venta), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Venta no encontrada o valores no validos, revisar", HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editSale(@PathVariable Long codigo_venta, @RequestBody Venta venta){
        return iVentaService.editSale(codigo_venta, venta);
    }


}
