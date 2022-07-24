package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject {

    private static final String
    STEP_LEARN_MORE_LINK = "id:Learn more about Wikipedia",
    STEP_NEW_WAY_TO_EXPLORE_TEXT = "id:New ways to explore",
    STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "id:Add or edit preferred languages",
    STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "id:Learn more about data collected",
    BUTTON_NEXT = "id:Next",
    BUTTON_SKIP = "id:Skip",
    BUTTON_GET_STARTED = "id:Get started";

    public WelcomePageObject (RemoteWebDriver driver){
        super(driver);
    }

    public void waitForLearnMoreLink(){
        this.waitForElementPresent(STEP_LEARN_MORE_LINK,"Can't find 'Learn more about Wikipedia'", 10);
    }

    public void waitForNewWayToExploreText(){
        this.waitForElementPresent(STEP_NEW_WAY_TO_EXPLORE_TEXT,"Can't find 'New ways to explore'", 10);
    }

    public void waitForAddOrEditPreferredLangLink(){
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK,"Can't find 'Add or edit preferred languages'", 10);
    }

    public void waitForLearnMoreAboutDataCollectedLink(){
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK,"Can't find 'Learn more about data collected'", 10);
    }

    public void clickNextButton(){
        this.waitForElementAndClick(BUTTON_NEXT,"Can't find and click button 'Next'", 10);
    }

    public void clickGetStartedButton(){
        this.waitForElementAndClick(BUTTON_GET_STARTED,"Can't find and click button 'Get started'", 10);
    }

    public void clickSkip(){
        this.waitForElementAndClick(BUTTON_SKIP,"Can't find and click 'Skip' button ", 10);
    }
}
