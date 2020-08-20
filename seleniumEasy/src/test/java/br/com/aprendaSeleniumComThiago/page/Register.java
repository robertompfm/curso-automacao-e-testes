package br.com.aprendaSeleniumComThiago.page;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.aprendaSeleniumComThiago.core.CoreDriver;


public class Register{

	public static String URL = "http://demo.guru99.com/test/newtours/register.php";
	protected WebDriver driver;
	public Register() {
		this.driver = CoreDriver.getDriver();
		PageFactory.initElements(CoreDriver.getDriver(), this);
	}
	
	// CONTACT INFO FIELDS
	@FindBy(name = "firstName")
	WebElement inputFirstName;

	@FindBy(name = "lastName")
	WebElement inputLastName;

	@FindBy(name = "phone")
	WebElement inputPhone;

	@FindBy(name = "userName")
	WebElement inputEmail;
	
	// MAILING INFO FIELDS
	@FindBy(name = "address1")
	WebElement inputAddress;

	@FindBy(name = "city")
	WebElement inputCity;

	@FindBy(name = "state")
	WebElement inputState;

	@FindBy(name = "postalCode")
	WebElement inputPostalCode;
	
	@FindBy(name = "country")
	WebElement selectCountry;
	
	// USER INFO FIELDS
	@FindBy(name ="email")
	WebElement inputUserName;
	
	@FindBy(name = "password")
	WebElement inputPassword;
	
	@FindBy(name = "confirmPassword")
	WebElement inputConfirmPassword;
	
	// SUBMIT BUTTON
	@FindBy(name = "submit")
	WebElement buttonSubmit;
	
	
	// FILL INPUT FIELDS METHODS
	public void fillContactInfoFields(String firstName, String lastName, String phone, String email) {
		fillInputField(inputFirstName, firstName);
		fillInputField(inputLastName, lastName);
		fillInputField(inputPhone, phone);
		fillInputField(inputEmail, email);
	}
	

	public void fillMailingInfoFields(String address, String city, String state, 
			String postalCode, String country) {
		fillInputField(inputAddress, address);
		fillInputField(inputCity, city);
		fillInputField(inputState, state);
		fillInputField(inputPostalCode, postalCode);
		selectItem(selectCountry, country.toUpperCase());
	}
	
	public void fillUserInfoFields(String userName, String password, String confirmPassword) {
		fillInputField(inputUserName, userName);
		fillInputField(inputPassword, password);
		fillInputField(inputConfirmPassword, confirmPassword);
	}
	
	private void fillInputField(WebElement field, String input) {
		field.clear();
		field.sendKeys(input);
	}
	
	private void selectItem(WebElement selectElement, String item) {
		Select dropdown = new Select(selectElement);
		dropdown.selectByVisibleText(item);
	}
	
	// SUBMIT
	public void submit() {
		waitElement(buttonSubmit);
		buttonSubmit.click();
	}
	
	// WAIT FOR ELEMENT
	public void waitElement(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(this.driver, 30);
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}
}
