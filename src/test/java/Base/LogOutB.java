package Base;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutB extends Base {

    @Test
    public void logOut(){

        homePage.clickMenu();
        homePage = homePage.clickLogOut();

        homePage.mainPageRefresh();
        homePage.clickMenu();
        Assert.assertEquals(homePage.getLoginTxt(), "Log In");
    }
}
