package com.wq.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

	public static void browserInitialization() {

		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")) {			
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeLocation"));
			//chromeOptions.addArguments("headless");
			//driver = new ChromeDriver(chromeOptions);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
	}

	public static void closeBrowser() {
		driver.close();
	}
}
