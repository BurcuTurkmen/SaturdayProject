package SaturdayProjects3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Scenario4 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burcu\\OneDrive\\Documents\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://shopdemo.e-junkie.com/");

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

        WebElement emailInput = driver.findElement(By.cssSelector("input[placeholder='Email']"));
        wait.until((ExpectedConditions.visibilityOf(emailInput)));
        emailInput.sendKeys("bcf@gmail.com");

        WebElement ConfirmEmail = driver.findElement(By.cssSelector("input[placeholder='Confirm Email']"));
        wait.until((ExpectedConditions.visibilityOf(ConfirmEmail)));
        ConfirmEmail.sendKeys("bcf@gmail.com");

        WebElement nameOnCard = driver.findElement(By.cssSelector("input[placeholder='Name On Card']"));
        wait.until((ExpectedConditions.visibilityOf(nameOnCard)));
        nameOnCard.sendKeys("Betty Swanson");

        WebElement iFrameCard = driver.findElement(By.xpath("//*[@id='Stripe-Element']/div/iframe"));
        wait.until(ExpectedConditions.visibilityOf(iFrameCard));
        driver.switchTo().frame(iFrameCard);

        Thread.sleep(2000);

        WebElement enterCardNumber = driver.findElement(By.cssSelector("input[name='cardnumber']"));
        wait.until((ExpectedConditions.visibilityOf(enterCardNumber)));
        enterCardNumber.sendKeys("1111 1111 1111 1111");

        driver.switchTo().parentFrame();

        WebElement invalidCardNumber = driver.findElement(By.xpath("//span[text()='Your card number is invalid.']"));
        wait.until((ExpectedConditions.visibilityOf(invalidCardNumber)));
        String messageAfterPay = invalidCardNumber.getText();

        String expectedInvalidCardText = "Your card number is invalid.";

        if (expectedInvalidCardText.equals(messageAfterPay)) {
            System.out.println("Pass!");
        } else {
            System.out.println("Fail!");
        }

        driver.quit();

    }

}
