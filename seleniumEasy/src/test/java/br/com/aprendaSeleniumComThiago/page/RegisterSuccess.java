package br.com.aprendaSeleniumComThiago.page;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.aprendaSeleniumComThiago.core.CoreDriver;


public class RegisterSuccess{

	public static String URL = "http://demo.guru99.com/test/newtours/register_sucess.php";
	protected WebDriver driver;
	public RegisterSuccess() {
		this.driver = CoreDriver.getDriver();
		PageFactory.initElements(CoreDriver.getDriver(), this);
	}
	
	
	// WAIT FOR ELEMENT
	public void validatePage() {
		String currentUrl = driver.getCurrentUrl();
		assertEquals(URL, currentUrl);
	}
}
