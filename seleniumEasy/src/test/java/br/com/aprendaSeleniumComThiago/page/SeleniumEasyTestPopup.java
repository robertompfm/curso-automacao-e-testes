package br.com.aprendaSeleniumComThiago.page;

import java.awt.peer.ButtonPeer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.aprendaSeleniumComThiago.core.CoreDriver;

public class SeleniumEasyTestPopup {
	protected WebDriver driver;
	protected WebDriverWait driverWait;
	public static String URL = "https://www.seleniumeasy.com/test/window-popup-modal-demo.html";
	
	public SeleniumEasyTestPopup() {
		this.driver = CoreDriver.getDriver();
		driverWait = new WebDriverWait(this.driver, 30);
		PageFactory.initElements(CoreDriver.getDriver(), this);
	}
	
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div[1]/div/div[2]/div[1]/a")
	WebElement buttonFollowOnTwitter;

	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/a")
	WebElement buttonLikeOnFacebook;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/a")
	WebElement buttonTwitterAndFacebook;
	
	@FindBy(xpath = "//*[@id=\"followall\"]")
	WebElement buttonFollowAll;
	
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
	
	public void clickFollowOnTwitter() {
		clickElement(buttonFollowOnTwitter);
	}
	

}
