package br.com.teste.Vendas.interfa;

//Interface com os campos para retornar do banco de dados
//Com contagem e media feita pelas QUERYS atraves do Repository, porem não funcionou direito. Deve ser alguma sintaxe que coloquei errado
public interface VendedorInterface {
	 Long getId();
	 String getNome();
	 Long getQntVendas();
	 Double getValorTotalVendas();
	 Double getMediaVendas();
}
