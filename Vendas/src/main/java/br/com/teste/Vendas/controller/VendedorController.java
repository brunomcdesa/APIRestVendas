package br.com.teste.Vendas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.teste.Vendas.controller.dto.VendedorDto;
import br.com.teste.Vendas.controller.form.AtualizaVendedorForm;
import br.com.teste.Vendas.controller.form.VendedorForm;
import br.com.teste.Vendas.model.Vendedor;
import br.com.teste.Vendas.repository.VendedorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


//Controller de VENDEDOR, onde é feito o CRUD
@RestController
@RequestMapping("/vendedores")
public class VendedorController {
	 
	
	//faz a ligacao com a tabela de vendedor no banco de dados
	@Autowired
	private VendedorRepository vendedorRepository;
	 
	
	//Metodo para GET ALL (LISTAR TODAS OS VENDEDORES EXISTENTES) e GET por parametro
	@GetMapping
	public List<VendedorDto> listaVendedor(String nome){
		if(nome == null) {
			List<Vendedor> vendedores = vendedorRepository.findAll();
			List<VendedorDto> vendedoresDto = VendedorDto.converter(vendedores);
			return vendedoresDto;
		}else {
			List<Vendedor> vendedor = vendedorRepository.findByNome(nome);
			List<VendedorDto> vendedoresDto = VendedorDto.converter(vendedor);
			return vendedoresDto;
		}
	}
	
	//Metodo para GET POR ID (PEGAR INFORMAÇÕES DE UM VENDEDOR ESPECIFICO)
	@GetMapping("/{id}")
	public VendedorDto detalharVendedor(@PathVariable Long id) {
		Vendedor vendedor = vendedorRepository.getReferenceById(id);
		return new VendedorDto(vendedor);
	}
	
	//Metodo para POST (CADASTRAR UMA NOVO VENDEDOR)
	@Transactional
	@PostMapping
	public ResponseEntity<VendedorDto> cadastrarVendedor(@RequestBody @Valid VendedorForm form, UriComponentsBuilder uriBuilder) {
		Vendedor vendedor = form.converter();
		vendedorRepository.save(vendedor);
		
		URI uri = uriBuilder.path("/vendedores/{id}").buildAndExpand(vendedor.getId()).toUri();
		return ResponseEntity.created(uri).body(new VendedorDto(vendedor));
	}
	
	//Metodo para PUT (ATUALIZAR VENDEDOR)
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VendedorDto> atualuzaVendedor(@PathVariable Long id, @RequestBody @Valid AtualizaVendedorForm form){
		Vendedor vendedor = form.atualizar(id, vendedorRepository);
		
		return ResponseEntity.ok(new VendedorDto(vendedor));
	}
	
	
	//Metodo para DELETE (APAGAR VENDEDOR)
	//A REMOCAO SO VAI OCORRER QUANDO NAO TIVER MAIS NENHUMA VENDA LIGADA AO VENDEDOR.
	//CASO A QUANTIDADE DE VENDAS DO VENDEDOR SEJA MAIOR QUE 0, ELE NÃO VAI DELETAR
	//PARA DELETAR O VENDEDOR, DELETE A VENDA LIGADA A ELE
	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerVendedor(@PathVariable Long id){
		vendedorRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
