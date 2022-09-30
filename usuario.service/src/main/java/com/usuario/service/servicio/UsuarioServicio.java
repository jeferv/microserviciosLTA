package com.usuario.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.feignClients.CarroFeignClient;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {

	// **** Implementacion con RestTemplate*******
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public List<Carro> getCarros(Integer usuarioId){
		List<Carro> carros = restTemplate.getForObject("http://localhost:8002/carro/usuario/" + usuarioId, List.class);
		return carros;
	}
	
	//**** Implementacion con FeignClient ******
	
	@Autowired
	private CarroFeignClient carroFeignClient;
	
	public Carro saveCarro(Integer usuarioId, Carro carro) {
		carro.setUsuarioId(usuarioId);
		Carro nuevoCarro = carroFeignClient.save(carro);
		return nuevoCarro;
	}
	
	public List<Moto> getMotos(Integer usuarioId){
		List<Moto> motos = restTemplate.getForObject("http://localhost:8003/moto/usuario/" + usuarioId, List.class);
		return motos;
	}
	
	public List<Usuario> getAll(){
		return usuarioRepositorio.findAll();
	}
	
	public Usuario getUsuarioById(Integer id) {
		return usuarioRepositorio.findById(id).orElse(null);
	}
	
	public Usuario save(Usuario usuario) {
		Usuario nuevoUsuario = usuarioRepositorio.save(usuario);
		return nuevoUsuario;
	}
}
