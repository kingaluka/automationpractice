package test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;
import java.util.ArrayList;

public class FirstClass {




    //declaram o variabila WebDriver:
    public WebDriver driver;

    //declaram o metoda:
    @Test
    public void start1 (){

        System.setProperty("webdriver.chrome.driver","C:\\automation\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        // declaram un obiect, deschid un browser
        driver.get("https://www.travellerspoint.com/");
        //accesezi un link, metoda get deschide linkul, daca apelezi cu driverul
        driver.manage().window().maximize();
        //se deschide site-ul in full screen
        driver.close();
        //close-inchide un tab dintr-un browser
        //quite-inchide browserul total
    }

    @Test
    public void start2 (){

        System.setProperty("webdriver.gecko.driver","C:\\automation\\FirefoxDriver\\geckodriver.exe");
        driver=new FirefoxDriver();
        // declaram un obiect, deschid un browser
        driver.get("https://www.travellerspoint.com/");
        //accesezi un link, metoda get deschide linkul, daca apelezi cu driverul
        driver.manage().window().maximize();
        //se deschide site-ul in full screen
        driver.close();
        //close-inchide un tab dintr-un browser
        //quite-inchide browserul total
    }

    @Test
    public void start()
    {


        System.setProperty("webdriver.chrome.driver", "C:\\automation\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");


        //deschidem un nou tab
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.google.com/");
        driver.close();
        driver.switchTo().window(tabs.get(0));


        driver.quit();
    }



    @Test
    public void start3()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.google.com/");

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> newtabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newtabs.get(2));
        driver.get("http://www.glawgroup.com/");
        driver.manage().window().maximize();
        driver.close();

        driver.switchTo().window(tabs.get(1));

        driver.close();
        driver.switchTo().window(tabs.get(0));

        driver.quit();
    }
    //file new proiect
}
