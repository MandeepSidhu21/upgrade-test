package com.upgrade.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PersonalInformationPage {

	WebDriver driver;

	@FindBy(how = How.NAME, using = "borrowerFirstName")
	@CacheLookup
	private WebElement firstName;

	@FindBy(how = How.NAME, using = "borrowerLastName")
	@CacheLookup
	private WebElement lastName;

	@FindBy(how = How.NAME, using = "borrowerStreet")
	@CacheLookup
	private WebElement street;

	@FindBy(how = How.NAME, using = "borrowerCity")
	@CacheLookup
	private WebElement city;

	@FindBy(how = How.NAME, using = "borrowerState")
	@CacheLookup
	private WebElement state;

	@FindBy(how = How.NAME, using = "borrowerZipCode")
	@CacheLookup
	private WebElement zipCode;

	@FindBy(how = How.NAME, using = "borrowerDateOfBirth")
	@CacheLookup
	private WebElement dateBirth;

	@FindBy(how = How.NAME, using = "borrowerIncome")
	@CacheLookup
	private WebElement borrowerIncome;

	@FindBy(how = How.NAME, using = "borrowerAdditionalIncome")
	@CacheLookup
	private WebElement borrowerAdditionalIncome;

	@FindBy(how = How.NAME, using = "username")
	@CacheLookup
	private WebElement username;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	private WebElement password;

	@FindBy(how = How.NAME, using = "agreements")
	@CacheLookup
	private WebElement agreements;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	@CacheLookup
	private WebElement checkYourRate;

	public PersonalInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterName(String firstName, String lastName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);

		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}

	public void enterAddress(String streetName, String cityName, String state, String zipCode) {
		this.street.clear();
		this.street.sendKeys(streetName);

		this.city.clear();
		this.city.sendKeys(cityName);

		this.state.clear();
		this.state.sendKeys(state);

		this.zipCode.clear();
		this.zipCode.sendKeys(zipCode);
	}

	public void enterDateOfBirth(String birthday) {
		this.dateBirth.clear();
		this.dateBirth.sendKeys(birthday);
	}

	public void enterIndividualAnnualIncome(String indIncome) {
		this.borrowerIncome.clear();
		this.borrowerIncome.sendKeys(indIncome.toString());

	}

	public void enterAdditionalAnnualIncome(String addIncome) {
		this.borrowerAdditionalIncome.clear();
		this.borrowerAdditionalIncome.sendKeys(addIncome.toString());
	}

	public void enterEmailAddress(String email) {
		this.username.clear();
		this.username.sendKeys(email);
	}

	public void enterPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickOnReadAndAgree() {

		Actions object = new Actions(driver);
		object.click(this.agreements);
		Action action = object.build();
		action.perform();
	}

	public OfferPage clickCheckYourRate() {
		Actions object = new Actions(driver);
		object.click(this.checkYourRate);
		Action action = object.build();
		action.perform();

		return new OfferPage(driver);

	}

	public String getTitle() {
		return this.driver.getTitle();

	}

}
