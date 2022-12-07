package br.com.teste.Vendas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.teste.Vendas.model.Vendedor;


//Classe com os atributos que desejo retornar
public class VendedorDto {
	private Long id;
	private String nome;
	private int qntVendas;
	//private Double valorTotalVendas;
	//private Double mediaVendas;
	
	public VendedorDto(Vendedor vendedor) {
		this.id = vendedor.getId();
		this.nome = vendedor.getNome();
	
		//AQUI E ONDE DEFINE A QUANTIDADE DE VENDAS LIGADAS A CADA VENDEDOR
		this.qntVendas = vendedor.getVendas().size();
		//this.mediaVendas = vendedor.getMediaVendas();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQntVendas() {
		return qntVendas;
	}

	public void setQntVendas(int qntVendas) {
		this.qntVendas = qntVendas;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
//	public Double getValorTotalVendas() {
//		return valorTotalVendas;
//	}
//
//	public void setValorTotalVendas(double valorTotalVendas) {
//		this.valorTotalVendas = valorTotalVendas;
//	}
	
	//Metodo para converter uma lista de Vendedor para uma lista de VendedorDto
	public static List<VendedorDto> converter (List<Vendedor> vendedores){
		return vendedores.stream().map(VendedorDto::new).collect(Collectors.toList());
	}

	
	
}
