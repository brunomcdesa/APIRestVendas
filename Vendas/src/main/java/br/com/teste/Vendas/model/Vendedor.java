package br.com.teste.Vendas.model;

import java.util.ArrayList;
import java.util.List;

import br.com.teste.Vendas.repository.VendaRepository;
import br.com.teste.Vendas.repository.VendedorRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Query;

//Classe para criação da entidade no banco de dados
@Entity
public class Vendedor {	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@OneToMany(mappedBy = "vendedor")
	private List<Venda> vendas = new ArrayList<>();
	private Long totalVendas;
	private double mediaVendas;
	
	public Vendedor() {}
	
	public Vendedor(String nome) {
		this.nome = nome;
		
	
	}
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public Long getTotalVendas() {
		return totalVendas;
	}

	public double getMediaVendas() {
		return mediaVendas;
	}
	
	
	

	

}
