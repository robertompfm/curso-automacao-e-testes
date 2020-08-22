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
import br.com.aprendaSeleniumComThiago.page.DeleteCustomer;
import br.com.aprendaSeleniumComThiago.page.Register;
import br.com.aprendaSeleniumComThiago.page.RegisterSuccess;

public class ChallengeAlert extends CoreBaseTest{
	
	@Test
	public void alertTest() {
		DeleteCustomer deleteCustomerPage = new DeleteCustomer();
		driver.navigate().to(DeleteCustomer.URL);
		
		deleteCustomerPage.fillInputField("automação");
		deleteCustomerPage.submit();
		
		deleteCustomerPage.acceptAlert();
		
		deleteCustomerPage.confirmSuccessMessage();
		
		deleteCustomerPage.acceptAlert();
		
	}
}
