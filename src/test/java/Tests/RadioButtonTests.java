package Tests;

import Base.BaseTests;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTests extends BaseTests {

    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to("https://demoqa.com/");
    }

    //test - klik na Yes button i asertacija da je prikazana poruka da smo kliknuli na Yes button
    @Test(priority = 10)
    public void userCanClickOnYesButton(){
        homePage.clickOnElements();
        sideBarPage.clickOnSideBarButton("Radio Button");
//koristim js executor da bih mogla da kliknem na radioButton
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement yesButton = radioButtonPage.getYesButton();
        executor.executeScript("arguments[0].click();", yesButton);

        Assert.assertTrue(radioButtonPage.getResult("Yes").isDisplayed());
    }

    //test - klik na Impresive button i asertacija da je prikazana poruka da smo kliknuli na Impresive button
    @Test(priority = 20)
    public void userCanClickOnImpressiveButton(){
        homePage.clickOnElements();
        sideBarPage.clickOnSideBarButton("Radio Button");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement impressiveButton = radioButtonPage.getImpressiveButton();
        executor.executeScript("arguments[0].click();", impressiveButton);

        Assert.assertTrue(radioButtonPage.getResult("Impressive").isDisplayed());
    }

    //test - klik na No button i asertacija da je prikazana poruka da smo kliknuli na No button,
    // test je pao jer ne moze da se klikne na No button
    @Test(priority = 30)
    public void userCanClickOnNoButton(){
        homePage.clickOnElements();
        sideBarPage.clickOnSideBarButton("Radio Button");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement noButton = radioButtonPage.getNoButton();
        executor.executeScript("arguments[0].click();", noButton);

        Assert.assertTrue(radioButtonPage.getResult("No").isDisplayed());
    }

    @AfterClass
    public void cleanUp(){
        driver.close();
    }
}
