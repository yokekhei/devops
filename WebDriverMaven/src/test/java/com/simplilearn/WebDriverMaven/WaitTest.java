package com.simplilearn.WebDriverMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTest {

	private WebDriver driver;
	
	public static void main(String[] args) {
		WaitTest obj = new WaitTest();
		obj.setup();
//		obj.tearDown();
	}
	
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.linkText("Create New Account"));
		element.click();
		
		WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
		Select ddMonth = new Select(month);
		ddMonth.selectByValue("1");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(month));
		
		WebElement genderFemale = driver.findElement(By.xpath("//input[@type='radio' and @name='sex' and @value=1]"));
		genderFemale.click();
	}
	
	public void tearDown() {
		driver.quit();
	}
	
}
