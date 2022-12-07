package br.com.teste.Vendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.teste.Vendas.controller.dto.VendedorDto;
import br.com.teste.Vendas.interfa.VendedorInterface;
import br.com.teste.Vendas.model.Vendedor;

//Classe que vai puxar os dados de VENDEDOR do banco de dados
@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

	//Query para pesquisa com filtro de nome do vendedor
		@Query(value = "SELECT vendedor.nome AS nome, vendedor.id AS id,"
				+ "COUNT (venda.vendedor_id) AS vendas,"
				+ "AVG(valor) AS media,"
				+ "SUM(valor) AS valor_total_vendas FROM vendedor INNER JOIN venda ON venda.vendedor_id = vendedor.id "
				+ "WHERE vendedor.nome = :nome "
				+ "GROUP BY venda.vendedor_id",
				nativeQuery = true)
		List<Vendedor> findByNome(String nome);
		
	
	//NÃO CONSEGUI FAZER AS QUERYS ABAIXO FUNCIONAR NO CODIGO, 
	//POREM NO BANCO H2 RETORNA EXATAMENTE A MEDIA E A SOMA DE ACORDO COM CADA QUERY
	
	//Query para fazer saber a quantidade de vendas por vendedor
	@Query(value = "SELECT vendedor.nome, vendedor.id,"
			+ "COUNT (venda.vendedor_id) AS vendas FROM vendedor JOIN venda ON venda.vendedor_id = vendedor.id"
			+ "GROUP BY venda.vendedor_id",
			nativeQuery = true)
	List<VendedorDto> qntVendasPorVendedor();
	
	
	//Query para os campos a serem retornados, incluindo a contagem e a media de vendas
	@Query(value = "SELECT vendedor.nome AS nome, vendedor.id AS id,"
			+ "COUNT (venda.vendedor_id) AS vendas,"
			+ "AVG(valor) AS media,"
			+ "SUM(valor) AS valor_total_vendas FROM vendedor INNER JOIN venda ON venda.vendedor_id = vendedor.id "
			+ "WHERE data_venda > '2022-01-01' AND data_venda < '2023-12-31'"
			+ "GROUP BY venda.vendedor_id",
			nativeQuery = true)
	List<VendedorInterface> camposASerRetornados();
	
	
	
	
// SINTAXE PARA TESTE NO DATABASE H2
	
//	SELECT vendedor.nome, vendedor.id, 
//	COUNT (venda.vendedor_id) AS vendas FROM vendedor JOIN venda ON venda.vendedor_id = vendedor.id 
//	GROUP BY venda.vendedor_id
//
//	SELECT vendedor.nome AS nome, vendedor.id AS id,
//	COUNT (venda.vendedor_id) AS vendas,
//	AVG (valor) AS media,
//	SUM (valor) AS valor_total_vendas FROM vendedor INNER JOIN venda ON venda.vendedor_id = vendedor.id
//	WHERE data_venda > '2022-09-02' AND data_venda < '2022-12-05' 
//	GROUP BY venda.vendedor_id 
	
	
}
