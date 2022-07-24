package lib.ui.mobileWeb;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css: div.pre-content.heading-holder>div.page-heading>h1";
        FOOTER_ELEMENT = "css: #mw-mf-page-center > footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON ="css: #ca-watch";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css: #ca-watch/*[contains(@text,'menu.unwatch')]";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
