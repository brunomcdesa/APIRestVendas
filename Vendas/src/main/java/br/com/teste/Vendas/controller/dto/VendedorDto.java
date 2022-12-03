package br.com.teste.Vendas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.teste.Vendas.model.Venda;
import br.com.teste.Vendas.model.Vendedor;
import br.com.teste.Vendas.repository.VendaRepository;

//Classe com os atributos que desejo retornar
public class VendedorDto {
	VendaRepository repository; 
	Venda venda;
	
	private String nome;
	private Long totalVendas;
	private double mediaVendas;
	
	public VendedorDto(Vendedor vendedor) {
		this.nome = vendedor.getNome();
		if(venda.getVendedor().getId() == vendedor.getId()) {
			this.totalVendas = repository.count();
		}
		
		this.mediaVendas = vendedor.getMediaVendas();
	}
	
	public String getNome() {
		return nome;
	}
	public Long getTotalVendas() {
		return totalVendas;
	}
	public double getMediaVendas() {
		return mediaVendas;
	}
	
	
	//Metodo para converter uma lista de Vendedor para uma lista de VendedorDto
	public static List<VendedorDto> converter (List<Vendedor> vendedores){
		return vendedores.stream().map(VendedorDto::new).collect(Collectors.toList());
	}
	
}
