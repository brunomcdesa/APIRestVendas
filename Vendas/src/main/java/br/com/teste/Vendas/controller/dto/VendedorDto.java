package br.com.teste.Vendas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;


import br.com.teste.Vendas.model.Vendedor;


//Classe com os atributos que desejo retornar
public class VendedorDto {
	private String nome;
	private Long qntVendas;
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

	public void setTotalVendas(Long qntVendas) {
		this.qntVendas = qntVendas;
	}

	public void setMediaVendas(double mediaVendas) {
		this.mediaVendas = mediaVendas;
	}

	public Long getTotalVendas() {
		return qntVendas;
	}
	public double getMediaVendas() {
		return mediaVendas;
	}
	
	
	//Metodo para converter uma lista de Vendedor para uma lista de VendedorDto
	public static List<VendedorDto> converter (List<Vendedor> vendedores){
		return vendedores.stream().map(VendedorDto::new).collect(Collectors.toList());
	}
	
}
