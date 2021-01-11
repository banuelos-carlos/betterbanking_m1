package com.io.magmabot.betterbanking.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public final class TransactionControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void transactionListing_shouldReturnListOfTransactions() throws Exception {
		mockMvc.perform(get("/transactions")).andExpect(status().isOk())
				.andExpect(content().string(containsString("\"accountNumber\":\"123\"")))
				.andExpect(content().string(containsString("\"accountNumber\":\"456\"")))
				.andExpect(content().string(containsString("\"accountNumber\":\"789\"")));
	}
}
