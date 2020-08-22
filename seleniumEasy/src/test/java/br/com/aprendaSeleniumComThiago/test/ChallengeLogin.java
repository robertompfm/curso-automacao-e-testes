package br.com.aprendaSeleniumComThiago.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.aprendaSeleniumComThiago.core.CoreBaseTest;
import br.com.aprendaSeleniumComThiago.core.CoreDriver;
import br.com.aprendaSeleniumComThiago.page.PageLogin;

public class ChallengeLogin extends CoreBaseTest{
	
	
	@Test
	public void loginTest() {
		WebDriverWait driverWait = new WebDriverWait(CoreDriver.getDriver(), 30);
		PageLogin loginPage = new PageLogin();
		
		loginPage.navigateToPage();
		
		String successMsg = loginPage.makeLogin(
				"spongebob@krustykrabby.com", 
				"krabbypatty"
				).getSuccessMessage();
		
		assertEquals("Test failed", "Successfully Logged in...", successMsg);
	}
	
}
