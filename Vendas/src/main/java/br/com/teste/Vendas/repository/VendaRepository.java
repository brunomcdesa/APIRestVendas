package br.com.teste.Vendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.Vendas.model.Venda;
import br.com.teste.Vendas.model.Vendedor;

//Classe que vai puxar os dados de VENDA do banco de dados
public interface VendaRepository extends JpaRepository<Venda, Long> {
	List<Venda> findByVendedorId(Long id);
	Vendedor findByVendedorNome(String nome);
}
