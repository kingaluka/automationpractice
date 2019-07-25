package test;

import help.Helpermethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class WebElementTest {

    public WebDriver driver;
    public Helpermethods functions = new Helpermethods(driver);

    @Test
    public void start()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();


        //  validam register page !!!
        String expectedregister = "Register";
        String actualregister=driver.getTitle();
        Assert.assertEquals(expectedregister,actualregister);


        //completezi first name field
        //VALOARE PE CARE VREAU SA ADUG
        String firstnamevalue = "Kinga";
        //IDENTIFICARE WEBELEMENT
        WebElement firstnameweb=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        //completeaza
        firstnameweb.sendKeys(firstnamevalue);

        String lastnamevalue = "Luka";
        WebElement lastnameweb=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastnameweb.sendKeys(lastnamevalue);


// da click
        WebElement maleweb=driver.findElement(By.xpath("//input[@value='Male']"));
        maleweb.click();


        List<WebElement> hobbyweb=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int contor=0; contor<hobbyweb.size(); contor++){
            String curentelement=hobbyweb.get(contor).getAttribute("value");
            if(curentelement.contains("Movies")){
                hobbyweb.get(contor).click();
            }
        }



// selecteaza din dropdown
        WebElement yeardropdown=driver.findElement(By.xpath("//select[@id='yearbox']"));
        String yearvalue="2011";
        Select yearselect=new Select(yeardropdown);
        yearselect.selectByValue(yearvalue);

        WebElement monthdropdown=driver.findElement(By.xpath("//select[@placeholder='Month']"));
        String monthvalue="September";
        Select monthselect=new Select(monthdropdown);
        monthselect.selectByVisibleText(monthvalue);

        String expectedmessage="Register";
        WebElement message=driver.findElement(By.xpath("//h2"));
        functions.validatemessage(message,expectedmessage);
//        String actualmessage=message.getText();
//        Assert.assertTrue(expectedmessage.equals(actualmessage));
    }
}
