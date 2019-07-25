package com.upgrade.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected static WebDriver driver;

	public static String testURL = "https://www.credify.tech/phone/nonDMFunnel";

	@BeforeMethod
	public static void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(testURL);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		driver.close();
		driver.quit();
		System.out.println("Test Name:" + result.getMethod().getMethodName() + result.getStatus());
		
	}
}
