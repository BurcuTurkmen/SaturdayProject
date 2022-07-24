package SaturdayProjects1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Part3 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burcu\\OneDrive\\Documents\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://www.snapdeal.com");

        String text = "teddy bear";
        WebElement searchBar = driver.findElement(By.id("inputValEnter"));
        searchBar.sendKeys(text);

        Thread.sleep(3000);

        WebElement clickSearch = driver.findElement(By.cssSelector(".searchTextSpan"));
        clickSearch.click();

        Thread.sleep(3000);

        WebElement searchResult = driver.findElement(By.cssSelector("#searchMessageContainer > div > span"));
        String searchText = searchResult.getText();
        System.out.println(searchText);

        Thread.sleep(3000);

        String url = driver.getCurrentUrl();
        System.out.println("URL: " + url);

        WebElement snapDealLogo = driver.findElement(By.cssSelector(".notIeLogoHeader.aspectRatioEqual.sdLogo.cur-pointer"));
        snapDealLogo.click();

        String url1 = driver.getCurrentUrl();
        System.out.println("URL: " + url1);

        driver.navigate().back();

        Thread.sleep(3000);

        WebElement checkText = driver.findElement(By.id("inputValEnter"));
        String displayedText = checkText.getAttribute("value");
        System.out.println(displayedText);

        Thread.sleep(5000);

        if (text.equals(displayedText)) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }

        Thread.sleep(3000);

        driver.quit();

    }

}
