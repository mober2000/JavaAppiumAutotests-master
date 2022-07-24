package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject {
    private static final String
    LOGIN_BUTTON = "css: body>div.drawer-container.view-border-box>div.drawer.drawer-container__drawer.position-fixed.visible>a",
    LOGIN_INPUT = "css: #wpName1",
    PASSWORD_INPUT = "css: #wpPassword1",
    SUBMIT_BUTTON = "css: #wpLoginAttempt";

    public AuthorizationPageObject(RemoteWebDriver driver){
        super(driver);
    }

    public void clickAuthButton(){
        this.waitForElementPresent(LOGIN_BUTTON,"Can't find auth button",5);
        this.waitForElementAndClick(LOGIN_BUTTON,"Can't find and click auth button",5);
    }

    public void enterLoginData(String login, String password){
        this.waitForElementAndSendKeys(LOGIN_INPUT, login,"Can't find and put a login to the login input",5);
        this.waitForElementAndSendKeys(PASSWORD_INPUT, password,"Can't find and put a password to the password input",5);
    }

    public void submitForm(){
        this.waitForElementAndClick(SUBMIT_BUTTON,"Can't find and click submit auth button",5);
    }
}
