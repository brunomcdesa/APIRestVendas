package br.com.teste.Vendas.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.Vendas.controller.dto.VendedorDto;
import br.com.teste.Vendas.controller.form.VendedorForm;
import br.com.teste.Vendas.model.Venda;
import br.com.teste.Vendas.model.Vendedor;
import br.com.teste.Vendas.repository.VendaRepository;
import br.com.teste.Vendas.repository.VendedorRepository;


@RestController
@RequestMapping("/vendedores")
public class VendedorController {
	
	
	//faz a ligacao com a tabela de vendedor no banco de dados
	@Autowired
	private VendedorRepository vendedorRepository;
	@Autowired
	private VendaRepository vendaRepository;
	
	
	@GetMapping
	public List<VendedorDto> listaVendedor(){
		
		List<Vendedor> vendedores = vendedorRepository.findAll();
		List<Venda> vendas = vendaRepository.findAll();
		
		for(int i=0; i>=vendedores.size(); i++) {
			vendedores.get(i).setTotalVendas(vendedorRepository.countByVendas(vendedores.get(i).getId())); 
		}
		
		return VendedorDto.converter(vendedores);
	}
	
	@PostMapping
	public void cadastrarVendedor(@RequestBody VendedorForm form) {
		Vendedor vendedor = form.converter();
		
		vendedorRepository.save(vendedor);
	}

}
