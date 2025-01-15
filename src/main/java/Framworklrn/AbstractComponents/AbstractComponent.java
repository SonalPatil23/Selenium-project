package Framworklrn.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framworklrn.pageobject.CartPage;
import Framworklrn.pageobject.OrderPage;

public class AbstractComponent {

	WebDriver driver;

	private static final int TIMEOUT = 50;

	public AbstractComponent(WebDriver driver) 
	{
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}


	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;


	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;


	public void zoomOut() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
	}


	public void waitForElementToVisible(By findBy)
	{

		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(TIMEOUT));
		wait.until(ExpectedConditions.visibilityOfElementLocated (findBy));

	}


	public void waitForwebElementToAppear(WebElement findBy)
	{

		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(TIMEOUT));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}



	public OrderPage goToOrderPage()

	{

		orderHeader.click();
		OrderPage OrderPage= new OrderPage(driver);
		return OrderPage;
	}

	public CartPage goToCartPage()

	{

		cartHeader.click();
		CartPage CartPage= new CartPage(driver);
		return CartPage;

	}


	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		//		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(TIMEOUT));
		//		wait.until(ExpectedConditions.invisibilityOf(ele));

		Thread.sleep(20000);


	}


}
