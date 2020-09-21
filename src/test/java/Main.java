import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.net.URL;
import java.util.List;
import java.util.Set;

public class Main {
    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Idan\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://buyme.co.il/");
//
//        driver.findElement(By.id("source"));
//        System.out.println(driver.findElements(By.id("source")).size());
//        driver.findElement(By.id("source")).sendKeys("hello");

//        driver.get("https://walla.co.il");
        //   }
        //       public static void title() {
//        String TitleWalla = "וואלה! NEWS - האתר המוביל בישראל - עדכונים מסביב לשעון";
//        driver.navigate().refresh();
//        Assert.assertEquals(driver.getTitle(), TitleWalla);
//
//        String URLWalla = "https://walla.co.il";
//        Assert.assertEquals(driver.getCurrentUrl(), URLWalla);

//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Idan\\Desktop\\chromedriver.exe");
//        driver = new ChromeDriver();

//        driver.get("https://translate.google.com/");
//        System.out.println(driver.findElement(By.id("source")));
//        System.out.println(driver.findElement(By.tagName("textarea")));

//        driver.get("https://www.youtube.com/");
//        System.out.println(driver.findElement(By.id("logo-icon-container")));

//        driver.get("https://www.amazon.com/");
//        System.out.println(driver.findElement(By.id("logo-icon-container")));
//        String amazonTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs &amp; more";
//        Assert.assertEquals(driver.getTitle(), amazonTitle);
//        driver.findElement(By.id("twotabsearchtextbos")).sendKeys("Leather Shoes");

//        driver.get("https://translate.google.com/");
//        driver.findElement(By.id("source")).sendKeys("בית");

//        driver.get("https://www.youtube.com/");
//        driver.findElement(By.id("search")).sendKeys("השיר על תוכי יוסי");
//        driver.findElement(By.id("search-icon-legacy")).click();

//        driver.get("https://www.facebook.com/");
//        driver.findElement(By.id("email")).sendKeys("");
//        driver.findElement(By.id("pass")).sendKeys("");
    }
}