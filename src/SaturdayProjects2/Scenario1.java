package SaturdayProjects2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Scenario1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burcu\\OneDrive\\Documents\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://shopdemo.e-junkie.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String cartItemAfterAdding="1";
        String cartItemAfterRemoving="0";

        WebElement addToCart = driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));
        addToCart.click();

        WebElement iFrame1 = driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));

        wait.until(ExpectedConditions.visibilityOf(iFrame1));

        driver.switchTo().frame(iFrame1);

        WebElement addedCartItem = driver.findElement(By.xpath("//*[@id=\"Overlay\"]/div/div[2]/div/div[2]/div[1]/span"));
        String validateCartItem = addedCartItem.getText();

        if (validateCartItem.equals(cartItemAfterAdding)){
            System.out.println("Pass!");
        } else {
            System.out.println("Fail!");
        }

        WebElement removeButton = driver.findElement(By.cssSelector("button[class ='Product-Remove']"));
        wait.until(ExpectedConditions.visibilityOf(removeButton));
        removeButton.click();

        //Thread.sleep(3000);

        WebElement continueShoppingButton = driver.findElement(By.xpath("//button[@class ='Continue-Button Close-Cart']"));
        wait.until(ExpectedConditions.visibilityOf(continueShoppingButton));
        continueShoppingButton.click();

        //Thread.sleep(3000);

        driver.switchTo().defaultContent();

        //Thread.sleep(3000);

        WebElement validateItemAfterRemoving = driver.findElement(By.xpath("(//span[@id='cart_item_nos'])[2]"));
        wait.until(ExpectedConditions.visibilityOf(validateItemAfterRemoving));
        String ItemCartTextAfterRemoving = validateItemAfterRemoving.getText();

        if (ItemCartTextAfterRemoving.equals(cartItemAfterRemoving)){
            System.out.println("Pass!");
        } else {
            System.out.println("Fail!");
        }
        driver.quit();
    }

}
