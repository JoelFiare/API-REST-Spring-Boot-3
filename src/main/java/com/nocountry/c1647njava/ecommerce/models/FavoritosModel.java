package com.nocountry.c1647njava.ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "favoritos", schema = "c16-47-n-java", catalog = "")
public class FavoritosModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_fav")
    private int idFav;
    @Basic
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic
    @Column(name = "id_producto")
    private Integer idProducto;
}
