package Framworklrn.pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Framworklrn.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;

	public LandingPage(WebDriver driver) {

		super(driver);
		this.driver=driver;
		PageFactory.initElements (driver, this);
		
		 zoomOut(); 
	}
	
	
	
	@FindBy(id="userEmail")
	WebElement userEmail;

	@FindBy(id="userPassword")
	WebElement Password;

	@FindBy(id="login")
	WebElement submit;

	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	
	public ProductCatalogue loginApplication(String email, String password) 
	{
		userEmail.sendKeys(email);
		Password.sendKeys(password);
		submit.click();
		ProductCatalogue ProductCatalogue = new ProductCatalogue(driver);
		return ProductCatalogue;
	}
	
	
	public String getErrorMessage()
	{
		waitForwebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	

	public void gotTo()
	
	{
		driver.get("https://rahulshettyacademy.com/client");
	}


}




