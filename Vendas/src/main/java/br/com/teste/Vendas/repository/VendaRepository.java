package br.com.teste.Vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.Vendas.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

}
