package com.zup.controledeveiculos.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zup.controledeveiculos.domain.FipeDomain;



@Service
@FeignClient(name = "apiService", url = "https://parallelum.com.br/fipe/api/v1/carros/marcas")
public interface ApiService {
	
	@GetMapping(value = "/{brand}/modelos/{model}/anos/{year}")
	public FipeDomain buscarCarroNaFipe(@PathVariable String brand, 
			 							 @PathVariable String model,
			 							 @PathVariable String year);
}
