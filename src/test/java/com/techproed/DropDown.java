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
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown
{
    //Bir class oluşturun: DropDown
    //https://the-internet.herokuapp.com/dropdown adresine gidin.
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //4.Tüm dropdown değerleri(value) yazdırın
    //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

     WebDriver driver;

    @Before
    public  void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public  void dropDownTest()
    {
        WebElement selectElement=driver.findElement(By.id("dropdown"));

      //public class Select implements ISelect, WrapsElement {
        Select options= new Select(selectElement);

        System.out.println(options.getFirstSelectedOption());//default olan option'ın referansını verir
        //[[[[ChromeDriver: chrome on WINDOWS (8c85a1cfb279fde13a38942269d22710)] -> id: dropdown]] -> tag name: option]

        String option1=options.getFirstSelectedOption().getText();
        System.out.println(option1);//Please select an option


        //dropdown'da element belirlemenin 3 yolu var.
        //return (nothing)type methods
        //selectByIndex()
        //selectByValue("")
        //selectByVisibleText


        options.selectByIndex(1);//webpage'da option1 secilir
        //<option value="2" selected="selected">Option 2</option>
        options.selectByValue("2");////webpage'da option1 secilir
        options.selectByVisibleText("Option 1");

        //Select options= new Select(selectElement);
        List<WebElement> allOptions=options.getOptions();//ı created a list which has WebElement
        /*
          @Override
          public List<WebElement> getOptions() {
          return element.findElements(By.tagName("option"));
          }
         */


        for(WebElement i: allOptions)
            System.out.println(i.getText());
        //Please select an option
        //Option 1
        //Option 2

        System.out.println((allOptions.size()==4 ) ? "True" : "false: "+allOptions.size());

        Assert.assertFalse(allOptions.size()==4) ;//void value


        System.out.println(options.getAllSelectedOptions());//[[[[[ChromeDriver: chrome on WINDOWS (1f7c872e748ab5ca9821ca357946d0de)] -> id: dropdown]] -> tag name: option]]

        List<WebElement> allItems=options.getAllSelectedOptions();
        System.out.println(allItems.size());
        for (WebElement i: allItems) {
            System.out.println(i.getText());
        }
    }



    @After
    public void close()
    {
        //driver.close();
    }



}
