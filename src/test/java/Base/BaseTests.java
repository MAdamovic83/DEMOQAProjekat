package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import java.io.IOException;

// Tokom testiranja koristim IntelliJ Idea u kome kreiram Maven projekat,
// jer mi je jednostavnije da na taj nacin ubacujem biblioteke preko pom fajla.
// Prilikom testiranja koristim POM jer mi pregledniji,lakse mi je da pratim rad jer se
// elementi definisu na samo jednom mestu.
// Koristimn JUnit da ne bih  ponavljala odredjene blokove koda i koristim
// Before, After i Test anotacije
//    //Mogu i da koristim TestNG ali sam izabrao JUnit
// Da bih izbegla hardkodiranje koristim DataDrivenTesting, da lih lakse mogla da
// menjam / dodajem testne podatke ili uporedjujem dobijeni rezultat sa ocekivanim rezultatom
// Testiranje vrsim na Chrome browseru jer prema podacima
// (https://gs.statcounter.com/browser-market-share/desktop/worldwide)67% korisnika na svetu
// koristi Chrome preko Desktopa. Ukoliko bude potrebe da se testiranje vrsi preko drugih browsera
// samo treba zameniti driver i ubaciti u directory(gecko driver za Firefox).

// ovom ispod delu deklarisem driver, webdriverwait kao i sve stranice koje cu da testiram
public class BaseTests {
    public WebDriver driver;
    public HomePage homePage;
    public SideBarPage sideBarPage;
    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPage radioButtonPage;
    public WebTablesPage webTablesPage;
    public ExcelReader excelReader;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        homePage= new HomePage(driver);
        sideBarPage = new SideBarPage(driver);
        textBoxPage = new TextBoxPage(driver);
        checkBoxPage = new CheckBoxPage(driver);
        radioButtonPage = new RadioButtonPage(driver);
        webTablesPage = new WebTablesPage(driver);

        excelReader = new ExcelReader("C:\\Users\\milic\\Desktop\\WebTables DemoQA.xlsx");

    }

    //Ovaj blok koda mi sluzi da mogu da skrolam do elementa
    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    //Ovaj blok koristim da proverim da li je element prikazan i, ako je obrisan da se
    // ne desi greska koja ce prekinuti izvrsavanje testa
    public boolean elementIsDisplayed(WebElement element){
        boolean isDisplayed=false;
        try{
            isDisplayed = element.isDisplayed();

        }catch(Exception e){
            System.out.println(e);
        }
        return isDisplayed;
    }
}
