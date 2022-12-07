package br.com.teste.Vendas.controller.form;

import java.util.Optional;

import br.com.teste.Vendas.model.Venda;
import br.com.teste.Vendas.model.Vendedor;
import br.com.teste.Vendas.repository.VendedorRepository;

//Classe com os campos que deverão ser cadastrados 
public class VendaForm {
	
	//ID NÃO PRECISA POR AUTO INCREMENTAR NO BANCO DE DADOS
	//DATA DA VENDA É CRIANA NO MOMENTO EM QUE ESTÁ FAZENDO A VENDA
	private double valor;
	private Long idVendedor;
	private String nomeVendedor;
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Long getIdVendedor() {
		return idVendedor;
	}
	
	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}
	
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public Venda converter(VendedorRepository vendedorRepository) {
		Optional<Vendedor> optVendedor = vendedorRepository.findById(idVendedor);
		Vendedor vendedor = optVendedor.get();
		return new Venda(valor, vendedor);
	}
}
