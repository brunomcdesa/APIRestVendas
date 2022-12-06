package br.com.teste.Vendas.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//NESTA CALSSE SERÃO FEITOS OS TRATAMAENTOS E EXCEPTION
//A EXCEPTION TRATADA SERA QUE RETORNA QUANDO ALGUM CAMPO FOR DIFERENTE DO QUE FOI DEFINIDO NAS CLASSES FORM
@RestControllerAdvice
public class ErroValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormDto> handle(MethodArgumentNotValidException exception) {
		List<ErroDeFormDto> dto = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeFormDto erro = new ErroDeFormDto(e.getField(), mensagem);
			dto.add(erro);
		});
		
		return dto;
	}
}
