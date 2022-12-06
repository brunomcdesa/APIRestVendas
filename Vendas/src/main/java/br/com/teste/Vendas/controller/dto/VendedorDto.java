package br.com.teste.Vendas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;


import br.com.teste.Vendas.model.Vendedor;


//Classe com os atributos que desejo retornar
public class VendedorDto {
	private Long id;
	private String nome;
	private Long qntVendas;
	private double mediaVendas;
	
	public VendedorDto(Vendedor vendedor) {
		this.id = vendedor.getId();
		this.nome = vendedor.getNome();
		this.qntVendas = vendedor.getTotalVendas();
		this.mediaVendas = vendedor.getMediaVendas();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQntVendas() {
		return qntVendas;
	}

	public void setQntVendas(Long qntVendas) {
		this.qntVendas = qntVendas;
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
