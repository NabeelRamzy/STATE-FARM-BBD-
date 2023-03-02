package commonAction;

import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;
import reporting.Logs;

public class CommonAction {
	public void hoverover(WebDriver driver, WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
			Logs.log(element + ":Doing hover over");

		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Logs.log(element + "element Not Found");
			Assert.fail();

		}

	}
	public String elementText(WebElement element) {
		return element.getText();
	}
	
	public String getText(WebElement element, String expected) {
		String text = null;
		try {
			BaseClass.wait.until(ExpectedConditions.visibilityOf(element));
			text = element.getText();
			Logs.log("Actual Value : " + text);
			Assert.assertEquals(expected, text);
		} catch (NullPointerException e) {
			e.printStackTrace();
			Logs.log("Element Not Found");
			Assert.fail();
		}
		return text;
	}


	public void clickable(WebElement element) {
		try {
			BaseClass.wait.until(ExpectedConditions.visibilityOf(element));
			Logs.log(element + "clicked");
			element.click();

		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
			Logs.log(element + "element Not Found");
			Assert.fail();
		}

	}

	public void sendText(WebElement element, String value) {
		try {
			BaseClass.wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(value);
			Logs.log(element + ":Selected by visibility" + element);

		} catch (NoSuchWindowException e) {
			e.printStackTrace();
			Logs.log(element + ":Element not found");
			Assert.fail();

		}

	}

	public void dropDown(WebElement element, String text) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
			Logs.log(text + ":Entered text" + element);

		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Logs.log(text + ":Element not found");
			Assert.fail();
		}

	}

	public void radioButton(WebElement element) {
		try {
			BaseClass.wait.until(ExpectedConditions.visibilityOf(element));
			element.isSelected();
			Logs.log(element + ":Selected by visibility" + element);

		} catch (ElementClickInterceptedException e) {
			e.printStackTrace();
			Logs.log("Element not found");
			Assert.fail();

		}

	}

	public void sleep(int sec) {
		try {
			Thread.sleep(sec * 3000);
			Logs.log("Sleepin");
		} catch (InterruptedException e) {
			e.printStackTrace();
			Logs.log("Sleeping interuppted...");

		}
	}

}



