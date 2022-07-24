package lib.ui.factories;

import lib.Platform;
import lib.ui.NavigationUi;
import lib.ui.android.AndroidNavigationUi;
import lib.ui.ios.IOSNavigationUi;
import lib.ui.mobileWeb.MWNavigationUi;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUiFactory {
    public static NavigationUi get(RemoteWebDriver driver){
        if (Platform.getInstance().isAndroid()){
            return new AndroidNavigationUi(driver);
        }else if (Platform.getInstance().isIOS()){
            return new IOSNavigationUi(driver);
        }else{
            return new MWNavigationUi(driver);
        }
    }
}
