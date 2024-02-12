package com.joelfiare.api.ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "imagen", schema = "c16-47-n-java")
public class ImagenModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_imagen")
    private int idImagen;
    private String mime;
    private String nombre;
    private byte[] contenido;
}