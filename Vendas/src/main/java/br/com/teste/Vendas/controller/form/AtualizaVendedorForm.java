package br.com.teste.Vendas.controller.form;

import org.hibernate.validator.constraints.Length;

import br.com.teste.Vendas.model.Vendedor;
import br.com.teste.Vendas.repository.VendedorRepository;
import jakarta.validation.constraints.NotEmpty;

public class AtualizaVendedorForm {
	@NotEmpty  @Length(min = 5)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Vendedor atualizar(Long id, VendedorRepository repository) {
		Vendedor vendedor = repository.getReferenceById(id);
		
		vendedor.setNome(this.nome);
		
		return vendedor;
	}

}
