package Selenium4Features;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenNewTabAndBrowsersFeature {
	
	@Test          // Open a new tab in window
	public void OpenNewTab() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://github.com/");
		driver.manage().window().maximize();
		
		driver.quit();
	}
	
	@Test                  // Open a new window
	public void OpenNewBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://github.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}
	
	@Test                       // Location Of Web Element
	public void LocationofElement() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		WebElement logo =driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
		System.out.println("Height: " + logo.getRect().getDimension().getHeight());
		System.out.println("Width: " + logo.getRect().getDimension().getWidth());
		System.out.println("Cordinate x: " + logo.getRect().getX());
		System.out.println("Cordinate y: " + logo.getRect().getY());

		
		
	}

}
