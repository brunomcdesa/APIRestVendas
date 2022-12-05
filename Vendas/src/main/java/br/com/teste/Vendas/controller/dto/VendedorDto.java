package br.com.teste.Vendas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.teste.Vendas.model.Venda;
import br.com.teste.Vendas.model.Vendedor;
import br.com.teste.Vendas.repository.VendaRepository;

//Classe com os atributos que desejo retornar
public class VendedorDto {
	private String nome;
	private Long totalVendas;
	private double mediaVendas;
	
	public VendedorDto(Vendedor vendedor) {
		this.nome = vendedor.getNome();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTotalVendas(Long totalVendas) {
		this.totalVendas = totalVendas;
	}

	public void setMediaVendas(double mediaVendas) {
		this.mediaVendas = mediaVendas;
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
