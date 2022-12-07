package br.com.teste.Vendas.controller.form;

import br.com.teste.Vendas.model.Venda;
import br.com.teste.Vendas.model.Vendedor;
import br.com.teste.Vendas.repository.VendaRepository;
import br.com.teste.Vendas.repository.VendedorRepository;
import jakarta.validation.constraints.NotNull;

//Classe para definir quais campos de VENDA serão atualizados
public class AtualizaVendaForm {
	@NotNull
	private double valor;
	@NotNull
	private Long idVendedor;
	
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
	
	public Venda atualizar(Long id, VendaRepository repository, VendedorRepository vendedorRepository) {
		Venda venda = repository.getReferenceById(id);
		Vendedor vendedor = vendedorRepository.getReferenceById(this.idVendedor);
		
		venda.setValor(this.valor);
		venda.setVendedor(vendedor);
		
		return venda;
	}
	
}
