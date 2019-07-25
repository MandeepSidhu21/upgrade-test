package com.upgrade.uitests;

import java.text.ParseException;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.upgrade.base.BaseTest;
import com.upgrade.data.ClientInfo;
import com.upgrade.pages.LoginPage;
import com.upgrade.pages.OfferPage;
import com.upgrade.pages.PersonalInformationPage;
import com.upgrade.pages.UpgradePage;
import com.upgrade.utils.PasswordGenerator;


public class UpgradePersonalLoanTests extends BaseTest {

	public static final String LOAN_AMOUNT = "2000";
	public static final String LOAN_PURPOSE = "Pay off Credit Cards";
	public static final String IND_INCOME = "100000";
	public static final String ADD_IND_INCOME = "5000";
	public static final Random RANDOM = new Random();
	public static final String PORTAL_LOGIN_URL = "https://www.credify.tech/portal/login";

	@DataProvider(name = "clientData")
	public Object[][] getClientData() {
		return new Object[][] {
				{ new ClientInfo("Joe", "Smith", "3343  Winifred Way", "Indianapolis", "IN", "46254", "10/04/1999") } };
	}

	@Test(dataProvider = "clientData")
	public void test_loanAmount_APR_monthlyPaymentCorrectlyDisplayedAfterLogin(ClientInfo client)
			throws InterruptedException, ParseException {

		// set loan Amount
		UpgradePage upgradePage = new UpgradePage(driver);
		upgradePage.setLoanAmountWithPurpose(LOAN_AMOUNT, LOAN_PURPOSE);
		PersonalInformationPage infoPage = upgradePage.clickCheckYourRate();
		
		Assert.assertEquals(infoPage.getTitle(), "Check your rate for a personal loan | Upgrade");

		// enter personal info
		infoPage.enterName(client.getFirstname(), client.getLastName());
		infoPage.enterAddress(client.getStreet(), client.getCity(), client.getState(), client.getZipcode());
		infoPage.enterDateOfBirth(client.getDateofbirth());
		infoPage.enterIndividualAnnualIncome(IND_INCOME);
		infoPage.enterAdditionalAnnualIncome(ADD_IND_INCOME);
		String emailAddress = client.getFirstname().toString() + RANDOM.nextInt(90) + "@upgrade-challenge.com";
		infoPage.enterEmailAddress(emailAddress);
		String password = PasswordGenerator.generatePassword();
		infoPage.enterPassword(password);
		infoPage.clickOnReadAndAgree();
		OfferPage offerPage = infoPage.clickCheckYourRate();
		

		// get field values to be validated
		String actualLoanAmount = offerPage.getLoanAmount();
		String actualApr = offerPage.getAPR();
		String actualLoanTerm = offerPage.getLoanTerm();
		String actualMonthlyPayement = offerPage.getMonthlyPayment();
		offerPage.clickSignOut();

		// login to upgrade portal
		driver.get(PORTAL_LOGIN_URL);
		LoginPage login = new LoginPage(driver);
		login.enterEmailAddress(emailAddress);
		login.enterPassword(password);
		OfferPage offer_page = login.clickCheckYourRate();
		

		Assert.assertEquals(offer_page.getLoanAmount(), actualLoanAmount);
		Assert.assertEquals(offer_page.getAPR(), actualApr);
		Assert.assertEquals(offer_page.getLoanTerm(), actualLoanTerm);
		Assert.assertEquals(offer_page.getMonthlyPayment(), actualMonthlyPayement);
		Assert.assertEquals(offer_page.getTitle(), "Affordable Online Personal Loans | Upgrade");

	}

}
