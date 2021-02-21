package com.simplilearn.SimpliLearn;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ApachePOI {

	private WebDriver driver;
	private SoftAssert assetobj;
	
	private XSSFWorkbook wb;
	XSSFSheet sheet1; 
	
	@BeforeTest
	public void setup() {
		assetobj = new SoftAssert();
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();

		driver.get("https://www.simplilearn.com/");

		driver.manage().window().maximize();
	}

	@Test
	public void TestCase1() throws IOException {
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		wb = new XSSFWorkbook(fis);
		sheet1 = wb.getSheet("data");
		
//		String username = sheet1.getRow(0).getCell(0).getStringCellValue();
//		String password = sheet1.getRow(0).getCell(1).getStringCellValue();
		
		int rowCount = sheet1.getLastRowNum();
		String username = null;
		String password = null;
		
		for (int i = 0; i<rowCount; i++) {
			String testName = sheet1.getRow(i).getCell(0).getStringCellValue();
			if (testName.equals("mytest")) {
				username = sheet1.getRow(i).getCell(1).getStringCellValue();
				password = sheet1.getRow(i).getCell(2).getStringCellValue();
			}
		}
		
		WebElement element = driver.findElement(By.linkText("Log in"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();

		WebElement userid = driver.findElement(By.cssSelector("input.email"));
		userid.sendKeys(username);

		WebElement pwd = driver.findElement(By.cssSelector("input[name=user_pwd]"));
		pwd.sendKeys(password);

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
