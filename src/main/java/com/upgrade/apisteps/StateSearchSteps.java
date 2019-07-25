package com.upgrade.apisteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.upgrade.utils.States;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StateSearchSteps {
	private String BASE_URL = "https://credapi.credify.tech/api/loanapp/v1/states";
	private Response response;

	
	public void searchStates() {
		response = RestAssured.get(BASE_URL).andReturn();
	}

	
	public void searchIsSuccessful() {
		response.then().statusCode(200);

	}

	
	public void validStatesShouldBePresent() {
		List<String> allStates = response.path("states.label");
		Assert.assertTrue(States.getStates().containsAll(allStates));
	}

	
	public void countIs48() {
		List<String> allStates = response.path("states.label");
		assertThat(allStates.size(), is(48));
	}

	
	public String stateWithMinAge19() {
		Map<String, ?> statesWithMinAge = response.path("states.find { it.minAge < 19 }");
		return String.valueOf(statesWithMinAge.get("label"));

	}

	
	public void stateWithMinLoanAmount3005isOnlyGeorgia() {
		Map<String, ?> stateWithMinAmount = response.path("states.find { it.minLoanAmount == 3005 }");
		assertThat(stateWithMinAmount.get("label"), is("Georgia"));

	}

}
