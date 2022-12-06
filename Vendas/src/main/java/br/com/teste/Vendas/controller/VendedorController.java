package br.com.teste.Vendas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.teste.Vendas.controller.dto.VendedorDto;
import br.com.teste.Vendas.controller.form.VendedorForm;
import br.com.teste.Vendas.interfa.VendedorInterface;
import br.com.teste.Vendas.model.Vendedor;
import br.com.teste.Vendas.repository.VendedorRepository;


@RestController
@RequestMapping("/vendedores")
public class VendedorController {
	
	
	//faz a ligacao com a tabela de vendedor no banco de dados
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@GetMapping
	public List<VendedorInterface> listaVendedor(String nome){
		if(nome == null) {
			List<VendedorInterface> resultado = vendedorRepository.camposASerRetornados( );
			return resultado;
		}else {
			List<VendedorInterface> resultado = vendedorRepository.findByNome(nome);
			return resultado;
		}
		}
	
	
	@PostMapping
	public ResponseEntity<VendedorDto> cadastrarVendedor(@RequestBody VendedorForm form, UriComponentsBuilder uriBuilder) {
		Vendedor vendedor = form.converter();
		vendedorRepository.save(vendedor);
		
		URI uri = uriBuilder.path("/vendedores/{nome}").buildAndExpand(vendedor.getId()).toUri();
		return ResponseEntity.created(uri).body(new VendedorDto(vendedor));
	}

}
