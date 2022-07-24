package lib.ui.mobileWeb;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "css: #mw-content-text > ul > li > a.title > h3/*[contains(text(),'{TITLE}')]";
        REMOVE_FROM_SAVED_BUTTON = "css: li.page-summary.with-watchstar > a.title /*h3[contains(text(),'{TITLE}')]";
        ARTICLE_WITH_STAR_IN_WATCHLIST = "css: div>ul>li.page-summary.with-watchstar";
    }

    public MWMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
