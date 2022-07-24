package lib.ui.ios;

import lib.ui.NavigationUi;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSNavigationUi extends NavigationUi {
    static{
        MY_WATCHLIST_LINK = "id:Saved";
    }

    public IOSNavigationUi(RemoteWebDriver driver){
        super(driver);
    }
}
