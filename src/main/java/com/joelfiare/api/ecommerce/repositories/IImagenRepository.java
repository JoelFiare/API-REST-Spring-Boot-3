package com.joelfiare.api.ecommerce.repositories;

import com.joelfiare.api.ecommerce.models.ImagenModel;
import com.joelfiare.api.ecommerce.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImagenRepository extends JpaRepository<ImagenModel, Long>{

}
