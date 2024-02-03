package Tests;

import Base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import static java.lang.Thread.sleep;

public class TextBoxTests extends BaseTests {

    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to("https://demoqa.com/");
    }

    // test - unos validnih podataka i asertacija da je prikazan textbox sa unetim informacijama
    @Test(priority = 10)
    public void submitFormWithValidDetails(){
        homePage.clickOnElements();
        sideBarPage.clickOnSideBarButton("Text Box");
        textBoxPage.inputFullNameField("Milica");
        textBoxPage.inputEmailField("m@gmail.com");
        textBoxPage.inputCurrentAddressField("NN1");
        textBoxPage.inputPermanentAddressField("PP1");
        scrollToElement(textBoxPage.getSubmitButton());
        textBoxPage.clickOnSubmitButton();


        Assert.assertEquals("Name:Milica",textBoxPage.getResultField("name").getText());
        Assert.assertEquals("Email:m@gmail.com",textBoxPage.getResultField("email").getText());
        Assert.assertEquals("Current Address :NN1", textBoxPage.getResultField("currentAddress").getText());
        Assert.assertEquals("Permananet Address :PP1",textBoxPage.getResultField("permanentAddress").getText());
    }

    //test - za pogresno unet email i asertacija da  nije prikazan textbox
    // kao sto je prikazan kada se unesu validni podaci
    @Test(priority = 20)
    public void submitFormWithInvalidEmail(){
        homePage.clickOnElements();
        sideBarPage.clickOnSideBarButton("Text Box");
        textBoxPage.inputFullNameField("Milica");
        textBoxPage.inputEmailField("a");
        textBoxPage.inputCurrentAddressField("NN1");
        textBoxPage.inputPermanentAddressField("PP1");
        scrollToElement(textBoxPage.getSubmitButton());
        textBoxPage.clickOnSubmitButton();

        WebElement resultField = driver.findElement(By.id ("output"));
        Assert.assertTrue(resultField.findElements(By.id("name")).isEmpty());
        Assert.assertTrue(resultField.findElements(By.id("email")).isEmpty());
        Assert.assertTrue(resultField.findElements(By.id("current-address")).isEmpty());
        Assert.assertTrue(resultField.findElements(By.id("permanent-address")).isEmpty());

    }

    @AfterClass
    public void cleanUp(){
        driver.close();
    }


}
