package com.joelfiare.api.ecommerce.controllers;

import com.joelfiare.api.ecommerce.services.UsuarioService;
import com.joelfiare.api.ecommerce.models.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    //Uso @Autowired para que Spring inyecte una instancia de UsuarioService
    @Autowired
    private UsuarioService usuarioService;

    //Uso @GetMapping para que el método responda a una petición GET
    @GetMapping
    public ArrayList<UsuarioModel> getUsuarios(){
        return usuarioService.getUsuarios();
    }

    //Uso @RequestBody para que el usuario se envíe en el cuerpo de la petición
    @PostMapping
    public UsuarioModel saveUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.saveUsuario(usuario);
    }

    //Uso @PathVariable para obtener el id que se envía como parámetro
    //Uso Optional para que devuelva un null si no encuentra el usuario
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> getUsuarioById(@PathVariable("id") Long id){
        return this.usuarioService.getUsuarioById(id);
    }

    //Uso @PutMapping para que el método responda a una petición PUT
    //Uso @RequestBody para que el usuario se envíe en el cuerpo de la petición
    //Uso @PathVariable para obtener el id que se envía como parámetro
    @PutMapping(path = "/{id}")
    public UsuarioModel updateUserById(@RequestBody UsuarioModel request,@PathVariable("id") Long id) {
        return this.usuarioService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUsuario(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.deleteUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No se pudo eliminar el usuario con id " + id;
        }
    }
}
