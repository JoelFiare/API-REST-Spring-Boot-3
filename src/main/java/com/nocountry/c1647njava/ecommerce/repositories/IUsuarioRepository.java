package com.nocountry.c1647njava.ecommerce.repositories;

import com.nocountry.c1647njava.ecommerce.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long>{

}
