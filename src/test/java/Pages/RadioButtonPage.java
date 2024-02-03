package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtonPage {
    WebDriver driver;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getYesButton() {
        return driver.findElement(By.id("yesRadio"));
    }

    public WebElement getImpressiveButton() {
        return driver.findElement(By.id("impressiveRadio"));
    }
    public WebElement getNoButton() {
        return driver.findElement(By.id("noRadio"));
    }

    public List<WebElement> getResults(){
        return driver.findElements(By.className("text-success"));
    }

    //metoda kojom se pristupa listi rezultata
    public WebElement getResult(String label){
        for (int i = 0; i< getResults().size(); i++) {
            if (getResults().get(i).getText().equals(label)) {
                return getResults().get(i);
            }
        }
        return null;
    }

    //-------------------------

    public void clickOnYesButton(){
        getYesButton().click();
    }
    public void clickOnImpressiveButton(){
        getImpressiveButton().click();
    }
    public void clickOnNoButton(){
        getNoButton().click();
    }
}
