package br.com.teste.Vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.Vendas.controller.dto.VendaDto;
import br.com.teste.Vendas.controller.form.VendaForm;
import br.com.teste.Vendas.model.Venda;
import br.com.teste.Vendas.repository.VendaRepository;
import br.com.teste.Vendas.repository.VendedorRepository;

@RestController //Assume que  por padrão todos os metodos serão ResponseBody
@RequestMapping("/vendas") // Mapeia o endpoind da aplicação... a rota no navegador
public class VendasController {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	@GetMapping
	public List<VendaDto> listaVenda(){
		List<Venda> vendas = vendaRepository.findAll();
		return VendaDto.converter(vendas);
	}
	
	@PostMapping
	public void cadatraVenda(@RequestBody VendaForm form) {
		Venda venda = form.converter(vendedorRepository);
		
		vendaRepository.save(venda);
		
	}
	
	
}
