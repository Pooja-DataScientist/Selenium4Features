package Selenium4Features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {
	
	WebDriver driver;
	@BeforeClass
	public void driversetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://automationbookstore.dev/");
		driver.manage().window().maximize();
	}
	
	@Test(description="Book5 which is below of Book1 and Left of Book6")
	public void test1() {
		WebElement book5 = driver.findElement(RelativeLocator.with(By.tagName("li")).toLeftOf(By.id("pid6")).below(By.id("pid1")));
		String id = book5.getAttribute("id");
		System.out.println(id);
		
		Assert.assertEquals(id,"pid5");
	}
	
	@Test(description="Book2 which is above of Book6 and Right of Book1")
	public void test2() {
		WebElement book2 = driver.findElement(RelativeLocator.with(By.tagName("li")).toRightOf(By.id("pid1")).above(By.id("pid6")));
		String id = book2.getAttribute("id");
		System.out.println(id);
		
		Assert.assertEquals(id,"pid2");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
