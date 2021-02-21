package com.simplilearn.SimpliLearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CrossBrowser {

	private WebDriver chromeDriver;
	private WebDriver geckoDriver;
	
	@Test(groups="Chrome")
	public void LaunchChrome() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.simplilearn.com/");
		chromeDriver.manage().window().maximize();
		
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(groups="Chrome", dependsOnMethods="LaunchChrome")
	public void TryChrome() {
		System.out.println(Thread.currentThread().getId());
		WebElement element = chromeDriver.findElement(By.linkText("Log in"));
		WebDriverWait wait = new WebDriverWait(chromeDriver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();

		WebElement userid = chromeDriver.findElement(By.cssSelector("input.email"));
		userid.sendKeys("chrome@xyz.com");

		WebElement pwd = chromeDriver.findElement(By.cssSelector("input[name=user_pwd]"));
		pwd.sendKeys("12345");

		WebElement button = chromeDriver.findElement(By.name("btn_login"));
		button.click();

		WebElement error = chromeDriver.findElement(By.id("msg_box"));
		wait = new WebDriverWait(chromeDriver, 30);
		wait.until(ExpectedConditions.visibilityOf(error));
		
		String actMsg = error.getText();
		String expMsg = "The email or password you have entered is invalid.";

		// Hard assertion
		Assert.assertEquals(actMsg, expMsg);
	}
	
	@Test(groups="Firefox")
	public void LaunchFirefox() {
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		geckoDriver = new FirefoxDriver();
		geckoDriver.get("https://www.simplilearn.com/");
		geckoDriver.manage().window().maximize();
		
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(groups="Firefox", dependsOnMethods="LaunchFirefox")
	public void TryFirefox() {
		System.out.println(Thread.currentThread().getId());
		WebElement element = geckoDriver.findElement(By.linkText("Log in"));
		WebDriverWait wait = new WebDriverWait(geckoDriver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();

		WebElement userid = geckoDriver.findElement(By.cssSelector("input.email"));
		userid.sendKeys("firefox@xyz.com");

		WebElement pwd = geckoDriver.findElement(By.cssSelector("input[name=user_pwd]"));
		pwd.sendKeys("12345");

		WebElement button = geckoDriver.findElement(By.name("btn_login"));
		button.click();

		WebElement error = geckoDriver.findElement(By.id("msg_box"));
		wait = new WebDriverWait(geckoDriver, 30);
		wait.until(ExpectedConditions.visibilityOf(error));
		
		String actMsg = error.getText();
		String expMsg = "The email or password you have entered is invalid.";

		// Hard assertion
		Assert.assertEquals(actMsg, expMsg);
	}
	
	@AfterTest
	public void tearDown() {
		chromeDriver.quit();
		geckoDriver.quit();
	}
	
}
