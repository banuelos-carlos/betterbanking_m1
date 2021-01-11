package com.io.magmabot.betterbanking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.io.magmabot.betterbanking.entities.Transaction;
import com.io.magmabot.betterbanking.services.TransactionService;

@RestController
public final class TransactionController {

	private final TransactionService transactionService;

	@Autowired
	TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@GetMapping("/transactions")
	public List<Transaction> listTransactions() {
		return transactionService.findAllByAccountNumber();
	}

	@GetMapping("/transactions/{accountNumber}")
	public List<Transaction> listTransactionsByAccountNumber(
			@PathVariable("accountNumber") String accountNumber) {
		return transactionService.findAllByAccountNumber();
	}
}
