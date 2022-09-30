package com.usuario.service.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.usuario.service.modelos.Carro;

@FeignClient(name = "carro-service", url="http://localhost:8002/carro/")
public interface CarroFeignClient {

	@PostMapping("/{id}")
	public Carro save(@RequestBody Carro carro);
	
}
