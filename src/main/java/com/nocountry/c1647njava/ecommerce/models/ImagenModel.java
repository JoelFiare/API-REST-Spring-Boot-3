package com.nocountry.c1647njava.ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Data
@Table(name = "imagen", schema = "c16-47-n-java", catalog = "")
public class ImagenModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_imagen")
    private int idImagen;
    @Basic
    @Column(name = "mime")
    private String mime;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "contenido")
    private byte[] contenido;
}
