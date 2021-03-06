package com.simplilearn.SimpliLearn;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class LoginTest {

	private WebDriver driver;
	private SoftAssert assetobj;
	
	@BeforeTest
	public void setup() {
		assetobj = new SoftAssert();
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();

		driver.get("https://www.simplilearn.com/");

		driver.manage().window().maximize();
	}

	@Test
	@Parameters({"UserName", "Password"})
	public void TestCase1(String UserName, String Password) {
		WebElement element = driver.findElement(By.linkText("Log in"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();

		WebElement userid = driver.findElement(By.cssSelector("input.email"));
		userid.sendKeys(UserName);

		WebElement pwd = driver.findElement(By.cssSelector("input[name=user_pwd]"));
		pwd.sendKeys(Password);

		WebElement button = driver.findElement(By.name("btn_login"));
		button.click();

		WebElement error = driver.findElement(By.id("msg_box"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(error));
		
		String actMsg = error.getText();
		String expMsg = "The email or password you have entered is invalid.";

		// Hard assertion
		// Assert.assertEquals(actMsg, expMsg);

		// Soft assertion
		assetobj.assertEquals(actMsg, expMsg);

//		assetobj.assertAll();
	}

	@AfterMethod
	@AfterTest
	public void tearDown() {
		try {
			assetobj.assertAll();
		} finally {
			driver.quit();
		}
	}

}
