package com.io.magmabot.betterbanking.components;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public final class TransactionComponentTest {
	@LocalServerPort
	private int port;
	
	@BeforeEach
	public void initialiseRestAssuredMockMvcWebApplicationContext() {
		RestAssured.port = this.port;
	}

	@Test
	public void listTransactions_shouldReturnNonEmptyJSONTransactionList() {
		given().when()
				.get("/transactions")
				.then()
				.log()
				.all()
				.assertThat()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.body("$",
						hasItems(hasEntry("accountNumber", "123"),
								hasEntry("accountNumber", "456"),
								hasEntry("accountNumber", "789")

						));
	}
}
