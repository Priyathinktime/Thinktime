package FullProject.TestClass;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import FullProject.PageObject.ConfirmPage;
import FullProject.PageObject.LoginPage;
import FullProject.PageObject.PaymentPage;
import FullProject.PageObject.ProductPage;

public class FullprojectTest extends BaseTest {
	@Test(retryAnalyzer =Retry.class)
	public void fullproject() throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(getDriver());
		lp.GoTo();

		ProductPage products = lp.login("harijava007@gmail.com", "Hari007@");
		products.productList();
		WebElement product = products.getproductName("IPHONE 13 PRO");
		products.addToCart(product);
		products.Cardpage();
		PaymentPage pay = products.Buynow();
		pay.selectcountry("Ind");
		pay.selectcountryname();
		ConfirmPage confirm = pay.summit();
		String confirmmsg = confirm.getmsg();
		System.out.println(confirmmsg);
		Assert.assertTrue(confirmmsg.equalsIgnoreCase("THANK YOU FOR THE ORDER."));
		

	}

}
