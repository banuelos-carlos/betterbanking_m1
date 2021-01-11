package com.io.magmabot.betterbanking.components;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public final class TransactionComponentTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach
	public void initialiseRestAssuredMockMvcWebApplicationContext() {
		RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
	}

	@Test
	public void listTransactions_shouldReturnNonEmptyJSONTransactionList() {
		given().when().get("/transactions").then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and().body("$[0].accountNumber", equalTo("123"))
				.and().body("$[1].accountNumber", equalTo("456")).and()
				.body("$[2].accountNumber", equalTo("789"));

	}
}
