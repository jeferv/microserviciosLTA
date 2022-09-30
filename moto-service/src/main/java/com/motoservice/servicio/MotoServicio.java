package com.motoservice.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motoservice.entidades.Moto;
import com.motoservice.repositorio.MotoRepositorio;

@Service
public class MotoServicio {

	@Autowired
	private MotoRepositorio motoRepositorio;

	public List<Moto> getAll() {
		return motoRepositorio.findAll();
	}

	public Moto getMotoById(Integer id) {
		return motoRepositorio.findById(id).orElse(null);
	}

	public Moto save(Moto moto) {
		Moto nuevaMoto = motoRepositorio.save(moto);
		return nuevaMoto;
	}
	
	public List<Moto> byUsuarioId(Integer usuarioId){
		return motoRepositorio.findByUsuarioId(usuarioId);		
	}

}
