package br.com.alura.forum.controller;

import static org.junit.Assert.*;

import java.net.URI;
//import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
//@WebMvcTest
public class AutenticacaoControllerTest {
	@Autowired
	private MockMvc mocMvc;

	@Test
	public void devolve400CasoLoginInvalido() throws Exception {
		URI uri = new URI("/auth");
		String json = "{\"email:cleberadriani@gmail.com\", \"senha:123\"}";
		
		mocMvc
		.perform(MockMvcRequestBuilders	
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
		).andExpect(MockMvcResultMatchers
				.status()
				.is(400));
		
	}

}
