package br.com.aprendaSeleniumComThiago.page;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.aprendaSeleniumComThiago.core.CoreDriver;


public class PageBasicFormDemo{

	protected WebDriver driver;
	public PageBasicFormDemo() {
		this.driver = CoreDriver.getDriver();
		PageFactory.initElements(CoreDriver.getDriver(), this);
	}
	
	@FindBy(id = "user-message")
	WebElement inputMenssage;
	
	@FindBy(xpath ="//button[contains(text(),'Show Message')]")
	WebElement botaoEnviarMsg;
	
	@FindBy(xpath ="//label[contains(text(),'Your Message:')]")
	WebElement labelMensagemEnviada;
	
	@FindBy(id = "display")
	WebElement labelDisplay;	
	
	public void preencherMensagem(String texto) {
		inputMenssage.clear();
		inputMenssage.sendKeys(texto);
	}
	public void clickEnviarMensagem() {
		aguardarElemento(botaoEnviarMsg);
		botaoEnviarMsg.click();
	}
	
	
	public void validaMensagem(String texto) {
		WebDriverWait driverWait = new WebDriverWait(CoreDriver.getDriver(), 30);
		driverWait.until(ExpectedConditions.visibilityOf(labelDisplay));
		Assert.assertEquals(texto, labelDisplay.getText());
	}
	public void aguardarElemento(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(this.driver, 30);
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}
}
