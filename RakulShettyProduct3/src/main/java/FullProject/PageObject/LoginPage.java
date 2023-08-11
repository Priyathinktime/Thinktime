package FullProject.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FullProject.Abstract.AbstractClass;

public class LoginPage extends AbstractClass{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (id="userEmail")
	private WebElement email;
	@FindBy (id="userPassword")
	private WebElement pass;
	@FindBy (id="login")
	private WebElement logins;
	@FindBy(css = "div[aria-label='Incorrect email or password.']")
	WebElement ErrorMsg;
	
//	Login page 
 public ProductPage login(String Email,String Password) {
	
	 email.sendKeys(Email);
	 pass.sendKeys(Password);
	 logins.click();
	 return new ProductPage(driver);
	

 }
 public String ErrorMassage() {
	 WebElementtovisible(ErrorMsg);
	return ErrorMsg.getText();
 }

// launch the website
 public void GoTo() {
	 
	 driver.get("https://rahulshettyacademy.com/client/");
 }
}
