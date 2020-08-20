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
import br.com.aprendaSeleniumComThiago.page.Register;
import br.com.aprendaSeleniumComThiago.page.RegisterSuccess;

public class ChallengeSelect extends CoreBaseTest{
	
	@Test
	public void dragTest() {
		Register registerPage = new Register();
		RegisterSuccess registerSuccessPage = new RegisterSuccess();
		driver.navigate().to(Register.URL);
		
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
		
		registerSuccessPage.validatePage();
		
	}
	
	
}
