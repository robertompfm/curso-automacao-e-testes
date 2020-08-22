package br.com.aprendaSeleniumComThiago.page;

import static org.junit.Assert.assertEquals;

import java.awt.peer.ButtonPeer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.aprendaSeleniumComThiago.core.CoreDriver;

public class PageDrag {
	
	// ATTRIBUTES
	protected WebDriver driver;
	protected WebDriverWait driverWait;
	protected Actions actions;
	public static String URL = "http://demo.guru99.com/test/drag_drop.html";
	
	// CONSTRUCTOR
	public PageDrag() {
		this.driver = CoreDriver.getDriver();
		driverWait = new WebDriverWait(this.driver, 30);
		actions = new Actions(this.driver);
		PageFactory.initElements(CoreDriver.getDriver(), this);
	}
	
	// WEB ELEMENTS
	@FindBy(id = "fourth")
	WebElement fiveThousandBtn;

	@FindBy(id = "amt7")
	WebElement debitAmountTarget;
	
	@FindBy(id = "amt8")
	WebElement creditAmountTarget;

	@FindBy(id = "bank")
	WebElement debitAccountTarget;

	@FindBy(id = "loan")
	WebElement creditAccountTarget;
	
	@FindBy(id = "credit2")
	WebElement bankBtn;

	@FindBy(id = "credit1")
	WebElement loanBtn;

	@FindBy(xpath = "//*[@id=\"equal\"]/a")
	WebElement perfectBtn;
	
	// PUBLIC METHODS
	public void navigateToPage() {
		driver.navigate().to(URL);
	}
	
	public void dragAllElements() {
		try {
			dragElement(fiveThousandBtn, debitAmountTarget);
			dragElement(fiveThousandBtn, creditAmountTarget);
			dragElement(bankBtn, debitAccountTarget);
			dragElement(loanBtn, creditAccountTarget);
			
		} catch (Exception e) {
			// none
		}
	}
	
	public String getSuccessMessage() {
		try {
			driverWait.until(ExpectedConditions.visibilityOf(perfectBtn));
			return perfectBtn.getText();
		} catch (Exception e) {
			return "failed";
		}
	}
	
	// PRIVATE METHODS
	private void dragElement(WebElement element, WebElement target) {
		try {
			driverWait.until(ExpectedConditions.elementToBeClickable(element));
			driverWait.until(ExpectedConditions.visibilityOf(target));
			actions.clickAndHold(element).moveToElement(target).release().build().perform();
		} catch (Exception e) {
			// none
		}
	}
}
