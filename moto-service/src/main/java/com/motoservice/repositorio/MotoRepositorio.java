package com.motoservice.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.motoservice.entidades.Moto;

@Repository
public interface MotoRepositorio extends JpaRepository<Moto, Integer>{
	
	List<Moto> findByUsuarioId(Integer usuarioId);

}
