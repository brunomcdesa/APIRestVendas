package br.com.teste.Vendas.controller.form;

import br.com.teste.Vendas.model.Vendedor;

public class VendedorForm {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Vendedor converter() {
		
		return new Vendedor(nome);
	}
	
	

}
