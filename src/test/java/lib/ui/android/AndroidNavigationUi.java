package lib.ui.android;

import lib.ui.NavigationUi;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUi extends NavigationUi {

    static{
        MY_WATCHLIST_LINK = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
    }

    public AndroidNavigationUi(RemoteWebDriver driver){
        super(driver);
    }
}
