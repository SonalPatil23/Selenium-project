package Framworklrn.pageobject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Framworklrn.AbstractComponents.AbstractComponent;
public class confirmationPage extends AbstractComponent{

	WebDriver driver;

	public confirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements (driver, this);
		 zoomOut(); 

	}
	

	
	@FindBy(css = ".hero-primary")
	private WebElement confirmationMessage;

	public String getConfirmationMessage()
	{
		CheckoutPage cp = new CheckoutPage(driver);	
		return confirmationMessage.getText();
	}
}




