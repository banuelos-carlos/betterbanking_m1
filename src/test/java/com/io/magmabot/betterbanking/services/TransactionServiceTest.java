package com.io.magmabot.betterbanking.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.io.magmabot.betterbanking.entities.Transaction;

@SpringBootTest
public final class TransactionServiceTest {

	@Autowired
	private TransactionService transactionService;

	@Test
	public void findAllByAccountNumber_shouldNotReturnEmptyList() {
		List<Transaction> transactions = transactionService.findAllByAccountNumber();
		
		assertTrue(transactions.size() > 2);
	}
}
