package P2PProject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {

    // Make WebDriver a class-level variable
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");

        driver = new ChromeDriver(options);
        driver.get("https://p2p-web.electreecity.in/auth/");
    }

    @Test
    public void login() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        WebElement MobNumber = wait.until(ExpectedConditions.elementToBeClickable(By.id("signConsumerNo")));
        MobNumber.sendKeys("2000026621");

        System.out.print("Hello sonal");
//        WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
//        pass.sendKeys("Test@1234");
//
//        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginbtnviaConNo")));
//        login.click();

        // Additional assertions can be added here to verify successful login
    }

//    @AfterMethod
//    public void tearDown() {
//        // Close the browser
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}


