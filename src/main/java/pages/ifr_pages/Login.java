package pages.ifr_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

public class Login {

    private WebDriver driver;

    private WebDriverWait wait;

    private By singUp = By.cssSelector(".login #BtnCreateAccount");
    private By emailInput = By.cssSelector(".input-wrapper #InputLoginValue");
    private By passwordInput = By.cssSelector(".input-wrapper #InputPassword");
    private By loginButton = By.cssSelector("#BtnSet-wrapper #BtnSubmit");

    public Login(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,20);
        driver.switchTo().frame("oneid-iframe");
    }

    public void loginEmail(String email){
        this.wait.until(ExpectedConditions.presenceOfElementLocated(this.emailInput));
        WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        inputEmail.sendKeys(email);
    }

    public void loginPassword(String password){
        WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        inputEmail.sendKeys(password);
    }

    public HomePage clickLogIn(){
        WebElement logInButton = driver.findElement(loginButton);
        this.wait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();

        this.driver.switchTo().defaultContent();
        this.wait.until(ExpectedConditions.invisibilityOf(this.driver.findElement(By.cssSelector("#oneid-wrapper #oneid-iframe"))));

        return new HomePage(driver);
    }

    public SingUp clickSingUp(){
        WebElement singUpButton = driver.findElement(singUp);
        this.wait.until(ExpectedConditions.elementToBeClickable(singUpButton));
        singUpButton.click();
        return new SingUp(driver);
    }




}
