package com.joelfiare.api.ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "ordenes", schema = "c16-47-n-java")
public class OrdenesModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_orden")
    private int idOrden;
    @OneToOne
    @JoinColumn(name = "id_carrito")
    private CarritoModel idCarrito;
    @Column(name = "fecha_orden")
    private Date fechaOrden;
    private String estado;
}