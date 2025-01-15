package frameworklrn.tests;
import java.io.IOException;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;
import Framworklrn.pageobject.CartPage;
import Framworklrn.pageobject.CheckoutPage;
import Framworklrn.pageobject.ProductCatalogue;
import Framworklrn.pageobject.confirmationPage;
import frameworklrn.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest{



	@Test(groups= {"ErrorHandling"})
	public void LoginErrorValidation()throws IOException, InterruptedException
	{
		String productName = "ADIDAS ORIGINAL";
		
		landingPage.loginApplication("anshika@gmail.com", "Iamking@000.");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
         zoomOut();
	}


	@Test
	public void ProductErrorValidation()throws IOException, InterruptedException
	{

		String productName = "ADIDAS ORIGINAL";

		ProductCatalogue ProductCatalogue = landingPage.loginApplication("sonal31@gmail.com", "Sonal@1234");

		List<WebElement>products = ProductCatalogue.getProductsList();

		ProductCatalogue.addProductToCart(productName);
		CartPage CartPage =ProductCatalogue.goToCartPage();

		Boolean match = CartPage.VerifyProductDisplay("ADIDAS ORIGINAL");
//		Assert.assertFalse(match);
	    Assert.assertTrue(match, "Product is not displayed in the cart!");


//
	}
	
}
