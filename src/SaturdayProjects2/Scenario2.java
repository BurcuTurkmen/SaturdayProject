package SaturdayProjects2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Scenario2 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burcu\\OneDrive\\Documents\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://shopdemo.e-junkie.com/");

        String invalidValidate = "Invalid promo code";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addToCart = driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));
        addToCart.click();

        WebElement iFrame = driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(iFrame));
        driver.switchTo().frame(iFrame);

        Thread.sleep(3000);

        WebElement addPromoCodeButton = driver.findElement(By.xpath("//button[text()='Add Promo Code']"));
        wait.until(ExpectedConditions.visibilityOf(addPromoCodeButton));
        addPromoCodeButton.click();

        Thread.sleep(3000);

        WebElement addPromoCode = driver.findElement(By.cssSelector("input[placeholder='Promo Code']"));
        wait.until(ExpectedConditions.visibilityOf(addPromoCode));
        addPromoCode.sendKeys("123456789");

        WebElement applyButton = driver.findElement(By.cssSelector("button[class='Promo-Apply']"));
        wait.until((ExpectedConditions.visibilityOf(applyButton)));
        applyButton.click();

        //WebElement invalidPromo = new WebDriverWait(driver, Duration.ofSeconds(10))
         //       .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SnackBar']/span")));

        WebElement invalidPromoCode = driver.findElement(By.xpath("//*[@id='SnackBar']/span"));
        wait.until((ExpectedConditions.visibilityOf(invalidPromoCode)));
        String invalidPromoText = invalidPromoCode.getText();

        if (invalidPromoText.equals(invalidValidate)) {
            System.out.println("Pass!");
        } else {
            System.out.println("Fail!");
        }
        //driver.quit();

        }
}
