package frameworklrn.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;

import Framworklrn.pageobject.CartPage;
import Framworklrn.pageobject.CheckoutPage;
import Framworklrn.pageobject.OrderPage;
import Framworklrn.pageobject.ProductCatalogue;
import Framworklrn.pageobject.confirmationPage;
import frameworklrn.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest{

	String productName = "ADIDAS ORIGINAL";

	@Test(dataProvider= "getData", groups= "Purchase")
	public void submitOrder(HashMap<String, String>input )throws IOException, InterruptedException
	{

		ProductCatalogue ProductCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

		List<WebElement>products = ProductCatalogue.getProductsList();

		ProductCatalogue.addProductToCart(input.get("Product"));
		CartPage CartPage =ProductCatalogue.goToCartPage();

		Boolean match = CartPage.VerifyProductDisplay(input.get("Product"));
		Assert.assertTrue(match);
		CheckoutPage CheckoutPage =CartPage.goToCheckout();

		CheckoutPage.selectCountry("India");
		confirmationPage confirmationPage =CheckoutPage.submitOrder();


		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//		driver.close();
	}


	@Test(dependsOnMethods={"submitOrder"})

	public void OrderHistoryTest()
	{
		//"ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage. loginApplication("anshika@gmail.com", "Iamking@000");
		OrderPage ordersPage = productCatalogue.goToOrderPage();
		Assert.assertTrue(ordersPage. VerifyOrderDisplay (productName));

	}


	private TakesScreenshot driver() {
		// TODO Auto-generated method stub
		return null;
	}


	@DataProvider
	public Object[][] getData() throws IOException
	{

		//        	 HashMap<String, String> map = new HashMap<String, String>();
		//        	 map.put("email", "anshika@gmail.com");
		//        	 map.put("password", "Iamking@000");
		//        	 map.put("Product", "ZARA COAT 3");
		//        	 
		//        	 
		//        	 HashMap<String, String> map1 = new HashMap<String, String>();
		//        	 map1.put("email", "shetty@gmail.com");
		//        	 map1.put("password", "Iamking@000");
		//        	 map1.put("Product", "ADIDAS ORIGINAL");

		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//frameworklrn//data//PurchaseOrder.json");
		return new Object [] [] { {data.get(0)}, {data.get(1)} };

	}


	//       @DataProvider
	//       public Object[] [] getData1()
	//       {
	//       return new Object[] [] {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"}, {"shetty@gmail.com","Iamking@000", "ADIDAS ORIGINAL"}};
	//      
	//       }
}
