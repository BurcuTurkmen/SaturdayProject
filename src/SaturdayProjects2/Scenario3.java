package SaturdayProjects2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Scenario3 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burcu\\OneDrive\\Documents\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://shopdemo.e-junkie.com/");

        String invalidVerify = "Invalid Email\nInvalid Email\nInvalid Billing Name";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addToCart = driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));
        addToCart.click();

        WebElement iFrame = driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(iFrame));
        driver.switchTo().frame(iFrame);

        WebElement debitCardPay = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        wait.until(ExpectedConditions.visibilityOf(debitCardPay));
        debitCardPay.click();

        Thread.sleep(2000);

        WebElement payButton = driver.findElement(By.cssSelector("#Overlay > div > div.container.Cart > div > div.column.one-half.RightColumn > div.Checkout-Options > button.Pay-Button"));
        wait.until(ExpectedConditions.visibilityOf(payButton));
        payButton.click();

        Thread.sleep(2000);

        WebElement invalidPay = driver.findElement(By.cssSelector("div[id='SnackBar']>span"));
        String invalidPayText = invalidPay.getText();

        if (invalidVerify.equals(invalidPay)) {
            System.out.println("pass!");
        } else {
            System.out.println("fail!");
        }



        //WebElement invalidPay = driver.findElement(By.xpath("//*[@id='SnackBar']/span"));
        //wait.until(ExpectedConditions.visibilityOf(invalidPay));







    }



}
