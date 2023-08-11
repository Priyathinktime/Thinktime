package FullProject.Abstract;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import FullProject.PageObject.PaymentPage;
import FullProject.PageObject.ProductPage;

public class AbstractClass {
	WebDriver driver;

	public AbstractClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[routerlink$='/dashboard/cart']")
	private WebElement card;
	@FindBy(css = ".infoWrap button:first-of-type")
	private WebElement buynow;

	public void WebElementtovisible(WebElement waitvisible) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(waitvisible));
	}

	public void Elementtovisible(By waitvisible) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(waitvisible));
	}

	public void Elementtoinvisible(By waitinvisible) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(waitinvisible));
	}

	public void Cardpage() {
		card.click();
	}

	public PaymentPage Buynow() {
		buynow.click();
		return new PaymentPage(driver);
	}

	public void scrolldown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
