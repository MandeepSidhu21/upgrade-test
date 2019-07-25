package com.upgrade.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UpgradePage {
	WebDriver driver;

	@FindBy(how = How.NAME, using = "desiredAmount")
	private WebElement loan_Amount;

	@FindBy(how = How.TAG_NAME, using = "option")
	private List<WebElement> purpose_Option;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	protected WebElement checkYourRate;

	public UpgradePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setLoanAmountWithPurpose(String loanAmount, String selectPurpose) {
		this.loan_Amount.clear();
		this.loan_Amount.sendKeys(loanAmount);

		for (WebElement purpose : this.purpose_Option) {
			if (purpose.getText().equals(selectPurpose)) {
				purpose.click();
				break;
			}
		}

	}

	public PersonalInformationPage clickCheckYourRate() {
		checkYourRate.click();
		return new PersonalInformationPage(driver);
	}

}
