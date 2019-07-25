package test;

import help.BaseTest;
import help.Helpermethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TemaRegister extends BaseTest {

    public Helpermethods functions = new Helpermethods(driver);

    @Test
    public void deschide ()  {


//        System.setProperty("webdriver.gecko.driver","C:\\automation\\FirefoxDriver\\geckodriver.exe");
//        driver=new FirefoxDriver();
//        driver.get("http://demo.automationtesting.in/Register.html");
//        driver.manage().window().maximize();



        //validam pagina de registrare (the register page was displayed)
        String expectedregister =BaseTest.getvalue("registerpage");
//        String actualregister = driver.getTitle();
//        Assert.assertEquals(expectedregister, actualregister);
        functions.validatepagetitle(expectedregister, driver);



        //completarea fieldurilor
        String firstnamevalue = BaseTest.getvalue("firstname");
        WebElement firstnameweb = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
//        firstnameweb.sendKeys(firstnamevalue);

        String lastnamevalue = BaseTest.getvalue("lastname");
        WebElement lastnameweb=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastnameweb.sendKeys(lastnamevalue);

        String addressvalue = BaseTest.getvalue("address");
        WebElement addressweb = driver.findElement(By.xpath("//textarea[@rows='3']"));
        addressweb.sendKeys(addressvalue);

        String emailvalue = System.currentTimeMillis()+"@gmail.com";
        WebElement emailweb = driver.findElement(By.xpath("//input[@type='email']"));
        emailweb.sendKeys(emailvalue);

        String phonevalue = System.currentTimeMillis()+"";
        String newphone = phonevalue.substring(1,11);
        WebElement phoneweb = driver.findElement(By.xpath("//input[@type='tel']"));
        phoneweb.sendKeys(newphone);

// Languages dropdown list
        driver.findElement(By.id("msdd")).click();
        List<WebElement> languages=driver.findElements(By.xpath("//a[@class='ui-corner-all']"));
        for(int i=0;i<languages.size();i++)
        {
            System.out.println(languages.get(i).getText());
            if(languages.get(i).getText().equalsIgnoreCase(BaseTest.getvalue("language")))
            {
                languages.get(i).click();
                break;
            }
        }

//        WebElement languagesclick = driver.findElement(By.id("msdd"));
//        languagesclick.click();
////        driver.findElement(By.id("msdd")).click();
//        WebElement englishclick = driver.findElement(By.xpath("//a[contains(text(),'English')]"));
//        englishclick.click();
//        driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
//        WebElement languagesdropdown = driver.findElement(By.xpath("//a[contains(text(),'English')]"));
//        String languages = "English";
//        Select langageselect = new Select(languagesdropdown);
//        langageselect.selectByValue(languages);



//        WebElement femalevalue = driver.findElement(By.xpath("//input[@value='FeMale']"));
//        femalevalue.click();

        List<WebElement> genderlist = driver.findElements(By.xpath("//input[@type='radio']"));
        for(int index=0; index< genderlist.size(); index++) {
            String curentelement = genderlist.get(index).getAttribute("value");
            if (curentelement.contains(BaseTest.getvalue("gender"))){
                genderlist.get(index).click();
            }
        }


        WebElement moviesvalue = driver.findElement(By.xpath("//input[@value='Movies']"));
        moviesvalue.click();

        WebElement skillsdropdown = driver.findElement(By.xpath("//select[@id='Skills']"));
        String skillsvalue = BaseTest.getvalue("skill");
//        Select skillselect = new Select(skillsdropdown);
//        skillselect.selectByVisibleText(skillsvalue);
        functions.selectbytextdropdown(skillsdropdown, skillsvalue);

        WebElement countrydropdown = driver.findElement(By.xpath("//select[@id='countries']"));
        String countryvalue= BaseTest.getvalue("country");
//        Select countryselect = new Select(countrydropdown);
//        countryselect.selectByVisibleText(countryvalue);
        functions.selectbytextdropdown(countrydropdown,countryvalue);

//        WebElement selectcontry = driver.findElement(By.xpath("//span[@class='select2-selection__arrow']"));
//        selectcontry.click();
//        WebElement netherlands = driver.findElement(By.xpath("//li[contains(text(),'Netherlands')]"));
//        netherlands.click();

        WebElement selectcountryydropdown = driver.findElement(By.xpath("//select[@id='country']"));
        String selectcountryvalue= BaseTest.getvalue("selectcountry");
        functions.selectbytextdropdown(selectcountryydropdown,selectcountryvalue);

        WebElement yeardropdown = driver.findElement(By.xpath("//select[@id='yearbox']"));
        String yearvalue = BaseTest.getvalue("year");
        functions.selectbyvaluedropdown(yeardropdown,yearvalue);

        WebElement monthdropdown = driver.findElement(By.xpath("//select[@placeholder='Month']"));
        String monthvalue = BaseTest.getvalue("month");
        functions.selectbytextdropdown(monthdropdown,monthvalue);

        WebElement daydropdown = driver.findElement(By.xpath("//select[@id='daybox']"));
        String dayvalue = BaseTest.getvalue("day");
        functions.selectbyvaluedropdown(daydropdown,dayvalue);
//        Select dayselect= new Select(daydropdown);
//        dayselect.selectByValue(dayvalue);

//        WebElement foto=driver.findElement(By.xpath("//input[@type='file']"));
//        foto.click();

        String passwordvalue = BaseTest.getvalue("passwordvalid");
        WebElement passwordweb  = driver.findElement(By.xpath("//input[@id='firstpassword']"));
        passwordweb.sendKeys(passwordvalue);

        String confirmvalue = BaseTest.getvalue("confirmpassword");
        WebElement confirmweb = driver.findElement(By.xpath("//input[@id='secondpassword']"));
        confirmweb.sendKeys(confirmvalue);
//      confirmweb.sendKeys(passwordvalue);


        WebElement submitbutton = driver.findElement(By.xpath("//button[@name='signup']"));
        submitbutton.click();
//        submitbutton.click();
//
//        WebElement refreshbutton = driver.findElement(By.xpath("//button[@id='Button1']"));
//        refreshbutton.click();

//        WebElement imagewebelement = driver.findElement(By.xpath("//img[@id='imagetrgt']"));
//        if (imagewebelement.isDisplayed()){
//            Assert.assertTrue(imagewebelement.isDisplayed());
//        }





        //validarea ca suntem pe pagina noua
//        WebElement message = driver.findElement(By.xpath("//h4[1]"));
        // WAIT EXPLICIT
//        new WebDriverWait(driver,7500).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h4[1]")));

//        Thread.sleep(4500);
//        Assert.assertTrue("The message is not displayed",message.isDisplayed());

    }

}
