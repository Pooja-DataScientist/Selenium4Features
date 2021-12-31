package Selenium4Features;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadingStrategies {
	
	@Test(description="Normal Page Loading Strategy")
	public void normalstrategy() throws InterruptedException {
		ChromeOptions option1 = new ChromeOptions();
		option1.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option1);
		
		driver.get("https://google.com");
	    Thread.sleep(2000);	
	    driver.quit();
	}
    
	@Test(description="Eager Page Loading Strategy")
	public void eagerstrategy() {
		ChromeOptions option2 = new ChromeOptions();
        option2.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option2);
		
		driver.get("https://google.com");
	    driver.quit();
	}
	
	@Test(description="None Page Loading Strategy")
	public void nonestrategy() {
		ChromeOptions option3 = new ChromeOptions();
        option3.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option3);
		
		driver.get("https://google.com");
	    driver.quit();
	}
}
