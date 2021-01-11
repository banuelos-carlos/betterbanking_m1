package com.io.magmabot.betterbanking.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class Transaction {
	private String type;
	private String accountNumber;
	private String currency;
	private int amount;
	private String merchantName;
	private String merchantLogo;
}
