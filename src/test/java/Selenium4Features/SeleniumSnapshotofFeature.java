package Selenium4Features;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumSnapshotofFeature {

		
		//@Test               // Snapshot of WebElement 
		public void ElementSnapshot() throws IOException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://opensource-demo.orangehrmlive.com/");
			driver.manage().window().maximize();
			
			WebElement logo =driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
			File file = logo.getScreenshotAs(OutputType.FILE);
			File destfile = new File("./target/Screenshots/logo.png");
			FileUtils.copyFile(file, destfile);		
			driver.quit();
			}

		@Test                   // Snapshot of Login Form of page
		public void SectionSnapshot() throws IOException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://opensource-demo.orangehrmlive.com/");
			driver.manage().window().maximize();
			
			WebElement loginform =driver.findElement(By.id("frmLogin"));
			File file = loginform.getScreenshotAs(OutputType.FILE);
			File destfile = new File("./target/Screenshots/loginform.png");
			FileUtils.copyFile(file, destfile);		
			driver.quit();
		}
		
		@Test                       // Snapshot of Entire page
		public void PageSnapshot() throws IOException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://opensource-demo.orangehrmlive.com/");
			driver.manage().window().maximize();
			File file = ((ChromeDriver)driver).getScreenshotAs(OutputType.FILE);
			File destfile = new File("./target/Screenshots/page.png");
			FileUtils.copyFile(file, destfile);		
			driver.quit();
		}

		

	}



