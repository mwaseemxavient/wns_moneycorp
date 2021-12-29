package com.wns.pages;

/*Money corp US English page, page locators and supporting methods*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ui.utils.BaseSteps;
import com.ui.utils.ScreenShotReport;
import com.ui.utils.WebdriverSession;

public class MoneycorpUSEnglishPage extends WebdriverSession {
	WebDriver driver;

	public MoneycorpUSEnglishPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@aria-label='Foreign exchange solutions']")
	public WebElement forExEnglishText;

	@FindBy(xpath = "//button[@aria-label='Search']")
	public WebElement searchButton;

	@FindBy(xpath = "//input[@id='nav_search']")
	public WebElement searchBox;

	@FindBy(xpath = "//a[starts-with(@href,'/en-us/')]")
	public WebElement href;

	public void verifyUSEnglishPage() {
		BaseSteps.waitTillElementVisible(forExEnglishText, 30);
		BaseSteps.scrollToElement(forExEnglishText);
		String forExText = forExEnglishText.getAttribute("aria-label").trim().toString();
		ScreenShotReport.takeSreenshot(driver);
		Assert.assertEquals("Foreign exchange solutions", forExText, "Foreign exchange solutions page not found");

	}

	public void typeSearch(String text) {
		clickSearchButton();
		BaseSteps.waitTillElementVisible(searchBox, 30);
		searchBox.clear();
		searchBox.sendKeys(text);
		ScreenShotReport.takeSreenshot(driver);
		searchBox.sendKeys(Keys.RETURN);
		System.out.println("String enterd : " + text);

	}

	public void clickSearchButton() {
		BaseSteps.scrollToElement(searchButton);
		BaseSteps.waitTillElementVisible(searchButton, 30);
		ScreenShotReport.takeSreenshot(driver);
		searchButton.click();
		System.out.println("Search Button clicked");

	}

	public void verifyAllLinksOnResultPage() {
		BaseSteps.waitTillElementVisible(href, 30);
		List<WebElement> allLinks = driver.findElements(By.xpath("//a[starts-with(@href,'/en-us/')]"));
		System.out.println("Total links : " + allLinks.size());
		ScreenShotReport.takeSreenshot(driver);
		for (WebElement link : allLinks) {
			Assert.assertEquals(true, link.getAttribute("href").startsWith("https://www.moneycorp.com/en-us/"),
					"Link failed :" + link.getAttribute("href"));
		}
	}

}
