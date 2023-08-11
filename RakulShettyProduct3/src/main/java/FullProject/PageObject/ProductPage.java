package FullProject.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import FullProject.Abstract.AbstractClass;

public class ProductPage  extends AbstractClass{
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	   @FindBy(css=".mb-3")
	   List<WebElement> products;
	   By addtoCart= By.cssSelector(".card-body button:last-of-type");
	   By waitvis=By.cssSelector("#toast-container");
	   By waitinvis=By.cssSelector(".ng-animating");
	   By productLocator=By.cssSelector("b");
	  public List<WebElement> productList()
	  {  
		return products;  
	  }
	  
	  public WebElement getproductName(String item)
	  {
		  return products.stream().filter(productName->productName.findElement(productLocator)
	    		  .getText().equals(item)).findFirst().orElse(null);	  
	  }
	  public boolean checkproduct(String item) {
		 boolean match= products.stream().anyMatch(productName->
		 productName.findElement(productLocator).getText().equalsIgnoreCase(item));
		 return match;
	  }
	  
	  public void addToCart(WebElement product) {
		 product.findElement(addtoCart).click();
		 Elementtovisible(waitvis);
		 Elementtoinvisible(waitinvis);

	  }
	  

}
