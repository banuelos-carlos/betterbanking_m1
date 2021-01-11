package com.io.magmabot.betterbanking.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.io.magmabot.betterbanking.entities.Transaction;

@Service
public final class TransactionService {
	private static final List<Transaction> ALL_TRANSACTIONS = getTransactions();

	public List<Transaction> findAllByAccountNumber() {
		return ALL_TRANSACTIONS;
	}

	private static List<Transaction> getTransactions() {
		List<Transaction> transactions = new ArrayList<>();

		Transaction transaction1 = Transaction.builder().type("A").accountNumber("123").amount(1000)
				.currency("USD").build();
		transactions.add(transaction1);

		Transaction transaction2 = Transaction.builder().type("B").accountNumber("456").amount(2000)
				.currency("MXN").build();
		transactions.add(transaction2);

		Transaction transaction3 = Transaction.builder().type("C").accountNumber("789").amount(3000)
				.currency("EUR").build();
		transactions.add(transaction3);

		return Collections.unmodifiableList(transactions);
	}
}
