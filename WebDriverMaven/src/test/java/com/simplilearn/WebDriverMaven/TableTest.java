package com.simplilearn.WebDriverMaven;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableTest {

	private WebDriver driver;

	public static void main(String[] args) {
		TableTest obj = new TableTest();
		obj.setup();
//		obj.tearDown();
	}

	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		List cols = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr/th"));
		System.out.println("No of cols are : " + cols.size());

		List rows = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr/td[1]"));
		System.out.println("No of rows are : " + rows.size());

		// To find third row of table
		WebElement tableRow = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[1]"));
		String rowText = tableRow.getText();
		System.out.println("Third row of table : " + rowText);

		// To get 3rd row's 2nd column data
		WebElement cellIneed = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[2]/td[1]"));
		String valueIneed = cellIneed.getText();
		System.out.println("Cell value is : " + valueIneed);

		System.out.println("\nAll Table Cells: ");

		for (int x = 1; x < rows.size() + 2; x++) {
			for (int y = 1; y < cols.size() + 1; y++) {
				if (x == 1) {
					WebElement cell = driver
							.findElement(By.xpath("//*[@id='customers']/tbody/tr[" + x + "]/th[" + y + "]"));
					System.out.print(cell.getText());
				} else {
					WebElement cell = driver
							.findElement(By.xpath("//*[@id='customers']/tbody/tr[" + x + "]/td[" + y + "]"));
					System.out.print(cell.getText() + "\t");
				}
			}

			System.out.println("");
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// This will scroll the page Horizontally till the element is found
		js.executeScript("arguments[0].scrollIntoView();", cellIneed);
	}

	public void tearDown() {
		driver.quit();
	}

}
