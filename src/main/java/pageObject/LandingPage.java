package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import commonAction.CommonAction;

public class LandingPage {
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
   }
	

	@FindBy(xpath = "//select[@id='popDropdown']")
	public WebElement productDropDown;
	@FindBy(xpath = "//input[@id='quote-main-zip-code-input']")
	public WebElement zipCodeField;
	@FindBy(xpath = "//button[@id='quote-main-zip-btn']")
	public WebElement startAQuoteTab;
	
	
	public void productDropDownMethod(CommonAction cA) {
		BaseClass.cA.dropDown(productDropDown,"Small Business");
	}
	public void zipCodeFieldMethod(CommonAction cA) {
		BaseClass.cA.sendText(zipCodeField,"11355");
	}
	public void startAQuoteTabMethod(CommonAction cA) {
		BaseClass.cA.clickable(startAQuoteTab);		
	}
}