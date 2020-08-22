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

public class PageLoginSuccess {
	
	// ATTRIBUTES
	protected WebDriver driver;
	protected WebDriverWait driverWait;
	public static String URL = "http://demo.guru99.com/test/success.html";
	
	// CONSTRUCTOR
	public PageLoginSuccess() {
		this.driver = CoreDriver.getDriver();
		driverWait = new WebDriverWait(this.driver, 30);
		PageFactory.initElements(CoreDriver.getDriver(), this);
	}
	
	// WEB ELEMENTS
	@FindBy(xpath = "/html/body/div[2]/div/div/h3")
	WebElement successMessage;

	
	// PUBLIC METHODS
	public String getSuccessMessage() {
		try {
			driverWait.until(ExpectedConditions.visibilityOf(successMessage));
			return successMessage.getText();
		} catch (Exception e) {
			return "failed";
		}
	}
}
