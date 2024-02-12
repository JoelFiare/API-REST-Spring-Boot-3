package com.joelfiare.api.ecommerce.controllers;

import com.joelfiare.api.ecommerce.models.ProductoModel;
import com.joelfiare.api.ecommerce.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    //Uso @GetMapping para que el método responda a una petición GET
    @GetMapping
    public ArrayList<ProductoModel> getProductos() {
        return productoService.getProductos();
    }

    //Uso @RequestBody para que el producto se envíe en el cuerpo de la petición
    @PostMapping
    public ProductoModel saveProducto(@RequestBody ProductoModel producto) {
        return this.productoService.saveProducto(producto);
    }

    //Uso @PathVariable para obtener el id que se envía como parámetro
    @GetMapping(path = "/{id}")
    public ProductoModel getProductoById(@PathVariable("id") Long id) {
        return this.productoService.getProductoById(id);
    }

    //Uso @PutMapping para que el método responda a una petición PUT
    //Uso @RequestBody para que el producto se envíe en el cuerpo de la petición
    //Uso @PathVariable para obtener el id que se envía como parámetro
    @PutMapping(path = "/{id}")
    public ProductoModel updateProductoById(@RequestBody ProductoModel request, @PathVariable("id") Long id) {
        return this.productoService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteProducto(@PathVariable("id") Long id) {
        boolean ok = this.productoService.deleteProducto(id);
        if (ok) {
            return "Se eliminó el producto con id " + id;
        } else {
            return "No se pudo eliminar el producto con id " + id;
        }
    }
}
