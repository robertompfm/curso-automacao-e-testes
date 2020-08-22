package br.com.aprendaSeleniumComThiago.test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.aprendaSeleniumComThiago.core.CoreBaseTest;
import br.com.aprendaSeleniumComThiago.core.CoreDriver;
import br.com.aprendaSeleniumComThiago.page.PageDrag;

public class ChallengeDragAndDrop extends CoreBaseTest{
	
	
	@Test
	public void dragTest() {
		PageDrag page = new PageDrag();
		page.navigateToPage();
		page.dragAllElements();
		String successMsg = page.getSuccessMessage();
		assertEquals("Test failed", "Perfect!", successMsg);
	}
	
}
