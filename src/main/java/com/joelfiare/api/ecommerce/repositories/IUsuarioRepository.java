package com.joelfiare.api.ecommerce.repositories;

import com.joelfiare.api.ecommerce.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long>{

}
