package test;

import help.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//mosteneste driverul din BaseTest
public class TemaLogin extends BaseTest {
    public String emailvalue;
    public String passwordvalue;

    @Test

    public void test1 (){


        emailvalue =""+ BaseTest.getvalue("emailvalues");
        passwordvalue =""+ BaseTest.getvalue("passwordvalues");
        String[] parseEmail=emailvalue.split(",");
        String[] parsePassword=passwordvalue.split(",");

// validarea pagina de Register
        String expectedpaginaderesiter =BaseTest.getvalue("registerpage");
        String actualpaginaderegister = driver.getTitle();
        Assert.assertEquals(expectedpaginaderesiter,actualpaginaderegister);

//din registerpage dam click pe home button
        WebElement homebutton = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        homebutton.click();

// validarea Homepage
        String expectedhomepage = BaseTest.getvalue("homepage");
        String actualhomepage = driver.getTitle();
        Assert.assertEquals(expectedhomepage,actualhomepage);

//dam click pe signin button
        WebElement signinbutton = driver.findElement(By.xpath("//button[@id='btn1']"));
        signinbutton.click();

//validam pagina signin
        String expectedsigninpage = BaseTest.getvalue("Loginpagetitle");
        String actualsigninpage = driver.getTitle();
        Assert.assertEquals(expectedsigninpage,actualsigninpage);


//1. login with inexistent values for all field
        WebElement emailfield1 = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
        String emailinexistentvalue = parseEmail[3];
        emailfield1.sendKeys(emailinexistentvalue);

        WebElement passwordfield1 = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String pswinexistentvalue = parsePassword[3];
        passwordfield1.sendKeys(pswinexistentvalue);

        WebElement enterbutton1 = driver.findElement(By.xpath("//img[@id='enterbtn']"));
        enterbutton1.click();

// validam messajul de eroare si pagina de sign in
        WebElement errormessage = driver.findElement(By.xpath("//label[@id='errormsg']"));
        String expectederrormessage = BaseTest.getvalue("Errormessage");
        String actualerrormessage = errormessage.getText();
        Assert.assertEquals(expectederrormessage,actualerrormessage);

        Assert.assertEquals(expectedsigninpage,actualsigninpage);


//// sterge email
//        driver.findElement(By.xpath("//input[@placeholder='E mail']")).clear();
//// sterge password
//        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
//   refresh la pagina
//        driver.get("http://demo.automationtesting.in/SignIn.html");
        driver.navigate().refresh();
//        driver.get(driver.getCurrentUrl());



// 2. email corect, password gresit
//        Assert.assertEquals(expectederrormessage,actualerrormessage);
        WebElement emailfield2 = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
        String emailcorect = parseEmail[1];
        emailfield2.sendKeys(emailcorect);

        WebElement passwordfield2 = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passwordgresitvalue = parsePassword[0];
        passwordfield2.sendKeys(passwordgresitvalue);

        WebElement enterbutton2 = driver.findElement(By.xpath("//img[@id='enterbtn']"));
        enterbutton2.click();

        Assert.assertEquals(expectederrormessage,actualerrormessage);
        Assert.assertEquals(expectedsigninpage,actualsigninpage);

// 3. email gresit, password corect
//        WebElement toClearemail = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
//        toClearemail.clear();
//        WebElement toClearpassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
//        toClearpassword.clear();

        driver.navigate().refresh();

        WebElement emailfield3 = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
        String emailgresitvalue = parseEmail[0];
        emailfield3.sendKeys(emailgresitvalue);

        WebElement passwordfield3 = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passwordcorectvalue = parsePassword[1];
        passwordfield3.sendKeys(passwordcorectvalue);

        WebElement enterbutton3 = driver.findElement(By.xpath("//img[@id='enterbtn']"));
        enterbutton3.click();

        Assert.assertEquals(expectederrormessage,actualerrormessage);
        Assert.assertEquals(expectedsigninpage,actualsigninpage);

// 4. email si password gresit
//        driver.findElement(By.xpath("//input[@placeholder='E mail']")).clear();
//        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
        driver.navigate().refresh();

        WebElement emailfield4 = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
        String emailgresit2 = parseEmail[0];
        emailfield4.sendKeys(emailgresit2);

        WebElement passwordfield4 = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passwordgresit2 = parsePassword[0];
        passwordfield4.sendKeys(passwordgresit2);

        WebElement enterbutton4 = driver.findElement(By.xpath("//img[@id='enterbtn']"));
        enterbutton4.click();

        WebElement errormsg = driver.findElement(By.xpath("//label[@id='errormsg']"));
        if (errormsg.isDisplayed()){
            Assert.assertTrue(errormsg.isDisplayed());
        }
        Assert.assertEquals(expectedsigninpage,actualsigninpage);

// 5. email + password cu caractere speciale
//        driver.findElement(By.xpath("//input[@placeholder='E mail']")).clear();
//        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
        driver.navigate().refresh();

        WebElement emailfield5 = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
        String emailcaracter = parseEmail[4];
        emailfield5.sendKeys(emailcaracter);

        WebElement passwordfield5 = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passwordcaracter = parsePassword[4];
        passwordfield5.sendKeys(passwordcaracter);

        WebElement enterbutton5 = driver.findElement(By.xpath("//img[@id='enterbtn']"));
        enterbutton5.click();

        Assert.assertEquals(expectederrormessage,actualerrormessage);
        Assert.assertEquals(expectedsigninpage,actualsigninpage);

// 6. email + password cu spatiu
//        driver.findElement(By.xpath("//input[@placeholder='E mail']")).clear();
//        driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
        driver.navigate().refresh();

        WebElement emailfield6 = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
        String emailspatiu = parseEmail[2];
        emailfield6.sendKeys(emailspatiu);

        WebElement passwordfield6 = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passwordspatiu = parsePassword[2];
        passwordfield6.sendKeys(passwordspatiu);

        WebElement enterbutton6 = driver.findElement(By.xpath("//img[@id='enterbtn']"));
        enterbutton6.click();

        Assert.assertEquals(expectederrormessage,actualerrormessage);
        Assert.assertEquals(expectedsigninpage,actualsigninpage);


        
    }

}
