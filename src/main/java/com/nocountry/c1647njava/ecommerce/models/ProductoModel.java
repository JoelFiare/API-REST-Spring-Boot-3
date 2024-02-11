package com.nocountry.c1647njava.ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@Table(name = "producto", schema = "c16-47-n-java", catalog = "")
public class ProductoModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_producto")
    private int idProducto;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "categoria")
    private String categoria;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "precio")
    private BigDecimal precio;
    @Basic
    @Column(name = "imagen")
    private String imagen;
    @Basic
    @Column(name = "calificacion")
    private BigDecimal calificacion;
    @Basic
    @Column(name = "favoritos")
    private Integer favoritos;
    @Basic
    @Column(name = "stock")
    private Integer stock;
}
