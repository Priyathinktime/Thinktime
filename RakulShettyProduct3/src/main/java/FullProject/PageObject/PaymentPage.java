package FullProject.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FullProject.Abstract.AbstractClass;

public class PaymentPage extends AbstractClass {
	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder='Select Country']")
	WebElement selectcountry;
	@FindBy(css = ".ta-results button:nth-child(3)")
	WebElement selectbycountryname;
	@FindBy(css = ".action__submit")
	WebElement placeorder;
	

	public void selectcountry(String namecountry) {
		selectcountry.sendKeys(namecountry);

	}

	public void selectcountryname() {
		selectbycountryname.click();

	}

	public ConfirmPage summit() throws InterruptedException {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 1300)");
		scrolldown(placeorder);
		Thread.sleep(3000);
		placeorder.click();
		return new ConfirmPage(driver);
	}
}
