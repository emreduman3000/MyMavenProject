package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectClass_Dropdown {


    WebDriver driver;

    @Before
    public  void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        WebElement createNewAccount= driver.findElement(By.xpath("(//a[contains(@class,'_42ft')])[3]"));
        createNewAccount.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test()
    {
        Select selection = new Select(driver.findElement(By.xpath("//select[@title='Month']")));
        selection.selectByIndex(5);
        //selection.deselectByIndex(1);

        selection.selectByVisibleText("May");
        //selection.deselectByVisibleText("Jan");

        selection.selectByValue("5");
        //selection.deselectByValue("1");

        //deselectAll()
        //This method clears all the selected entries.
        //This is only valid when the drop-down element supports multiple selections.

        //selection.deselectAll();

        //getOptions( ) : List<WebElement>
        List<WebElement> optionList= selection.getOptions();
        System.out.println(optionList.size());

        //getAllSelectedOptions() –
        optionList=selection.getAllSelectedOptions();
        System.out.println(optionList.size());

        //getFirstSelectedOption()
        WebElement monthDropdown = selection.getFirstSelectedOption();
        String first=monthDropdown.getText();
        System.out.println(first);

        //isMultiple(): boolean –
        // This method informs whether the Select element supports
        // multiple selection options at the same time or not.
        // This method accepts nothing and returns a boolean value (true/false).

        //Use the isMultiple method to select multiple commands.

        Boolean b=selection.isMultiple();
        System.out.println(b);

    }

    @After
    public void teardown()
    {
        driver.close();
    }
}
