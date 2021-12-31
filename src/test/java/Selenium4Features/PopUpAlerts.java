package Selenium4Features;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopUpAlerts {
	WebDriver driver;
	
	@Test(description="js alert")
	public void alert1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.accept();
		
		if(driver.getPageSource().contains("You successfully clicked an alert"))
			System.out.println("You successfully clicked an alert");
	    
	    driver.close();
	}
	
	@Test(description="Confirm Alert")
	public void confirmalert() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(3000);
		alert2.dismiss();
		
		if(driver.getPageSource().contains("You clicked cancel"))
			System.out.println("You clicked cancel");
	    
	    driver.close();
	}

}
