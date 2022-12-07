package br.com.teste.Vendas.config.validacao;

//Nesta classe sao definidos os atributos que serão reotrnados nas exceptions
public class ErroDeFormDto {
	
	private String campo;
	private String erro;
	
	public ErroDeFormDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}
	
	public String getCampo() {
		return campo;
	}
	
	public String getErro() {
		return erro;
	}
}
