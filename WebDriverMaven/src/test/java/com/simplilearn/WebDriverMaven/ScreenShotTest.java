package com.simplilearn.WebDriverMaven;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotTest {
	private WebDriver driver;

	public static void main(String[] args) {
		ScreenShotTest obj = new ScreenShotTest();
		try {
			obj.setup();

//			obj.tearDown();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setup() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/delete_customer.php");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		Thread.sleep(3000);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scr, new File("test.png"));
	}

	public void tearDown() {
		driver.quit();
	}

}