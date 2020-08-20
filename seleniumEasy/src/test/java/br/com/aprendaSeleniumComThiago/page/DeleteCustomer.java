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


public class DeleteCustomer {

	private int TIME_OUT;
	public static String URL = "http://demo.guru99.com/test/delete_customer.php";
	protected WebDriver driver;
	public DeleteCustomer() {
		this.driver = CoreDriver.getDriver();
		PageFactory.initElements(CoreDriver.getDriver(), this);
		this.TIME_OUT = 30;
	}
	
	// WEB ELEMENTS
	@FindBy(name = "cusid")
	WebElement inputCustomerID;

	@FindBy(name = "submit")
	WebElement buttonSubmit;
	
	
	// FILL CUSTOMER ID FIELD	
	public void fillInputField(String customerID) {
		inputCustomerID.clear();
		inputCustomerID.sendKeys(customerID);
	}
	
	// SUBMIT
	public void submit() {
		waitElement(buttonSubmit);
		buttonSubmit.click();
	}
	
	// WAIT FOR ELEMENT TO BE VISIBLE
	public void waitElement(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(this.driver, this.TIME_OUT);
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	// WAIT FOR ALERT
	public void waitAlert() {
		WebDriverWait driverWait = new WebDriverWait(this.driver, this.TIME_OUT);
		driverWait.until(ExpectedConditions.alertIsPresent());
	}
	
	// ACCEPT ALERT MESSAGE
	public void acceptAlert() {
		waitAlert();
		this.driver.switchTo().alert().accept();
	}
	
	// CONFIRM MESSAGE
	public void confirmSuccessMessage() {
		waitAlert();
		assertEquals("Customer Successfully Delete!", this.driver.switchTo().alert().getText());
	}
}
