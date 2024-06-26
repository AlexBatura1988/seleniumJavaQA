package org.example.testCases;

import org.example.baseTest.BaseTest;
import org.example.pageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {



    @Test(priority = 2)
    public void loginTestFailed() {
        LoginPage lp = new LoginPage(driver);
        lp.setUserEmail(rb.getString("email_1"));
        lp.setUserPassword(rb.getString("password_1"));
        lp.clickLogin();
        Assert.assertEquals("Incorrect email or password.", lp.getErrorMsg());

    }

    @Test(priority = 1)
    public void EmptyPassError() {
        LoginPage lp = new LoginPage(driver);
        lp.setUserEmail(rb.getString("email_1"));
        lp.setUserPassword("");
        lp.clickLogin();
        Assert.assertEquals("*Password is required", lp.emptyPassError());
    }

    @Test(priority = 3)
    public void loginSuccess() {
        LoginPage lp = new LoginPage(driver);
        lp.setUserEmail(rb.getString("email"));
        lp.setUserPassword(rb.getString("password"));
        lp.clickLogin();
        String loginMsgSuccess = "Login Successfully";
        Assert.assertEquals(lp.login(), loginMsgSuccess);

    }
}
