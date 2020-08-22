package br.com.aprendaSeleniumComThiago.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.aprendaSeleniumComThiago.core.CoreBaseTest;
import br.com.aprendaSeleniumComThiago.page.DeleteCustomer;
import br.com.aprendaSeleniumComThiago.page.PageBasicFormDemo;
import br.com.aprendaSeleniumComThiago.page.PageHomeSeleniumEasy;
import br.com.aprendaSeleniumComThiago.page.Register;
import br.com.aprendaSeleniumComThiago.page.RegisterSuccess;
import br.com.aprendaSeleniumComThiago.page.SeleniumEasyTestHome;
import br.com.aprendaSeleniumComThiago.page.SeleniumEasyTestPopup;
import br.com.aprendaSeleniumComThiago.util.Property;
import br.com.aprendaSeleniumComThiago.util.Utils;

public class SimpleBasicTest extends CoreBaseTest{
	
	@Ignore
	@Test
	public void realizarPrimeiroTest() {
		PageHomeSeleniumEasy homeSeleniumEasy = new PageHomeSeleniumEasy();
		PageBasicFormDemo basicFormDemo = new PageBasicFormDemo();
		driver.navigate().to(Property.URL);
		homeSeleniumEasy.acessarTestSelenium("BASIC EXAMPLES TO START WITH SELENIUM");
		Utils.takeScreenshot(driver, "realizarPrimeiroTeste", "1 - Acesso Pagina SimpleForm");
		basicFormDemo.preencherMensagem("Thiago");
		Utils.takeScreenshot(driver, "realizarPrimeiroTeste", "2 - preechendo texto");
		basicFormDemo.clickEnviarMensagem();
		Utils.takeScreenshot(driver, "realizarPrimeiroTeste", "3 - click");
		basicFormDemo.validaMensagem("Thiago");
		Utils.takeScreenshot(driver, "realizarPrimeiroTeste", "4 - validacao");
	}
	
	@Test
	public void popupWindowTest() {
		SeleniumEasyTestHome page = new SeleniumEasyTestHome();
		page.navigateToPage();
		page.closePopup();
		page.clickStartPractice();
		SeleniumEasyTestPopup popupTestPage = page.clickExamplePopup();
		popupTestPage.clickFollowOnTwitter();
		
	}
	
}
