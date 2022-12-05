package br.com.teste.Vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.Vendas.model.Vendedor;

//Calsse que vai puxar os dados do banco de dados
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

	Vendedor findByNome(String nome);
	
	@Query(value ="SELECT * FROM Venda WHERE Id_Vendedor")
	
	

}
