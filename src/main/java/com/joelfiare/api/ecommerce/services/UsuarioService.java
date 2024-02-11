package com.joelfiare.api.ecommerce.services;

import com.joelfiare.api.ecommerce.models.ImagenModel;
import com.joelfiare.api.ecommerce.models.UsuarioModel;
import com.joelfiare.api.ecommerce.repositories.IImagenRepository;
import com.joelfiare.api.ecommerce.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    //Uso @Autowired para que Spring inyecte una instancia de IUsuarioRepository
    @Autowired
    IUsuarioRepository usuarioRepository;
    @Autowired
    IImagenRepository imagenRepository;

    //Uso el método findAll para obtener todos los usuarios
    public ArrayList<UsuarioModel> getUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    //Uso el método save para guardar un usuario
    public UsuarioModel saveUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    //Uso el método findById para obtener un usuario por su id
    //Uso Optional para que devuelva un null si no encuentra el usuario
    public Optional<UsuarioModel> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    //Uso el método save para actualizar un usuario
    public UsuarioModel updateById(UsuarioModel request, Long id) {
        //UsuarioModel user = usuarioRepository.findById(id).get();
        UsuarioModel user = usuarioRepository.findById(id).orElse(null); // Manejo de posible valor nulo

        if (user != null) {
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());

            // Obtener la instancia de ImagenModel correspondiente al idImagen del request
            ImagenModel imagen = request.getIdImagen();
            if (imagen != null) {
                ImagenModel imagenPersisted = imagenRepository.findById((long) imagen.getIdImagen()).orElse(null); // Suponiendo que tienes un repositorio para ImagenModel
                if (imagenPersisted != null) {
                    user.setIdImagen(imagenPersisted);
                } else {
                    // Manejo de error si la imagen no existe
                }
            } else {
                // Manejo si el campo idImagen es nulo en el request
            }

            return usuarioRepository.save(user);
        } else {
            // Manejo de usuario no encontrado
            return null;
        }

        //user.setUsername(request.getUsername());
        //user.setEmail(request.getEmail());
        //user.setPassword(request.getPassword());
        //user.setIdImagen(request.getIdImagen());
        //return usuarioRepository.save(user);
    }

    //Uso el método deleteById para eliminar un usuario por su id
    //Devuelvo un booleano para saber si se eliminó el usuario
    //Si se eliminó devuelvo true, si no se eliminó devuelvo false
    public boolean deleteUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
