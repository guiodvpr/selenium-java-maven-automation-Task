package pages.ifr_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

public class SingUp {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    private By firstName = By.id("InputFirstName");
    private By lastName = By.id("InputLastName");
    private By email = By.cssSelector(".input-wrapper #InputEmail");
    private By password = By.cssSelector(".input-wrapper #password-new");
    private By singUp = By.cssSelector(".registration #BtnSubmit");

    public SingUp(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver,30);
    }

    public void Name(String firstName){
        this.wait.until(ExpectedConditions.presenceOfElementLocated(this.firstName));
        WebElement inputFirstName = wait.until(ExpectedConditions.visibilityOf(driver.findElement(this.firstName)));
        inputFirstName.sendKeys(firstName);
    }

    public void LastName(String lastName){
        WebElement inputLastName = driver.findElement(this.lastName);
        inputLastName.sendKeys(lastName);
    }

    public void Email(String email){
        WebElement inputEmail = driver.findElement(this.email);
        inputEmail.sendKeys(email);
    }

    public void Password(String password){
        WebElement inputPassword = driver.findElement(this.password);
        inputPassword.sendKeys(password);
    }

    public HomePage clickSingUp(){
        WebElement singUpButton = this.driver.findElement(this.singUp);
        this.wait.until(ExpectedConditions.elementToBeClickable(singUpButton));
        this.actions.moveToElement(singUpButton).click().build().perform();
        singUpButton.click();

        this.driver.switchTo().defaultContent();
        this.wait.until(ExpectedConditions.invisibilityOf(this.driver.findElement(By.cssSelector("#oneid-wrapper #oneid-iframe"))));

        return new HomePage(driver);
    }

}
