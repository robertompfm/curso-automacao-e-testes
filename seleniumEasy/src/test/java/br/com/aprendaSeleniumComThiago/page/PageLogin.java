package br.com.aprendaSeleniumComThiago.page;

import static org.junit.Assert.assertEquals;

import java.awt.peer.ButtonPeer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.aprendaSeleniumComThiago.core.CoreDriver;

public class PageLogin {
	
	// ATTRIBUTES
	protected WebDriver driver;
	protected WebDriverWait driverWait;
	public static String URL = "http://demo.guru99.com/test/login.html";
	
	// CONSTRUCTOR
	public PageLogin() {
		this.driver = CoreDriver.getDriver();
		driverWait = new WebDriverWait(this.driver, 30);
		PageFactory.initElements(CoreDriver.getDriver(), this);
	}
	
	// WEB ELEMENTS
	@FindBy(id = "email")
	WebElement inputEmail;

	@FindBy(id = "passwd")
	WebElement inputPassword;
	
	@FindBy(id = "SubmitLogin")
	WebElement buttonSubmit;
	
	
	// PUBLIC METHODS
	public void navigateToPage() {
		driver.navigate().to(URL);
	}
	
	public PageLoginSuccess makeLogin(String email, String password) {
		inputField(inputEmail, email);
		inputField(inputPassword, password);
		clickElement(buttonSubmit);
		return new PageLoginSuccess();
	}
	
	
	// PRIVATE METHODS
	private void clickElement(WebElement element) {
		try {
			driverWait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			// none
		}
	}
	
	private void inputField(WebElement element, String input) {
		try {
			driverWait.until(ExpectedConditions.visibilityOfAllElements(element));
			element.sendKeys(input);
		} catch (Exception e) {
			// none
		}
	}
	
}
