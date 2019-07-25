package com.upgrade.apitests;



import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.upgrade.apisteps.StateSearchSteps;

public class StateAPITests {

	
	StateSearchSteps stateSearchSteps = new StateSearchSteps();

	@Test
	public void verifyThatAllValidStatesCanBeFoundWithCount48() {
		stateSearchSteps.searchStates();
		stateSearchSteps.searchIsSuccessful();
		stateSearchSteps.validStatesShouldBePresent();
		stateSearchSteps.countIs48();
	}

	@Test
	public void givenEndPoint_whenRequested_thenPrintStateWhereMinAge19() {
		stateSearchSteps.searchStates();
		stateSearchSteps.searchIsSuccessful();
		System.out.println("State With Min Age: " + stateSearchSteps.stateWithMinAge19());

	}

	@Test
	public void givenEndPoint_whenRequested_thenPGeorgiaIsWithMinLoanAmount3005() {

		stateSearchSteps.searchStates();
		stateSearchSteps.searchIsSuccessful();
		stateSearchSteps.stateWithMinLoanAmount3005isOnlyGeorgia();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		System.out.println("Test Name:" + result.getMethod().getMethodName() + result.getStatus());
		
	}

}
