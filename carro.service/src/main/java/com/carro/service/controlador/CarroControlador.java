package com.carro.service.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carro.service.entidades.Carro;
import com.carro.service.servicio.CarroServicio;


@RestController
@RequestMapping("/carro")
public class CarroControlador {

	@Autowired
	private CarroServicio carroServicio;
	
	@GetMapping
	public ResponseEntity<List<Carro>> listaCarros(){
		List<Carro> carros = carroServicio.getAll();
		if(carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
	}	 
	
	@GetMapping("/{id}")
	public ResponseEntity<Carro> obtenerCarro(@PathVariable("id") Integer id){
		Carro carro = carroServicio.getCarroById(id);
		if(carro == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carro);
	}
	@PostMapping
	public ResponseEntity<Carro> guardarCarro(@RequestBody Carro carro){
		Carro carroNuevo = carroServicio.save(carro);
		return ResponseEntity.ok(carroNuevo);
	}
	
	@GetMapping("/usuario/usuarioId")
	public ResponseEntity<List<Carro>> listarCarrosPorUsuarioId(@PathVariable("usuarioId") Integer id){
		List<Carro> carros = carroServicio.byUsuarioId(id);
		if(carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
	}
}
