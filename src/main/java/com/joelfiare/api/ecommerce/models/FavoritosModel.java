package com.joelfiare.api.ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "favoritos", schema = "c16-47-n-java")
public class FavoritosModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_fav")
    private int idFav;
    @ManyToOne
    @JoinColumn(name = "id_usuario") // Aquí especificamos la columna de la clave foránea
    private UsuarioModel idUsuario;
    @ManyToOne
    @JoinColumn(name = "id_producto") // Aquí especificamos la columna de la clave foránea
    private ProductoModel idProducto;
}