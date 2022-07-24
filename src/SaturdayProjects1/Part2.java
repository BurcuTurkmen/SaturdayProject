package SaturdayProjects1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part2 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burcu\\OneDrive\\Documents\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.applitools.com");

        driver.manage().window().maximize();

        Thread.sleep(3000);

        String username = "ttechno@gmail.com";
        String password = "techno123";

        WebElement enterUsername = driver.findElement(By.id("username"));
        enterUsername.sendKeys(username);

        Thread.sleep(3000);

        WebElement enterPassword = driver.findElement(By.id("password"));
        enterPassword.sendKeys(password);

        Thread.sleep(3000);

        WebElement signInButton = driver.findElement(By.id("log-in"));
        signInButton.click();

        Thread.sleep(3000);

        WebElement header = driver.findElement(By.id("time"));
        String str = header.getText();
        String url = driver.getCurrentUrl();

        System.out.println(" ");
        System.out.println("Header Text: " + str);
        System.out.println("URL: " + url);

        Thread.sleep(3000);






    }

}
