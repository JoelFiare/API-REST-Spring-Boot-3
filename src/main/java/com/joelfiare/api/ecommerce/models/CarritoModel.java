package com.joelfiare.api.ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "carrito", schema = "c16-47-n-java")
public class CarritoModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_carrito")
    private int idCarrito;
    @ManyToOne
    @JoinColumn(name = "id_usuario") // Aquí especificamos la columna de la clave foránea
    private UsuarioModel idUsuario;
    @ManyToOne
    @JoinColumn(name = "id_producto") // Aquí especificamos la columna de la clave foránea
    private ProductoModel idProducto;
    private Integer cantidad;
    private BigDecimal total;
    private Date fecha;
}