package br.com.aprendaSeleniumComThiago.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.aprendaSeleniumComThiago.core.CoreBaseTest;
import br.com.aprendaSeleniumComThiago.core.CoreDriver;
import br.com.aprendaSeleniumComThiago.page.RegisterPage;
import br.com.aprendaSeleniumComThiago.page.RegisterSuccessPage;

public class ChallengeRegister extends CoreBaseTest{
	
	@Test
	public void dragTest() {
		RegisterPage registerPage = new RegisterPage();
		RegisterSuccessPage registerSuccessPage = new RegisterSuccessPage();
		driver.navigate().to(RegisterPage.URL);
		
		registerPage.fillContactInfoFields(
				"Spongebob", 
				"Squarepants", 
				"123456", 
				"spongebob@krustykrab.com"
				);
		
		registerPage.fillMailingInfoFields(
				"Pineapple", 
				"Bikini Bottom", 
				"Marshall Islands", 
				"111111", 
				"United States"
				);
		
		registerPage.fillUserInfoFields(
				"spongebob", 
				"krabbypatty", 
				"krabbypatty"
				);
		
		registerPage.submit();
		
		registerSuccessPage.validatePage(driver.getCurrentUrl());
		
	}
	
	
}
