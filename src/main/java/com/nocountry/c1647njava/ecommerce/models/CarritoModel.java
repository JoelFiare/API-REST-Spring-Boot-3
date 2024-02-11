package com.nocountry.c1647njava.ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "carrito", schema = "c16-47-n-java", catalog = "")
public class CarritoModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_carrito")
    private int idCarrito;
    @Basic
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic
    @Column(name = "total")
    private BigDecimal total;
    @Basic
    @Column(name = "fecha")
    private Date fecha;
}
