package com.joelfiare.api.ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@Table(name = "producto", schema = "c16-47-n-java")
public class ProductoModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_producto")
    private int idProducto;
    private String nombre;
    private String categoria;
    private String descripcion;
    private BigDecimal precio;
    private String imagen;
    private BigDecimal calificacion;
    private Integer favoritos;
    private Integer stock;
}
