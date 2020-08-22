package br.com.aprendaSeleniumComThiago.page;

import java.awt.peer.ButtonPeer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.aprendaSeleniumComThiago.core.CoreDriver;

public class SeleniumEasyTestHome {
	protected WebDriver driver;
	protected WebDriverWait driverWait;
	public static String URL = "https://www.seleniumeasy.com/test/";
	
	public SeleniumEasyTestHome() {
		this.driver = CoreDriver.getDriver();
		driverWait = new WebDriverWait(this.driver, 30);
		PageFactory.initElements(CoreDriver.getDriver(), this);
	}
	
	@FindBy(id = "at-cv-lightbox-close")
	WebElement buttonExitPopup;
	
	@FindBy(id = "btn_basic_example")
	WebElement buttonStartPractice;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div/a[3]")
	WebElement exampleRadioButton;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div/a[4]")
	WebElement exampleDropDown;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div/div[2]/div[2]/div/a[6]")
	WebElement examplePopup;
	
	public void navigateToPage() {
		driver.navigate().to(URL);
	}
	
	
	private void clickElement(WebElement element) {
		try {
			driverWait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			// none
		}
	}
	
	public void closePopup() {
		clickElement(buttonExitPopup);
	}
	
	public void clickStartPractice() {
		clickElement(buttonStartPractice);
	}
	
	public SeleniumEasyTestPopup clickExamplePopup() {
		clickElement(examplePopup);
		return new SeleniumEasyTestPopup();
	}
	
	

}
