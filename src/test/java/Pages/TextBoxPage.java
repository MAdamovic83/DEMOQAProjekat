package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage {
    WebDriver driver;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFullNameField() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getEmailField() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getCurrentAddressField() {
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getPermanentAddressField() {
        return driver.findElement(By.id("permanentAddress"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    //----------------

    public void inputFullNameField(String fullName){
        getFullNameField().clear();
        getFullNameField().sendKeys(fullName);
    }

    public void inputEmailField(String emailField){
        getEmailField().clear();
        getEmailField().sendKeys(emailField);
    }
    public void inputCurrentAddressField(String currentAddresField){
        getCurrentAddressField().clear();
        getCurrentAddressField().sendKeys(currentAddresField);
    }
    public void inputPermanentAddressField(String permanentAddressField){
        getPermanentAddressField().clear();
        getPermanentAddressField().sendKeys(permanentAddressField);
    }
    public void clickOnSubmitButton(){
        getSubmitButton().click();
    }
    public WebElement getResultField(String id){
        WebElement parent = driver.findElement(By.id("output"));
        return parent.findElement(By.id(id));
    }
}
