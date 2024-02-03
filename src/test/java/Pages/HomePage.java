package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
   WebDriver driver;
   WebElement cards;

   public HomePage (WebDriver driver){
       this.driver = driver;

   }
   //metoda za pristup listi svih elemenata na pocetnoj stranici
   public List<WebElement> getCards(){
       return driver.findElements(By.cssSelector(".card.mt-4.top-card"));

    }

   //---------------

    // u delu ispod su for petlje za odabir svakog od elemenata
   public void clickOnElements(){
       for(int i = 0; i<getCards().size();i++){
           if(getCards().get(i).getText().equals("Elements")){
               getCards().get(i).click();
               break;
           }
       }
   }
    public void clickOnForms(){
        for(int i = 0; i<getCards().size();i++){
            if(getCards().get(i).getText().equals("Forms")){
                getCards().get(i).click();
                break;
            }
        }
    }
    public void clickOnAlerts(){
        for(int i = 0; i<getCards().size();i++){
            if(getCards().get(i).getText().equals("Alerts, Frame & Windows")){
                getCards().get(i).click();
                break;
            }
        }
    }
    public void clickOnWidgets(){
        for(int i = 0; i<getCards().size();i++){
            if(getCards().get(i).getText().equals("Widgets")){
                getCards().get(i).click();
                break;
            }
        }
    }
    public void clickOnInteractions(){
        for(int i = 0; i<getCards().size();i++){
            if(getCards().get(i).getText().equals("Interactions")){
                getCards().get(i).click();
                break;
            }
        }
    }
    public void clickOnBookStoreApplication(){
        for(int i = 0; i<getCards().size();i++){
            if(getCards().get(i).getText().equals("Book Store Application")){
                getCards().get(i).click();
                break;
            }
        }
    }

}
