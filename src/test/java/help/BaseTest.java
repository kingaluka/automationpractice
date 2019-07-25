package help;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {


    public WebDriver driver;
    public static Properties property;
    public FileInputStream file;


    @Before
    public void test() throws FileNotFoundException {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();

        //        Wait implicit
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loadproperty();


    }

//    metoda care iti incarce o fisier de proprietati

    public void loadproperty () throws FileNotFoundException {
        property = new Properties();
        file = new FileInputStream("C:\\Users\\Bogar\\IdeaProjects\\probaAutomation\\src\\test\\resources\\InputData.properties");
        try {
            property.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

//  metoda care returneaza valoare dint-un fis.prop. pe baza unui Key

    public static String getvalue (String key){

        return property.getProperty(key);
    }

//    @After
//    public void inchide (){
//        driver.quit();
//    }

}
