package com.wq.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wq.utils.Constants;

public class Commons {

	public static WebDriver driver;
	public static Properties prop;
	public static ChromeOptions chromeOptions = new ChromeOptions();

	public Commons() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("./src/test/java/com/wq/config/config.properties");
			prop.load(fis);
		}catch (IOException e) {
			e.getMessage();
		}
	}

	//This method will initialize and launch the browser
	public static void browserInitialization() {

		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")) {			
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeLocation"));
			chromeOptions.addArguments("headless");
			chromeOptions.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(chromeOptions);
			//driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty(Constants.CUSTOMER_REG_URL));
		}
	}

	public static void closeBrowser() {
		driver.close();
	}
	
	public static void refreshBrowser() {
		driver.navigate().refresh();
	}
	
	public static void waitTime() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

}
