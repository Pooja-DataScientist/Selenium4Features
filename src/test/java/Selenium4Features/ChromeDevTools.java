package Selenium4Features;

import static org.testng.Assert.assertEquals;

import java.util.Optional;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.security.Security;
import org.openqa.selenium.devtools.v95.log.Log;
import org.openqa.selenium.devtools.v95.network.Network;
import org.openqa.selenium.devtools.v95.network.model.ConnectionType;
import org.openqa.selenium.devtools.v95.network.model.LoadingFailed;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.slf4j.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDevTools {
	
	WebDriver driver;
	
	@Test(priority=1, description="Make the Network Offline")
	public void EnableNetworkOffline() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		DevTools devTools = ((ChromiumDriver) driver).getDevTools();
		
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(true, 100, 1000, 2000, Optional.of(ConnectionType.WIFI)));
		
		devTools.addListener(Network.loadingFailed(), loadingFailed -> assertEquals(loadingFailed.getErrorText(), "net:: ERR_INTERNET_DISCONNECTED"));
		driver.get("https://github.com");
		
		driver.quit();
	}
	
	@Test(priority=2, description="Make the Network Online")
	public void EnableNetworkOnline() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		DevTools devTools = ((ChromiumDriver) driver).getDevTools();
		
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 100, 1000, 2000, Optional.of(ConnectionType.WIFI)));
		
		driver.get("https://demo.nopcommerce.com/");
		
		driver.quit();
	}
	
	@Test(priority=3, description="Get Console Logs")
	public void GetConsoleLogs() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		DevTools devTools = ((ChromiumDriver) driver).getDevTools();
		
		devTools.createSession();
		
		devTools.send(Log.enable());
		
		/*devTools.addListener(Log.entryAdded(), logEntry -> {
			System.out.println(logEntry.getText());
				System.out.println(logEntry.getLevel());
				});*/
		
		//devTools.addListener(Log.entryAdded(), entry ->entry.getText());
        ((RemoteWebDriver) driver).setLogLevel(Level.INFO);

        //driver.get("https://google.com/");
		driver.get("https://demo.nopcommerce.com/");
		
		driver.quit();
	}
	
	@Test(priority=4, description = "Load Unsecured Website")
	public void LoadUnsecuredWebsite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		DevTools devTools = ((ChromiumDriver) driver).getDevTools();
		
		devTools.createSession();
		
		devTools.send(Security.setIgnoreCertificateErrors(true));
		
	    driver.get("https://expired.badss1.com/");
	    
	    driver.quit();
		
	}
	
	}

	


