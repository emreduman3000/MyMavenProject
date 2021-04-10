package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BestBUY {
    /*
     Bir class oluşturun: Tekrar_BeforeAfter_BestBuy
    Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun      https://www.bestbuy.com/
    titleTest => Sayfa başlığının “Best” içerdiğini(contains) doğrulayın
    logoTest => BestBuy logosunun görüntülenip görüntülenmediğini doğrulayın
    mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
    Her testten sonra tarayıcıyı kapatin
     */

    /*
      <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
     */
    protected WebDriver driver;

    @Before
    public void driverSetup()
    {
        // System.setProperty("webdriver.chrome.driver","C:/Users/Emre Duman/Documents/selenium dependencies/drivers/chromedriver.exe");


        /*
        <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>4.0.0</version>
        </dependency>
         */

        //public abstract class WebDriverManager {}
        WebDriverManager.chromedriver().setup();


        //public static synchronized WebDriverManager chromedriver() {
        driver = new ChromeDriver();

        driver.get("https://www.bestbuy.com/");

        //Yavas web siteleri icin implicitly wait kullanilabilir.sayfa acılır ve bekler 10 saniye sonra kodlar calısır
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void titleTest()
    {
        String actualTitle=driver.getTitle();
        String expectedTitle="Best";
        if(actualTitle.contains(expectedTitle))
            System.out.println("PASS -The title contains 'Best'");
        else
            System.out.println("FAIL -The title does not contain 'Best'");
    }

    @Test
    public  void logoTest()
    {
        WebElement bestBuyLogo=driver.findElement(By.xpath("//img[@alt='Best Buy Logo']"));

        Assert.assertTrue(bestBuyLogo.isDisplayed());

    }
    @Test
    public void mexicoLinkTest()
    {
        WebElement mexicoLink=driver.findElement(By.partialLinkText("Mexico"));
        if(mexicoLink.isDisplayed())
            System.out.println("PASS - displayed");
        else
            System.out.println("FAIL");
    }

    @After
    public void tearDown()
    {
        driver.close();
    }
}
