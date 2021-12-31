package Selenium4Features;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions {
	
	@Test(description = "KeyDown")
	public void keydown() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium"+ Keys.ENTER);
		
		Actions actionProvider = new Actions(driver);
		Action action = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();
		action.perform();
		
		Thread.sleep(3000);
		
		
		driver.quit();
	}

}
