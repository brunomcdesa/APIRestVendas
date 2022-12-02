package br.com.teste.Vendas.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.Vendas.controller.dto.VendedorDto;
import br.com.teste.Vendas.model.Vendedor;
import br.com.teste.Vendas.repository.VendedorRepository;


@RestController
public class VendedorController {
	//faz a ligacao com a tabela de vendedor no banco de dados
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@RequestMapping("/vendedores")
	public List<VendedorDto> lista(){
		List<Vendedor> vendedores = vendedorRepository.findAll();
		return VendedorDto.converter(vendedores); 
	}

}
