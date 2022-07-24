package lib.ui.mobileWeb;

import lib.ui.NavigationUi;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUi extends NavigationUi {
    static{
        MY_WATCHLIST_LINK = "css: #p-personal > li:nth-child(2) > a > span:nth-child(2)";
        OPEN_NAVIGATION = "css: #mw-mf-main-menu-button";
    }

    public MWNavigationUi(RemoteWebDriver driver){
        super(driver);
    }

}
