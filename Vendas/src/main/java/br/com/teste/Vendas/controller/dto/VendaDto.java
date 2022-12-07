package br.com.teste.Vendas.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.teste.Vendas.model.Venda;

//Nesta classe, serão definidos os atributos que deverão ser retornados nos metodos GET
public class VendaDto {
	private LocalDateTime dataVenda;
	private double valor;
	private Long idVendedor;
	private String vendedor;
	
	public VendaDto(Venda venda) {
		this.dataVenda = venda.getDataVenda();
		this.valor = venda.getValor();
		this.idVendedor = venda.getVendedor().getId();
		this.vendedor = venda.getVendedor().getNome();
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public double getValor() {
		return valor;
	}

	public Long getIdVendedor() {
		return idVendedor;
	}
	
	public String getVendedor() {
		return vendedor;
	}
	
	//Metodo para converter uma lista de Vendedor para uma lista de VendedorDto
		public static List<VendaDto> converter (List<Venda> vendas){
			return vendas.stream().map(VendaDto::new).collect(Collectors.toList());
		}
	

}
