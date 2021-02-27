package com.simplilearn.SimpliLearn;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridExample {

	@Test
	public void testcase1() throws MalformedURLException {
		DesiredCapabilities cap1 = new DesiredCapabilities();
		cap1.setPlatform(Platform.LINUX);
//		cap1.setBrowserName("chrome");
		cap1.setBrowserName("firefox");
		String hubURL = "http://localhost:4444/wd/hub";
		WebDriver driver = new RemoteWebDriver(new URL(hubURL), cap1);
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.quit();
	}

}
