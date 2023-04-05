package SaturdayProjects3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Scenario5 {

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

        WebElement enterCardNumber = driver.findElement(By.cssSelector("input[name='cardnumber']"));
        wait.until((ExpectedConditions.visibilityOf(enterCardNumber)));
        enterCardNumber.sendKeys("4242 4242 4242 4242");

        WebElement cardExpiry = driver.findElement(By.cssSelector("input[placeholder='MM / YY']"));
        wait.until((ExpectedConditions.visibilityOf(cardExpiry)));
        cardExpiry.sendKeys("12 / 22");

        WebElement cardCVV = driver.findElement(By.cssSelector("input[placeholder='CVC']"));
        wait.until((ExpectedConditions.visibilityOf(cardCVV)));
        cardCVV.sendKeys("000");

        driver.switchTo().parentFrame();

        WebElement payButton = driver.findElement(By.cssSelector("button[class='Pay-Button']"));
        wait.until(ExpectedConditions.visibilityOf(payButton));
        payButton.click();

        driver.get("https://www.fatfreecartpro.com/ecom/rp.php?rdffc=true&txn_id=st-ch_3LTpkGFWSmRjvnlt0J8TNPFM&payer_email=bcf%40gmail.com&client_id=341695&c_id=158229701&c_enc=6de685b001538c1b23e44521979ed918&cart_metadata=%7B%22gtag%22%3A%7B%22gtag%22%3A%22UA-273877-2%22%2C%22_ga%22%3A%222.95970644.978282402.1659802851-773778012.1659802851%22%7D%2C%22fbp%22%3A%7B%22fbp%22%3A%221714673711932838%22%7D%2C%22cart_source%22%3A%22https%3A%2F%2Fshopdemo.e-junkie.com%2F%22%2C%22em_updates%22%3Atrue%7D&&pending_reason=&_ga=2.95970644.978282402.1659802851-773778012.1659802851&&gajs=&auser=&abeacon=&");

        WebElement thankYouMessage = driver.findElement(By.xpath("//span[text()='Betty, your order is confirmed. Thank you!']"));
        String messageAfterPay = thankYouMessage.getText();
        System.out.println(messageAfterPay);


        String expectedMessage = "Betty, your order is confirmed. Thank you!";

        if (expectedMessage.equals(messageAfterPay)) {
            System.out.println("Pass!");
        } else {
            System.out.println("Fail!");
        }

        driver.quit();

    }

}
