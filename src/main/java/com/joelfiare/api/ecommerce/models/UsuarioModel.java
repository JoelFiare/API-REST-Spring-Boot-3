package com.joelfiare.api.ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario", schema = "c16-47-n-java")
public class UsuarioModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_usuario")
    private int idUsuario;
    private String username;
    private String email;
    private String password;
    @OneToOne
    @JoinColumn(name = "id_imagen", referencedColumnName = "id_imagen")
    private ImagenModel idImagen;


    //@Column(name = "id_imagen")
    //private Integer idImagen;
}