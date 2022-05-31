package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ifr_pages.Login;
import pages.ifr_pages.Account;

public class HomePage  {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    private By userIcon = By.id("global-user-trigger");
    private By logIn = By.cssSelector(".user a[tref*='/members/v3_1/login']");
    private By logOut = By.cssSelector(".user .small");
    private By profile = By.cssSelector(".user a[tref*='/members/v3_1/modifyAccount']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,20);
        actions = new Actions(driver);
    }

    public String getLoginTxt(){
        this.wait.until(ExpectedConditions.presenceOfElementLocated(logIn));
        WebElement loginButton = this.wait.until(ExpectedConditions.visibilityOfElementLocated(logIn));
        return loginButton.getText();
    }

    public String getLogoutTxt(){
        this.wait.until(ExpectedConditions.presenceOfElementLocated(logOut));
        WebElement logoutButton = this.wait.until(ExpectedConditions.visibilityOfElementLocated(logOut));
        return logoutButton.getText();
    }


    public Login clickLoginB(){
        this.wait.until(ExpectedConditions.presenceOfElementLocated(logIn));
        WebElement loginButton = this.wait.until(ExpectedConditions.visibilityOfElementLocated(logIn));
        loginButton.click();
        return new Login(driver);
    }



    public HomePage clickLogOut(){
        WebElement logOutButton = driver.findElement(logOut);
        logOutButton.click();
        return new HomePage(driver);
    }

    public void clickMenu(){
        this.wait.until(ExpectedConditions.presenceOfElementLocated(userIcon));
        this.wait.until(ExpectedConditions.elementToBeClickable(userIcon));
        WebElement userMenuButton = driver.findElement(userIcon);
        this.actions.moveToElement(userMenuButton).perform();
    }


    public void mainPageRefresh(){
        this.wait.until(ExpectedConditions.stalenessOf(driver.findElement(userIcon)));
    }

    public Account clickAccount(){
        this.wait.until(ExpectedConditions.presenceOfElementLocated(profile));
        WebElement profileButton = this.wait.until(ExpectedConditions.visibilityOfElementLocated(profile));
        profileButton.click();
        return new Account(driver);
    }


}
