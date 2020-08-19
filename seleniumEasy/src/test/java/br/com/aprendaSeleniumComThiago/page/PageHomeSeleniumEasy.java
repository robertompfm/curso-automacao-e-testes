package br.com.aprendaSeleniumComThiago.page;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.aprendaSeleniumComThiago.core.CoreDriver;


public class PageHomeSeleniumEasy{

	protected WebDriver driver;
	public PageHomeSeleniumEasy() {
		this.driver = CoreDriver.getDriver();
		PageFactory.initElements(CoreDriver.getDriver(), this);
	}

	@FindBy(xpath = "//div[@id='home']//h3[@class='head text-center']")
	private WebElement headPage;
	
	@FindBy(id="btn_basic_example")
	private WebElement inicioteste;
	
	@FindBy(xpath="//div[@id='basic']//h3[@class='head text-center']")
	private WebElement labelHeadBasicTest;
	
	@FindBy(linkText="Simple Form Demo")
	private WebElement linkSimpleFormDemo;
	
	
	public void acessarTestSelenium(String text) {
		inicioteste.click();
		WebDriverWait driverWait = new WebDriverWait(CoreDriver.getDriver(), 30);
		driverWait.until(ExpectedConditions.visibilityOf(linkSimpleFormDemo));
		Assert.assertEquals(text, labelHeadBasicTest.getText());
		linkSimpleFormDemo.click();
	}
	
}
