package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUi extends MainPageObject {
    protected static String
            MY_WATCHLIST_LINK,
            OPEN_NAVIGATION;

    public NavigationUi(RemoteWebDriver driver) {
        super(driver);
    }

    public void openNavigation() {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION,
                    "Can't find and click to open navigation button",
                    5);
        } else {
            System.out.println("Method openNavigation() does nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }

    public void clickMyLists() {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(MY_WATCHLIST_LINK,
                    "Cannot find navigation button to My list",
                    10);

//            this.waitForElementAndClick(
//                    MY_WATCHLIST_LINK,
//                    "Cannot find navigation button to My list",
//                    5
//            );
        }
    }
}

