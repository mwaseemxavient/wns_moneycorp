package com.ui.utils;
/* WebdriverSession classe to create session for driver*/

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverSession {
	static WebDriver driver;
	public static WebDriver getWebDriverSession() {
		
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\ChromeDriver_1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		System.out.println("beforeTest");
		return driver;
		}
	

}
