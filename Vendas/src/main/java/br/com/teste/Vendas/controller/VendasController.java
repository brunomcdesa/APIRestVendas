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

import br.com.teste.Vendas.controller.dto.VendaDto;
import br.com.teste.Vendas.controller.form.AtualizaVendaForm;
import br.com.teste.Vendas.controller.form.VendaForm;
import br.com.teste.Vendas.model.Venda;
import br.com.teste.Vendas.repository.VendaRepository;
import br.com.teste.Vendas.repository.VendedorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

//Controller de VENDEDOR, onde é feito o CRUD
@RestController //Assume que  por padrão todos os metodos serão ResponseBody
@RequestMapping("/vendas") // Mapeia o endpoind da aplicação... a rota no navegador
public class VendasController {
	
	//faz a ligacao com a tabela de venda no banco de dados
	@Autowired
	private VendaRepository vendaRepository;
	
	//faz a ligacao com a tabela de vendedor no banco de dados
	@Autowired
	private VendedorRepository vendedorRepository;
	
	//Metodo para GET ALL (LISTAR TODAS AS VENDAS EXISTENTES) e GET por parametro
	@GetMapping
	public List<VendaDto> listaVenda(Long id){
		if(id == null) {
			List<Venda> vendas = vendaRepository.findAll();
			return VendaDto.converter(vendas);
		}else {
			List<Venda> vendas = vendaRepository.findByVendedorId(id);
			return VendaDto.converter(vendas);
		}
	}
	
	//Metodo para GET POR ID (PEGAR INFORMAÇÕES DE UMA VENDA ESPECIFICA)
	@GetMapping("/{id}")
	public VendaDto detalhaVenda(@PathVariable Long id) {
		Venda venda = vendaRepository.getReferenceById(id);
		return new VendaDto(venda);
	}

	//Metodo para POST (CADASTRAR UMA NOVA VENDA)
	@PostMapping
	public ResponseEntity<VendaDto> cadatraVenda(@RequestBody @Valid VendaForm form, UriComponentsBuilder uriBuilder) {
		Venda venda = form.converter(vendedorRepository);
		vendaRepository.save(venda);
		
		URI uri = uriBuilder.path("/vendas/{id}").buildAndExpand(venda.getId()).toUri();
		return ResponseEntity.created(uri).body(new VendaDto(venda));
	}
	
	//Metodo para PUT (ATUALIZAR VENDA)
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VendaDto> atualizaVenda(@PathVariable Long id, @RequestBody @Valid AtualizaVendaForm form ) {
		Venda venda = form.atualizar(id, vendaRepository, vendedorRepository);
		
		return ResponseEntity.ok(new VendaDto(venda));
	}
	
	//Metodo para DELETE (APAGAR VENDA)
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerVenda(@PathVariable Long id){
		vendaRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
