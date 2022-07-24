package SaturdayProjects1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burcu\\OneDrive\\Documents\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://demoqa.com/text-box");

        driver.manage().window().maximize();

        Thread.sleep(3000);

        String name = "Automation";
        String email = "Testing@gmail.com";
        String address = "Testing Current Address";
        String permanentAddress = "Testing Permanent Address";

        WebElement enterName = driver.findElement(By.id("userName"));
        enterName.sendKeys(name);

        WebElement enterEmail = driver.findElement(By.id("userEmail"));
        enterEmail.sendKeys(email);

        WebElement enterAddress = driver.findElement(By.id("currentAddress"));
        enterAddress.sendKeys(address);

        WebElement enterPermanentAddress = driver.findElement(By.id("permanentAddress"));
        enterPermanentAddress.sendKeys(permanentAddress);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement displayName = driver.findElement(By.id("name"));
        String nameText = displayName.getText();
        System.out.println(nameText);

        WebElement displayEmail = driver.findElement(By.id("email"));
        String emailText = displayEmail.getText();
        System.out.println(emailText);

        WebElement displayCurrentAddress = driver.findElement((By.cssSelector("#currentAddress.mb-1")));
        String addressText = displayCurrentAddress.getText();
        System.out.println(addressText);

        WebElement displayPermanentAddress = driver.findElement((By.cssSelector("#permanentAddress.mb-1")));
        String permanentAddressText = displayPermanentAddress.getText();
        System.out.println(permanentAddressText);

        Thread.sleep(3000);

        driver.quit();

    }

}
