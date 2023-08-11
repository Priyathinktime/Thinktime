package FullProject.TestClass;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FullProject.PageObject.LoginPage;
import FullProject.PageObject.ProductPage;

public class ProductPageTest extends BaseTest {

	public WebElement product;

	@Test(dataProvider = "items")
	public void productselect(String item) throws IOException {
		LoginPage lp = new LoginPage(getDriver());
		lp.GoTo();
		ProductPage products = lp.login("harijava007@gmail.com", "Hari007@");
		products.productList();
		product = products.getproductName(item);
		Assert.assertTrue(products.checkproduct(item));


	}

	@DataProvider
	public Object[][] items() {
		return new Object[][] { { "ZARA COAT 3" }, { "IPHONE 13 PRO" }, { "ADIDAS ORIGINAL" }, { "fghnn" } };
	}

}
