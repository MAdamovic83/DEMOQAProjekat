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

    public List<WebElement> getCheckBoxes(){
        return driver.findElements(By.className("rct-title"));
    }

    public WebElement getCheckBox(String label){
        for (int i = 0; i< getCheckBoxes().size(); i++) {
            if (getCheckBoxes().get(i).getText().equals(label)) {
                return getCheckBoxes().get(i);
            }
        }
        return null;
    }

    public List<WebElement> getResults(){
        return driver.findElements(By.className("text-success"));
    }

    public WebElement getResult(String label){
        for (int i = 0; i< getResults().size(); i++) {
            if (getResults().get(i).getText().equals(label)) {
                return getResults().get(i);
            }
        }
        return null;
    }

    //------------------



//    public WebElement getToggleButton() {
//        return driver.findElement(By.cssSelector(".rct-collapse.rct-collapse-btn"));
//    }
//    public List<WebElement> getToggleListButtons() {
//        return driver.findElements(By.cssSelector(".rct-collapse.rct-collapse-btn"));
//    }

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

    public void clickOnCheckBox(String label){
        for (int i = 0; i< getCheckBoxes().size(); i++) {
            if (getCheckBoxes().get(i).getText().equals(label)) {
                getCheckBoxes().get(i).click();
                break;

            }
        }
    }

//    public void clickOnToggleListButtons(){
//        for(int i = 0;i < getToggleListButtons().size();i++){
//            getToggleListButtons().get(i).click();
//            break;
//        }
//    }
    public void clickPageText(){
        getPageText().click();
    }
}
