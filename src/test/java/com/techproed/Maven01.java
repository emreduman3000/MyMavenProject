package com.techproed;


    import com.github.javafaker.Faker;
    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.Keys;

    import org.junit.Test;



public class Maven01
{
    //java compiler 8 yap

    public static void main(String[] args) {
        //Maven projesinde System.setProperty("",""); kullanmayiz.
        // Bunun yerine WebDriverManager kullaniriz.
        //chrome driver icin;
        WebDriverManager.chromedriver().setup(); //kirmizi olmasinin sebebi eksik dependency lerin olmasindandir.
        //Dependency ler nereden alinir???  https://mvnrepository.com/ git ve WebDriverManager ara
        WebDriver driver = new ChromeDriver();  //https://mvnrepository.com/ git ve selenium java ara
        driver.get("https://www.google.com");


        WebElement searchBox=driver.findElement(By.name("q"));


        /*
          <!-- https://mvnrepository.com/artifact/com.github.javafaker/javafaker -->
        <dependency>
            <groupId>com.github.javafaker</groupId>
            <artifactId>javafaker</artifactId>
            <version>1.0.2</version>
        </dependency>
         */

        // faker objecti olustur
        Faker faker = new Faker();
        //Searchboxa fake data gonder ve ENTER tusuna bas.
        System.out.println(faker.country().capital());
        System.out.println(faker.address().city());
        System.out.println(faker.name().firstName());
        //    import org.openqa.selenium.Keys;
        searchBox.sendKeys(faker.country().capital()+Keys.ENTER);
        //searchBox.click();
        //searchBox.submit();


        //randomly, name and surname is entered+click submit

        /*
        WebElement searchBox2=driver.findElement(By.className("pR49Ae gsfi"));
        searchBox2.sendKeys(faker.country().flag());
        searchBox2.submit();
        */


    }
}

