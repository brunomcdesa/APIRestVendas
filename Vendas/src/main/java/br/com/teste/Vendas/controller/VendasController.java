package br.com.teste.Vendas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.Vendas.model.Venda;

@RestController //Assume que  por padrão todos os metodos serão ResponseBody
@RequestMapping("/vendas") // Mapeia o endpoind da aplicação... a rota no navegador
public class VendasController {
	
	
}
