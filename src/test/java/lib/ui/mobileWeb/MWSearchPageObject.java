package lib.ui.mobileWeb;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:div>button.cancel";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "css:body > div.mw-overlays-container > div > div.overlay-content > div > div.results > div > ul > li:nth-child(3) > a > div.wikidata-description/*[contains(text(),'{SUBSTRING}')]";
        SEARCH_RESULT_BY_TITLE = "css: li>a.title ";
        SEARCH_RESULT_ELEMENT = "css:div.results>div.results-list-container>ul.page-list.thumbs.actionable>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.mw-search-nonefound";

    }

    public MWSearchPageObject(RemoteWebDriver driver){
        super(driver);
    }
}
