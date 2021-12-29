package com.wns.tests;
/* Test file contains test code*/
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.ui.utils.BaseSteps;
import com.ui.utils.WebdriverSession;
import com.wns.pages.MoneycorpHomePage;
import com.wns.pages.MoneycorpUSEnglishPage;

public class MoneycorpTest {
	WebDriver driver;

	@Test
	public void testForeignExchangeSoolutions() {
		driver = WebdriverSession.getWebDriverSession();
		driver.get("https://www.moneycorp.com/en-gb");
		BaseSteps.waitForPageLoad();
		MoneycorpHomePage mpage = new MoneycorpHomePage(driver);
		MoneycorpUSEnglishPage usEnglishPage = new MoneycorpUSEnglishPage(driver);
		mpage.clickSelectLangDropdwon();
		usEnglishPage.verifyUSEnglishPage();
		usEnglishPage.typeSearch("international payments");
		usEnglishPage.verifyAllLinksOnResultPage();
	}

	@AfterClass
	public void afterMethod() {
		driver.close();
	}
}
