package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.ifr_pages.Login;
import pages.ifr_pages.SingUp;

import java.util.Random;


public class Base {

    private WebDriver driver;
    protected HomePage homePage;

    protected String email;

    @BeforeClass(alwaysRun = true)
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String URL ="https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().logs();

        homePage = new HomePage(driver);
        this.email = emailRandomUser();
        createAccount(this.email);

    }

    public void createAccount(String email){
        this.homePage.clickMenu();
        String name = "Paco Jesus";
        String lastName = "Guio Gonzalez";
        String passWord = "selenium1";
        Login loginIframe = this.homePage.clickLoginB();
        SingUp singUp = loginIframe.clickSingUp();
        singUp.Name(name);
        singUp.LastName(lastName);
        singUp.Email(email);
        singUp.Password(passWord);

        this.homePage = singUp.clickSingUp();
    }


    @AfterClass(alwaysRun = true)
    public void exit(){
        this.driver.quit();
    }

    public static String emailRandomUser(){

        Random randomGenerator = new Random();
        String email ="";
        int randomInt = randomGenerator.nextInt(1000);
        email = "username"+ randomInt +"@gmail.com";
        return email;

    }

}
