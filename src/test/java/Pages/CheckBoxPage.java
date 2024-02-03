package Pages;

import Base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CheckBoxPage{

    WebDriver driver;



    public CheckBoxPage(WebDriver driver) {
            this.driver = driver;
    }

    public WebElement getHomeBoxButton() {
        return driver.findElement(By.className("rct-title"));
    }

    public WebElement getExpandAllButton() {
        return driver.findElement(By.cssSelector(".rct-option.rct-option-expand-all"));
    }

    public WebElement getCollapseAllButton() {
        return driver.findElement(By.cssSelector(".rct-icon.rct-icon-collapse-all"));
    }

    //metoda za prisup listi svih toggle elemenata
    public List<WebElement> getCheckBoxes(){
        return driver.findElements(By.className("rct-title"));
    }

    //metoda za pristup jednom konkretnom check boxu sa nazivom koji prosledjujem
    public WebElement getCheckBox(String label){
        for (int i = 0; i< getCheckBoxes().size(); i++) {
            if (getCheckBoxes().get(i).getText().equals(label)) {
                return getCheckBoxes().get(i);
            }
        }
        return null;
    }

    //metoda kojom se pristupa listi rezultata
    public List<WebElement> getResults(){
        return driver.findElements(By.className("text-success"));
    }

    // metoda za pristup jednom rezultatu
    public WebElement getResult(String label){
        for (int i = 0; i< getResults().size(); i++) {
            if (getResults().get(i).getText().equals(label)) {
                return getResults().get(i);
            }
        }
        return null;
    }

    public WebElement getPageText() {
        return driver.findElement(By.id("result"));
    }


    //--------------


    public void clickOnHomeBoxButton(){
        getHomeBoxButton().click();
    }
    public void clickOnExpandAllButton(){
        getExpandAllButton().click();
    }
    public void clickOnCollapseAllButton(){
        getCollapseAllButton().click();
    }

    // metoda za klik na element
    public void clickOnCheckBox(String label){
        for (int i = 0; i< getCheckBoxes().size(); i++) {
            if (getCheckBoxes().get(i).getText().equals(label)) {
                getCheckBoxes().get(i).click();
                break;

            }
        }
    }

    public void clickPageText(){
        getPageText().click();
    }
}
