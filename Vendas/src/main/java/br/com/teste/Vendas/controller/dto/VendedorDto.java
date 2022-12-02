package br.com.teste.Vendas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.teste.Vendas.model.Vendedor;

//Classe com os atributos que desejo retornar
public class VendedorDto {
	private String nome;
	private int totalVendas;
	private double mediaVendas;
	
	public VendedorDto(Vendedor vendedor) {
		this.nome = vendedor.getNome();
		this.totalVendas = vendedor.getTotalVendas();
		this.mediaVendas = vendedor.getMediaVendas();
	}
	
	public String getNome() {
		return nome;
	}
	public int getTotalVendas() {
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
