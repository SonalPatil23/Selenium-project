package frameworklrn.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium. WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Framworklrn.pageobject.LandingPage;

public class StandAloneTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
        setBrowserZoom(driver, 60);

		
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingPage = new LandingPage(driver);

		driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		driver.findElement(By.id("login")).click();

		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements (By.cssSelector(".mb-3"));
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector("#toast-container")));
		//ng-animating
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		List <WebElement> cartProducts = driver.findElements (By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch (cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);

		
		// Wait until the element is visible and clickable
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));

		// Scroll to the element to bring it into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		try {
		    // Attempt to click the element
		    element.click();
		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
		    // If the element is still intercepted, use JavaScript to click
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}





		Actions a = new Actions (driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector(".ta-results")));
		
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(@class,'ta-item')])[2]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);

		try {
		    // Attempt to click the element
		    element2.click();
		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
		    // If the element is still intercepted, use JavaScript to click
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);
		}
		
		
		
		
	//	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')][2]")).click();
		WebElement PlaceOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));
		PlaceOrder.click();
		

		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		driver.close();
	}

	public static void setBrowserZoom(WebDriver driver, int zoomPercent) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("document.body.style.zoom='" + zoomPercent + "%'");
    
	}


}





















