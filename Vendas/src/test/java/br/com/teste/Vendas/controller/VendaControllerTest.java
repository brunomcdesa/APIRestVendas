package br.com.teste.Vendas.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
class VendaControllerTest {

	@Autowired
	private MockMvc mock;
	
	//GET ALL
	@Test
	public void deveRetornarOkAoChamarAListaDeVendasTotal () throws Exception {
		mock.perform(get("/vendas")).andExpect(status().isOk());
	}

	//GET POR ID
	@Test
	public void deveRetornarOkAoChamarUmaVendaEspecifica() throws Exception {
		mock.perform(get("/vendas/1")).andExpect(status().isOk());
	}
}
