package com.upgrade.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OfferPage {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//span[@data-auto='userLoanAmount']")
	@CacheLookup
	private WebElement loanAmount;

	@FindBy(how = How.XPATH, using = "//span[@data-auto='defaultMonthlyPayment']")
	@CacheLookup
	private WebElement monthlyPayment;

	@FindBy(how = How.XPATH, using = "//div[@data-auto='defaultLoanTerm']")
	@CacheLookup
	private WebElement monthTerm;

	@FindBy(how = How.XPATH, using = "//div[@data-auto='defaultMoreInfoAPR']")
	@CacheLookup
	private WebElement apr;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/header/div/label")
	@CacheLookup
	private WebElement menu;

	@FindBy(how = How.LINK_TEXT, using = "Sign Out")
	@CacheLookup
	private WebElement signout;

	public OfferPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	}

	public String getLoanAmount() {
		return this.loanAmount.getText();
	}

	public String getAPR() {
		return this.apr.getText();
	}

	public String getLoanTerm() {
		return this.monthTerm.getText();
	}

	public String getMonthlyPayment() {
		return this.monthlyPayment.getText();
	}

	public void clickSignOut() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			this.menu.click();
		}
		this.menu.click();
		this.signout.click();

	}

	public String getTitle() {
		return this.driver.getTitle();
	}

}
