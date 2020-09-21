import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import javax.sound.midi.Receiver;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.Duration;

public class RegistrationTest {

    private static WebDriver driver;
    private static final String NAME = "Gil";
    private static final String OTHER_NAME = "Shai";
    private static final String PASSWORD = "Ggil1234";
    private static final String EMAIL = "sdc@gbt.com";
    private static final String MYPHONENUMBER = "0528541212";
    private static final String RECEIVINGPHONENUMBER = "0528541213";

    @BeforeClass
    public void configuration() throws Exception{
        String type = getData("browserType");
        if(type.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Idan\\Desktop\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if(type.equals("IE")){
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        String url = getData("url");
        driver.get(url);
    }
    public static String getData (String keyName) throws Exception{
        File fXmlFile = new File("src/test/resources/WebProject.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

    @Test
    public void introTest(){

//        driver = new ChromeDriver();
//        driver.get("https://buyme.co.il/");

//  I detected an error in the header so I made a bypass
//        driver.findElement(By.xpath("/html/body/div[2]/div/header/div[1]/div/ul[1]/li[3]/a"));


        // A - Intro & Registration screen
////        Registration button
        WebElement registrationForm = driver.findElement(By.id("ember676"));
//        registrationForm.findElement(By.xpath("div/ul[1]/li[3]/a")).click();


//        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/p/span")).click();
//        // Name
//        driver.findElement(By.id("ember1179")).sendKeys(NAME);
//        // Email
//        driver.findElement(By.id("ember1181")).sendKeys(EMAIL);
//        // pwd
//        driver.findElement(By.id("valPass")).sendKeys(PASSWORD);
//        // pwd verification
//        driver.findElement(By.id("ember1185")).sendKeys(PASSWORD);
//        // Submit verification
//        WebElement registrationForm = driver.findElement(By.id("ember1177"));
//        registrationForm.findElement(By.xpath("button")).click();
//
//        Assert.assertEquals(driver.findElement(By.id("ember1179")).getAttribute("value"), NAME);
//        Assert.assertEquals(driver.findElement(By.id("ember1181")).getAttribute("value"), EMAIL);

        // B - HOME SCREEN
        // Logging in

        // Closing registration pop-up
//        driver.findElement(By.id("ember1153")).click();
        // Entering "כניסה"
        registrationForm.findElement(By.xpath("div/ul[1]/li[3]/a")).click();

        driver.findElement(By.id("ember1165")).sendKeys(EMAIL);
        driver.findElement(By.id("ember1167")).sendKeys(PASSWORD);

        // Form of Entering BuyMe login button
        driver.findElement(By.id("ember1157")).findElement(By.xpath("button")).click();
        //

        WebElement selectionForm = driver.findElement(By.id("ember731"));

        // Pick Price Button
        selectionForm.findElement(By.xpath("div[1]/a/span")).click();
        selectionForm.findElement(By.xpath("div[1]/div/ul/li[2]")).click();

        // Pick Region Button
        selectionForm.findElement(By.xpath("div[2]/a/span")).click();
        selectionForm.findElement(By.xpath("div[2]/div/ul/li[7]")).click();

        // Pick Category Button
        selectionForm.findElement(By.xpath("div[3]/a/span")).click();
        selectionForm.findElement(By.xpath("div[3]/div/ul/li[4]")).click();

        // Pressing find "תמצא לי"
        driver.findElement(By.id("ember798")).click();

        // C - Pick Business

        // Wait until the page is uploaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ember1322")));

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://buyme.co.il/search?budget=1&category=22&region=16");

        // Select Azrieli gift card
        driver.findElement(By.id("ember1339")).click();

        // Entering a sum
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ember1468")));
        driver.findElement(By.id("ember1468")).sendKeys("50");

        // Pressing לבחירה
        WebElement selectingForm = driver.findElement(By.id("ember1467"));
        selectingForm.findElement(By.xpath("div[2]/div/button")).click();

        // D - Sender & Receiver information screen

        // Send to someone else
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ember1583")));
        driver.findElement(By.id("ember1583")).findElement(By.xpath("label[1]")).click();

        // Receiver name
        driver.findElement(By.id("ember1589")).sendKeys(OTHER_NAME);

        // Choose Event
        driver.findElement(By.id("ember1592")).findElement(By.xpath("div")).click();
        driver.findElement(By.id("ember1592")).findElement(By.xpath("div/div/ul/li[4]")).click();

        // Uploading a picture
     //   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ember1622")));
        driver.findElement(By.id("ember1622")).sendKeys("‪C:\\Users\\Idan\\Desktop\\20190809_205036.jpg");

        // Press radio button
        driver.findElement(By.id("ember1528")).findElement(By.xpath("div[3]/div/div[1]/label[1]")).click();

        // Pick Email / SMS
        driver.findElement(By.id("ember1535")).findElement(By.xpath("div/div[1]/div[1]/div/button/span/span[1]")).click();

        // Enter Email / Phone No.
        driver.findElement(By.id("ember2058")).sendKeys(MYPHONENUMBER);
        driver.findElement(By.id("resendReciver")).sendKeys(RECEIVINGPHONENUMBER);

        // Save
        driver.findElement(By.id("ember1535")).findElement(By.xpath("div/div[5]/div[2]/button[2]")).click();

        // Assertions
        Assert.assertEquals(driver.findElement(By.id("ember1589")).getAttribute("value"), OTHER_NAME);
        Assert.assertEquals(driver.findElement(By.id("ember2058")).getAttribute("value"), MYPHONENUMBER);
        Assert.assertEquals(driver.findElement(By.id("resendReciver")).getAttribute("value"), RECEIVINGPHONENUMBER);

     }
}
