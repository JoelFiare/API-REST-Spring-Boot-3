package com.joelfiare.api.ecommerce.services;

import com.joelfiare.api.ecommerce.models.ProductoModel;
import com.joelfiare.api.ecommerce.repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductoService {
    @Autowired
    IProductoRepository productoRepository;

    //Uso el método findAll para obtener todos los productos
    public ArrayList<ProductoModel> getProductos() {
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }

    //Uso el método save para guardar un producto
    public ProductoModel saveProducto(ProductoModel producto) {
        return productoRepository.save(producto);
    }

    //Uso el método findById para obtener un producto por su id
    //Uso Optional para que devuelva un null si no encuentra el producto
    public ProductoModel getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    //Uso el método save para actualizar un producto
    public ProductoModel updateById(ProductoModel request, Long id) {
        ProductoModel producto = productoRepository.findById(id).orElse(null); // Manejo de posible valor nulo

        if (producto != null) {
            producto.setNombre(request.getNombre());
            producto.setDescripcion(request.getDescripcion());
            producto.setPrecio(request.getPrecio());
            producto.setStock(request.getStock());
            return productoRepository.save(producto);
        } else {
            // Manejo de producto no encontrado
            throw new RuntimeException("Producto no encontrado");
        }
    }

    //Uso el método deleteById para eliminar un producto por su id
    //Devuelvo un booleano para saber si se eliminó el producto
    //Si se eliminó devuelvo true, si no se eliminó devuelvo false
    public boolean deleteProducto(Long id) {
        try {
            productoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
