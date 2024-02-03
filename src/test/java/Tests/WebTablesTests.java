package Tests;

import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTests extends BaseTests {

    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to("https://demoqa.com/");
    }

    // test - dodavanje korisnika preko excel tabele i
    // asertacija da su svi uneti elementi prikazani
    @Test(priority = 10)
    public void userCanAddNewPerson(){
        homePage.clickOnElements();
        sideBarPage.clickOnSideBarButton("Web Tables");
        webTablesPage.getAddButton().click();
        String firstName = excelReader.getStringData("Sheet1", 1, 0);
        webTablesPage.inputFirstNameField(firstName);
        String lastName = excelReader.getStringData("Sheet1", 1, 1);
        webTablesPage.inputLastNameField(lastName);
        String email = excelReader.getStringData("Sheet1", 1, 2);
        webTablesPage.inputEmailField(email);
        int age = excelReader.getIntegerData("Sheet1", 1, 3);
        webTablesPage.inputAgeField(Integer.toString(age));
        int salary = excelReader.getIntegerData("Sheet1", 1, 4);
        webTablesPage.inputSalaryField(Integer.toString(salary));
        String department = excelReader.getStringData("Sheet1", 1, 5);
        webTablesPage.inputDepartmentField(department);
        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.getTableCell(firstName).isDisplayed());
        Assert.assertTrue(webTablesPage.getTableCell(lastName).isDisplayed());
        Assert.assertTrue(webTablesPage.getTableCell(Integer.toString(age)).isDisplayed());
        Assert.assertTrue(webTablesPage.getTableCell(email).isDisplayed());
        Assert.assertTrue(webTablesPage.getTableCell(Integer.toString(salary)).isDisplayed());
        Assert.assertTrue(webTablesPage.getTableCell(department).isDisplayed());
    }

    //test - ne mozemo uneti prazna polja kako bi dodali korisnika i
    // asertacija da li smo ostali u tom dijalogboxu  (obavezna polja)
    // i da nam nije omoguceno da predjemo na naredni korak
    @Test(priority = 20)
    public void userCannotAddNewPersonWithEmptyFields(){
        homePage.clickOnElements();
        sideBarPage.clickOnSideBarButton("Web Tables");
        webTablesPage.getAddButton().click();
        webTablesPage.inputFirstNameField("");
        webTablesPage.inputLastNameField("");
        webTablesPage.inputEmailField("");
        webTablesPage.inputAgeField("");
        webTablesPage.inputSalaryField("");
        webTablesPage.inputDepartmentField("");
        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.getSubmitButton().isDisplayed());
    }

    //test - unosi svih korisnika iz excel tabele i
    // asertacija za pretrazivanje po imenu korisnika iz tabele
    @Test(priority = 30)
    public void userCanSearchForPeopleByName(){
        homePage.clickOnElements();
        sideBarPage.clickOnSideBarButton("Web Tables");
        for(int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            webTablesPage.getAddButton().click();
            String firstName = excelReader.getStringData("Sheet1", i, 0);
            webTablesPage.inputFirstNameField(firstName);
            String lastName = excelReader.getStringData("Sheet1", i, 1);
            webTablesPage.inputLastNameField(lastName);
            String email = excelReader.getStringData("Sheet1", i, 2);
            webTablesPage.inputEmailField(email);
            int age = excelReader.getIntegerData("Sheet1", i, 3);
            webTablesPage.inputAgeField(Integer.toString(age));
            int salary = excelReader.getIntegerData("Sheet1", i, 4);
            webTablesPage.inputSalaryField(Integer.toString(salary));
            String department = excelReader.getStringData("Sheet1", i, 5);
            webTablesPage.inputDepartmentField(department);
            webTablesPage.clickOnSubmitButton();
        }

        webTablesPage.insertSearchField("Lazar");

        Assert.assertTrue(webTablesPage.getTableCell("Lazar").isDisplayed());
        Assert.assertTrue(webTablesPage.getTableCell("Lazic").isDisplayed());
        Assert.assertTrue(webTablesPage.getTableCell(Integer.toString(29)).isDisplayed());
        Assert.assertTrue(webTablesPage.getTableCell("llazic@gmail.com").isDisplayed());
        Assert.assertTrue(webTablesPage.getTableCell(Integer.toString(2900)).isDisplayed());
        Assert.assertTrue(webTablesPage.getTableCell("Legal").isDisplayed());
    }

    //test - brisanje korisnika sa liste
    //i asertacija da korisnik nije prikazan u tabeli
    @Test(priority = 40)
    public void userCanDeleteAPerson(){
        homePage.clickOnElements();
        sideBarPage.clickOnSideBarButton("Web Tables");

        webTablesPage.clickOnDeleteButton();

        Assert.assertFalse(elementIsDisplayed(webTablesPage.getTableCell("Cierra")));
        Assert.assertFalse(elementIsDisplayed(webTablesPage.getTableCell("Vega")));
        Assert.assertFalse(elementIsDisplayed(webTablesPage.getTableCell(Integer.toString(39))));
        Assert.assertFalse(elementIsDisplayed(webTablesPage.getTableCell("cierra@example.com")));
        Assert.assertFalse(elementIsDisplayed(webTablesPage.getTableCell(Integer.toString(10000))));
        Assert.assertFalse(elementIsDisplayed(webTablesPage.getTableCell("Insurance")));
    }

    //test - editovanje korisnika i asertacija da je prikazan editovan korisnik
    @Test(priority = 50)
    public void userCanEditAPerson(){
        homePage.clickOnElements();
        sideBarPage.clickOnSideBarButton("Web Tables");
        webTablesPage.clickOnEditButton();
        String firstName = excelReader.getStringData("Sheet1", 1, 0);
        webTablesPage.inputFirstNameField(firstName);
        String lastName = excelReader.getStringData("Sheet1", 1, 1);
        webTablesPage.inputLastNameField(lastName);
        String email = excelReader.getStringData("Sheet1", 1, 2);
        webTablesPage.inputEmailField(email);
        int age = excelReader.getIntegerData("Sheet1", 1, 3);
        webTablesPage.inputAgeField(Integer.toString(age));
        int salary = excelReader.getIntegerData("Sheet1", 1, 4);
        webTablesPage.inputSalaryField(Integer.toString(salary));
        String department = excelReader.getStringData("Sheet1", 1, 5);
        webTablesPage.inputDepartmentField(department);
        webTablesPage.clickOnSubmitButton();

        Assert.assertTrue(webTablesPage.getTableCell(firstName).isDisplayed());
        Assert.assertTrue(webTablesPage.getTableCell(lastName).isDisplayed());
        Assert.assertTrue(webTablesPage.getTableCell(Integer.toString(age)).isDisplayed());
        Assert.assertTrue(webTablesPage.getTableCell(email).isDisplayed());
        Assert.assertTrue(webTablesPage.getTableCell(Integer.toString(salary)).isDisplayed());
        Assert.assertTrue(webTablesPage.getTableCell(department).isDisplayed());
    }

    //test - next i previous button i
    // asertacija za navigaciju kada imamo vise stavki u tabeli
    @Test(priority = 60)
    public void userCanNavigateToPreviousAndNextPage(){
        homePage.clickOnElements();
        sideBarPage.clickOnSideBarButton("Web Tables");
        for(int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            webTablesPage.getAddButton().click();
            String firstName = excelReader.getStringData("Sheet1", i, 0);
            webTablesPage.inputFirstNameField(firstName);
            String lastName = excelReader.getStringData("Sheet1", i, 1);
            webTablesPage.inputLastNameField(lastName);
            String email = excelReader.getStringData("Sheet1", i, 2);
            webTablesPage.inputEmailField(email);
            int age = excelReader.getIntegerData("Sheet1", i, 3);
            webTablesPage.inputAgeField(Integer.toString(age));
            int salary = excelReader.getIntegerData("Sheet1", i, 4);
            webTablesPage.inputSalaryField(Integer.toString(salary));
            String department = excelReader.getStringData("Sheet1", i, 5);
            webTablesPage.inputDepartmentField(department);
            webTablesPage.clickOnSubmitButton();
        }

        scrollToElement(webTablesPage.getNextButton());

        Assert.assertFalse(webTablesPage.getPreviousButton().isEnabled());
        Assert.assertTrue(webTablesPage.getNextButton().isEnabled());

        webTablesPage.clickOnNextButton();

        Assert.assertTrue(webTablesPage.getPreviousButton().isEnabled());
        Assert.assertFalse(webTablesPage.getNextButton().isEnabled());

        webTablesPage.clickOnPreviousButton();

        Assert.assertFalse(webTablesPage.getPreviousButton().isEnabled());
        Assert.assertTrue(webTablesPage.getNextButton().isEnabled());
    }

    @AfterClass
    public void cleanUp(){
        driver.close();
    }
}
