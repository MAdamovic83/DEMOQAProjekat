package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTablesPage {
    WebDriver driver;


    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddButton() {
        return driver.findElement(By.id("addNewRecordButton"));
    }
    public WebElement getFirstNameField(){
        return driver.findElement(By.id("firstName"));
    }
    public WebElement getLastNameField(){
        return driver.findElement(By.id("lastName"));
    }
    public WebElement getEmailField(){
        return driver.findElement(By.id("userEmail"));
    }
    public WebElement getAgeField(){
        return driver.findElement(By.id("age"));
    }
    public WebElement getSalaryField(){
        return driver.findElement(By.id("salary"));
    }
    public WebElement getDepartmentField(){
        return driver.findElement(By.id("department"));
    }
    public WebElement getSubmitButton(){
        return driver.findElement(By.id("submit"));
    }

    public List<WebElement> getTableCells(){
        return driver.findElements(By.className("rt-td"));
    }

    public WebElement getTableCell(String text){
        for (int i = 0; i< getTableCells().size(); i++) {
            if (getTableCells().get(i).getText().equals(text)) {
                return getTableCells().get(i);
            }
        }
        return null;
    }
    public WebElement getSearchField(){
        return driver.findElement(By.id("searchBox"));
    }

    public WebElement getDeleteButton() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[7]/div/span[2]"));
    }

    public WebElement getEditButton() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[7]/div/span[1]"));
    }

    public WebElement getPreviousButton() {
        WebElement parent = driver.findElement(By.className("-previous"));
        return parent.findElement(By.className("-btn"));
    }

    public WebElement getNextButton() {
        WebElement parent = driver.findElement(By.className("-next"));
        return parent.findElement(By.className("-btn"));
    }


    //---------------

    public void clickOnAddButton(){
        getAddButton().click();
    }
    public void inputFirstNameField(String firstName){
        getFirstNameField().clear();
        getFirstNameField().sendKeys(firstName);
    }
    public void inputLastNameField(String lastName){
        getLastNameField().clear();
        getLastNameField().sendKeys(lastName);
    }
    public void inputEmailField(String emailField){
        getEmailField().clear();
        getEmailField().sendKeys(emailField);
    }
    public void inputAgeField(String ageField){
        getAgeField().clear();
        getAgeField().sendKeys(ageField);
    }
    public void inputSalaryField(String salaryField){
        getSalaryField().clear();
        getSalaryField().sendKeys(salaryField);
    }
    public void inputDepartmentField(String departmentField){
        getDepartmentField().clear();
        getDepartmentField().sendKeys(departmentField);
    }
    public void clickOnSubmitButton(){
        getSubmitButton().click();
    }
    public void insertSearchField(String search){
        getSearchField().clear();
        getSearchField().sendKeys(search);
    }
    public void clickOnDeleteButton() {
        getDeleteButton().click();
    }
    public void clickOnEditButton() {
        getEditButton().click();
    }
    public void clickOnPreviousButton() {
        getPreviousButton().click();
    }
    public void clickOnNextButton() {
        getNextButton().click();
    }
}