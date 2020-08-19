package br.com.aprendaSeleniumComThiago.test;

import org.junit.Test;

import br.com.aprendaSeleniumComThiago.core.CoreBaseTest;
import br.com.aprendaSeleniumComThiago.page.PageBasicFormDemo;
import br.com.aprendaSeleniumComThiago.page.PageHomeSeleniumEasy;
import br.com.aprendaSeleniumComThiago.util.Property;
import br.com.aprendaSeleniumComThiago.util.Utils;

public class SimpleBasicTest extends CoreBaseTest{
	
	
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
}
