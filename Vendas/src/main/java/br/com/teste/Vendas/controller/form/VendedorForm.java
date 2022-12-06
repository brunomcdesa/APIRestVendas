package br.com.teste.Vendas.controller.form;

import org.hibernate.validator.constraints.Length;

import br.com.teste.Vendas.model.Vendedor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class VendedorForm {
	
	@NotEmpty @NotNull @Length(min = 5)
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
