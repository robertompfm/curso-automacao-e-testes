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
		
		driver.navigate().to("http://demo.guru99.com/test/login.html");
		driver.findElement(By.id("email")).sendKeys("roberto@mendes.com");
		driver.findElement(By.id("passwd")).sendKeys("012345");
		driver.findElement(By.id("SubmitLogin")).submit();
		String xPath = "/html/body/div[2]/div/div/h3";
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
		WebElement element = driver.findElement(By.xpath(xPath));
		assertEquals("Test failed", "Successfully Logged in...", element.getText());
	}
	
	@Test
	public void loginTest2() {
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
