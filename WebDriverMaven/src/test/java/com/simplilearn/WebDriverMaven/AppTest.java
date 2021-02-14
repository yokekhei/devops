package com.simplilearn.WebDriverMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	private WebDriver driver;
	
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	
	public void login() {
		WebElement lnkLogin = driver.findElement(By.className("login"));
		lnkLogin.click();
		
		WebElement editUsername = driver.findElement(By.name("user_login"));
		editUsername.sendKeys("xyz@abc.com");
		
		WebElement editPwd = driver.findElement(By.name("user_pwd"));
		editPwd.sendKeys("12345");
		
		WebElement btnLogin = driver.findElement(By.name("btn_login"));
		btnLogin.click();
		
		WebElement error = driver.findElement(By.id("msg_box"));
		String actMsg = error.getText();
		String expMsg = "The email or password you have entered is invalid.";
		if (actMsg.equals(expMsg)) {
			System.out.println("TC Passed");
		} else {
			System.out.println("TC Failed");
		}
	}
	
	public void teardown() {
		driver.quit();
	}
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	setup();
    	login();
    	teardown();
        assertTrue( true );
    }
}
