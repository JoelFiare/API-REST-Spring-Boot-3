package com.nocountry.c1647njava.ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "ordenes", schema = "c16-47-n-java", catalog = "")
public class OrdenesModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_orden")
    private int idOrden;
    @Basic
    @Column(name = "id_carrito")
    private Integer idCarrito;
    @Basic
    @Column(name = "fecha_orden")
    private Date fechaOrden;
    @Basic
    @Column(name = "estado")
    private String estado;
}
