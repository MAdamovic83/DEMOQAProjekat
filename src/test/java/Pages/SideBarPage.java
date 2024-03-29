package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SideBarPage {
    WebDriver driver;
    WebElement sideBarButton;

    public SideBarPage(WebDriver driver){
        this.driver = driver;

    }
    //metoda za pristup listi elemenata
    public List<WebElement> getSideBarButton(){
        return driver.findElements(By.className("text"));
    }

    // metoda za dobijanje elementa sa odredjenim nazivom
    public WebElement getSideBarButtonByText(String text){
        for (int i = 0; i< getSideBarButton().size(); i++) {
            if (getSideBarButton().get(i).getText().equals(text)) {
                return getSideBarButton().get(i);
            }
        }
        return null;
    }


    //------------------
    // metoda za klik na element sa nazivom koji joj je prosledjen
    public void clickOnSideBarButton(String buttonName){
        for (int i = 0; i< getSideBarButton().size(); i++) {
            if (getSideBarButton().get(i).getText().equals(buttonName)) {
                getSideBarButton().get(i).click();
                break;

            }
        }
    }
}