package FullProject.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FullProject.Abstract.AbstractClass;

public class ConfirmPage extends AbstractClass{
	WebDriver driver;
	public ConfirmPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".hero-primary")
	WebElement confirmmsg;
	
	public String getmsg() {
		return confirmmsg.getText();
	}
}
