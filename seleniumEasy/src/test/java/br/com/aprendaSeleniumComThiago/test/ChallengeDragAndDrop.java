package br.com.aprendaSeleniumComThiago.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.aprendaSeleniumComThiago.core.CoreBaseTest;
import br.com.aprendaSeleniumComThiago.core.CoreDriver;

public class ChallengeDragAndDrop extends CoreBaseTest{
	
	@Test
	public void dragTest() {
		WebDriverWait driverWait = new WebDriverWait(CoreDriver.getDriver(), 30);
		Actions actions = new Actions(driver);
		Action dragAndDrop = null;
		
		driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");
		WebElement fiveThousandBtn = driver.findElement(By.id("fourth"));
		WebElement debitAmountTarget = driver.findElement(By.id("amt7"));
		WebElement creditAmountTarget = driver.findElement(By.id("amt8"));
		WebElement debitAccountTarget = driver.findElement(By.id("bank"));
		WebElement creditAccountTarget = driver.findElement(By.id("loan"));
		WebElement bankBtn = driver.findElement(By.id("credit2"));
		WebElement loanBtn = driver.findElement(By.id("credit1"));
		WebElement perfectBtn = driver.findElement(By.xpath("//*[@id=\"equal\"]/a"));
		driverWait.until(ExpectedConditions.visibilityOfAllElements(
				debitAmountTarget,
				creditAmountTarget,
				debitAccountTarget,
				creditAccountTarget));
		driverWait.until(ExpectedConditions.elementToBeClickable(fiveThousandBtn));
		dragAndDrop = actions.clickAndHold(fiveThousandBtn).moveToElement(debitAmountTarget).release().build();
		dragAndDrop.perform();
		dragAndDrop = actions.clickAndHold(fiveThousandBtn).moveToElement(creditAmountTarget).release().build();
		dragAndDrop.perform();
		driverWait.until(ExpectedConditions.elementToBeClickable(bankBtn));
		dragAndDrop = actions.clickAndHold(bankBtn).moveToElement(debitAccountTarget).release().build();
		dragAndDrop.perform();
		driverWait.until(ExpectedConditions.elementToBeClickable(bankBtn));
		dragAndDrop = actions.clickAndHold(loanBtn).moveToElement(creditAccountTarget).release().build();
		dragAndDrop.perform();
		driverWait.until(ExpectedConditions.visibilityOf(perfectBtn));
		String result = perfectBtn.getText();
		assertEquals("Test failed", "Perfect!", result);
	}
	
	
}
