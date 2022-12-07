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
class VendedorControllerTest {

	@Autowired
	private MockMvc mock;

	//GET
	@Test
	public void deverRetornarOkAoChamarAListaDeVendedores() throws Exception {
		mock.perform(get("/vendedores")).andExpect(status().isOk());
	}
	
	//GET POR ID
	@Test
	public void deveRetornarOkNaBuscaPorId() throws Exception {
		mock.perform(get("/vendedores/1")).andExpect(status().isOk());
	}
}
