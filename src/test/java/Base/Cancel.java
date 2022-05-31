package Base;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ifr_pages.Account;

public class Cancel extends Base {

    @Test
    public void cancelAccount(){
        homePage.clickMenu();


        Account profile = homePage.clickAccount();
        profile.clickDelete();

        profile.clickDeleteAcc();
        Assert.assertEquals(profile.getTxtDelAccount(), "Your account has been deleted.");
    }
}
