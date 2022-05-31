package pages.ifr_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Account {

    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    private By deleteAccount = By.id("AccountDeleteLink");
    private By yesDeleteAccount = By.cssSelector("#TextBlock ~ #BtnSubmit");
    private By accountDelete = By.cssSelector(".delete-profile-success #Title");

    public Account(WebDriver driver) {
        this.driver = driver;
        driver.switchTo().frame("oneid-iframe");
        this.wait = new WebDriverWait(driver,20);
        actions = new Actions(driver);
    }


    public String getTxtDelAccount(){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.accountDelete));
        WebElement AccountDeleteText = this.driver.findElement(this.accountDelete);
        return AccountDeleteText.getText();
    }


    public void clickDeleteAcc(){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.yesDeleteAccount));
        WebElement yesDeleteAccountButton = this.driver.findElement(this.yesDeleteAccount);
        yesDeleteAccountButton.click();
    }

    public void clickDelete(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.deleteAccount));
        WebElement deleteAccountButton = this.driver.findElement(this.deleteAccount);
        this.actions.moveToElement(deleteAccountButton).click().build().perform();
        deleteAccountButton.click();
    }



}
