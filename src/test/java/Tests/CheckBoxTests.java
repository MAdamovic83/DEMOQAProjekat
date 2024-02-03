package Tests;

import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTests extends BaseTests {

    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to("https://demoqa.com/");
    }

    //test - otvaranje svih elemenata
    @Test(priority = 10)
    public void expendAllButtonShowsAllCheckBoxes() {
        homePage.clickOnElements();
        sideBarPage.clickOnSideBarButton("Check Box");
        checkBoxPage.clickOnExpandAllButton();

        Assert.assertTrue(checkBoxPage.getCheckBox("Desktop").isDisplayed());
        Assert.assertTrue(checkBoxPage.getCheckBox("Documents").isDisplayed());
        Assert.assertTrue(checkBoxPage.getCheckBox("Office").isDisplayed());
        Assert.assertTrue(checkBoxPage.getCheckBox("Downloads").isDisplayed());

    }

    //test - otvaranje svih elemenata, cekiranje dva elementa i
    // asertacija da su ta dva elementa cekirana
    @Test(priority = 20)
    public void checkBoxPage(){
        homePage.clickOnElements();
        sideBarPage.clickOnSideBarButton("Check Box");
        checkBoxPage.clickOnExpandAllButton();

        scrollToElement(checkBoxPage.getCheckBox("Classified"));
        checkBoxPage.clickOnCheckBox("Classified");

        scrollToElement(checkBoxPage.getCheckBox("Excel File.doc"));
        checkBoxPage.clickOnCheckBox("Excel File.doc");

        Assert.assertTrue(checkBoxPage.getResult("classified").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("excelFile").isDisplayed());
    }

    //test - cekiranje Home elementa i asertacija da su svi elementi prikazani
    @Test(priority = 30)
    public void clickingOnHomeCheckBoxSelectsAllCheckBoxes(){
        homePage.clickOnElements();
        sideBarPage.clickOnSideBarButton("Check Box");

        checkBoxPage.clickOnCheckBox("Home");

        Assert.assertTrue(checkBoxPage.getResult("home").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("desktop").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("notes").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("commands").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("documents").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("workspace").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("react").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("angular").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("veu").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("office").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("public").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("private").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("classified").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("general").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("downloads").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("wordFile").isDisplayed());
        Assert.assertTrue(checkBoxPage.getResult("excelFile").isDisplayed());
    }

    @AfterClass
    public void cleanUp(){
        driver.close();
    }
}
