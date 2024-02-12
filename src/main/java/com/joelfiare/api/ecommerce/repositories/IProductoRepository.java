package com.joelfiare.api.ecommerce.repositories;

import com.joelfiare.api.ecommerce.models.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<ProductoModel, Long> {

}