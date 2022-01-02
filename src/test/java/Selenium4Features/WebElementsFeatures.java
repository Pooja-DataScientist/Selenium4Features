package Selenium4Features;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementsFeatures {
	WebDriver driver;
	
	@BeforeTest
	public void DriverSetup() {
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}
	
	@Test(priority=1, description="Find the list of elements")
	public void WebElementsList() {
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		
		driver.get("https://trytestingthis.netlify.app/");
		List<WebElement> elements = driver.findElements(By.tagName("select"));
		
		for(WebElement element : elements)
			System.out.println(element.getText());
	}
	
	@Test(priority =2, description="Find Elements with in Ellements")
	public void ElementsWithinElements() {
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		
		driver.get("https://google.com");
		WebElement searchbox = driver.findElement(By.tagName("form"));
		searchbox.findElement(By.name("q")).sendKeys("selenium" + Keys.ENTER);
	}
	
	@Test(priority=3, description="Get Active Element")
	public void GetActiveElement() {
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium");
        // Get Attribute Of an current Active Element	
		String attribute = driver.switchTo().activeElement().getAttribute("title");
		System.out.println(attribute);
	}
	
	@Test(priority=4, description="Get tagNmae, Text and CSS Value")
	public void GetAttributes() {
		driver.get("https://google.com");
		WebElement searchbox = driver.findElement(By.name("q"));
		String tagName =  searchbox.getTagName();
		String textName = searchbox.getText();
		String fontName = searchbox.getCssValue("font");
		
		System.out.println(tagName+"\n"+textName+"\n"+fontName);
	}
	
	@Test(priority=5, description="Check Element is enabled and selected")
	public void ElementEnabled() {
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		WebElement checkbox = driver.findElement(By.xpath("(//*[@id=\"checkboxes\"])[1]"));
		System.out.println(checkbox.isEnabled());
		System.out.println(checkbox.isSelected());
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
