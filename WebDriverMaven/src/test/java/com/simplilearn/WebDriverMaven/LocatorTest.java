package com.simplilearn.WebDriverMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatorTest {

	private WebDriver driver;

	public static void main(String[] args) {
		LocatorTest obj = new LocatorTest();

//		obj.setupSimplilearn();
//		obj.setupFacebook();
//		obj.setupFacebookXPath();
		obj.setupFacebookXPathSelect();

//		obj.tearDown();
	}

	public void setupSimplilearn() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();

		driver.get("https://www.simplilearn.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

//		WebElement element = driver.findElement(By.linkText("Resources"));
//		element.click();

//		WebElement element = driver.findElement(By.partialLinkText("Corporate "));
//		element.click();

		WebElement element = driver.findElement(By.linkText("Log in"));
		element.click();

		WebElement userid = driver.findElement(By.cssSelector("input.email"));
		userid.sendKeys("abcd@xyz.com");

//		WebElement pwd = driver.findElement(By.cssSelector("input#password"));
//		pwd.sendKeys("12345");

		WebElement pwd = driver.findElement(By.cssSelector("input[name=user_pwd]"));
		pwd.sendKeys("12345");

		WebElement button = driver.findElement(By.name("btn_login"));
		// WebElement button =
		// driver.findElement(By.cssSelector("input[name=btn_login]"));
		button.click();
	}

	public void setupFacebook() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement email = driver.findElement(By.cssSelector("input[name=email]"));
		email.sendKeys("abcd@xyz.com");

		WebElement pwd = driver.findElement(By.cssSelector("input#pass"));
		pwd.sendKeys("12345");

//		WebElement button = driver.findElement(By.name("login"));
		WebElement button = driver.findElement(By.cssSelector("button[name=login]"));
		button.click();
	}

	public void setupFacebookXPath() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("abcd@xyz.com");

//		WebElement pwd = driver.findElement(By.xpath("//input[@name='pass']"));
		WebElement pwd = driver.findElement(By.xpath("//input[@type='password']"));
		pwd.sendKeys("12345");

		WebElement button = driver.findElement(By.xpath("//button[@name='login']"));
		button.click();
	}

	public void setupFacebookXPathSelect() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement element = driver.findElement(By.xpath("//*[text()='Create New Account']"));
		// WebElement element = driver.findElement(By.linkText("Create New Account"));
		element.click();

		WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
		Select ddMonth = new Select(month);
//		ddMonth.selectByValue("1");
//		ddMonth.selectByVisibleText("Jan");
		ddMonth.selectByIndex(0);

		WebElement genderFemale = driver.findElement(By.xpath("//input[@type='radio' and @name='sex' and @value=1]"));
		genderFemale.click();

		WebElement genderMale = driver.findElement(By.xpath("//input[@type='radio' and @name='sex' and @value=2]"));
		genderMale.click();
	}

	public void tearDown() {
		driver.quit();
	}

}
