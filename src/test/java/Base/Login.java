package Base;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login extends Base {

    @DataProvider(name = "loginData")
    public Object[][] infoUser(){
        int x = 1;
        int y = 2;
        Object[][] infoAccount = new Object[x][y];
        String passWord = "selenium1";
        infoAccount[x-1][x-1] = emailRandomUser();
        infoAccount[0][1] = passWord;
        return infoAccount;
    }

    @BeforeMethod
    public void logOut(){

        homePage.clickMenu();
        homePage.clickLogOut();
    }

    @Test(dataProvider = "infoUser")
    public void loginTest(String email, String password){
        homePage.mainPageRefresh();
        homePage.clickMenu();

        pages.ifr_pages.Login login = homePage.clickLoginB();
        login.loginEmail(email);
        login.loginPassword(password);
        homePage = login.clickLogIn();

        homePage.clickMenu();
        Assert.assertEquals(homePage.getLogoutTxt(), "Log Out");
        homePage.clickLogOut();
    }


}
