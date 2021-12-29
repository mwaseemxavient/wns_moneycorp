package com.wns.pages;
/*Money corp home page , page locators and supporting methods*/
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ui.utils.BaseSteps;
import com.ui.utils.ScreenShotReport;
import com.ui.utils.WebdriverSession;

public class MoneycorpHomePage extends WebdriverSession {
	WebDriver driver;

	public MoneycorpHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@id='language-dropdown-flag']")
	public WebElement langDropdown;

	@FindBy(xpath = "//a[@aria-label='USA English']")
	public WebElement usaEnglish;

	@FindBy(xpath = "//a[@aria-label='Foreign exchange solutions']/following-sibling::div//a[@aria-label='Find out more ']")
	public WebElement forExSolotionFindMore;

	public void clickSelectLangDropdwon() {
		BaseSteps.waitTillElementClickable(langDropdown, 30);
		ScreenShotReport.takeSreenshot(driver);

		BaseSteps.clickElementJavaScript(langDropdown);
		BaseSteps.zoomOut();
		BaseSteps.waitTillElementClickable(usaEnglish, 30);
		ScreenShotReport.takeSreenshot(driver);
		BaseSteps.clickElementJavaScript(usaEnglish);
		BaseSteps.zoomIn();
	}

}
