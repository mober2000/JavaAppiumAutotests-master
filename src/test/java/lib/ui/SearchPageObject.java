package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject {

    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_BY_TITLE,
            SEARCH_RESULT_ELEMENT,
            SEARCH_RESULT_ELEMENT_BY_ID,
            SEARCH_EMPTY_RESULT_ELEMENT,
            SEARCH_RESULT_BY_TITLE_SUBSTRING_TPL,
            SEARCH_RESULT_BY_DESCRIPTION_SUBSTRING_TPL;


    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

     /**
     * TEMPLATES METHODS
     */
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getSearchResultByTitle(String title){
        if(Platform.getInstance().isMW()){
            return SEARCH_RESULT_BY_TITLE.replace("{ARTICLE_TITLE}",title);
        }else
        return SEARCH_RESULT_BY_TITLE_SUBSTRING_TPL.replace("{SEARCH_TITLE}", title);
    }

    private static String getSearchResultByDescription(String description){
        return SEARCH_RESULT_BY_DESCRIPTION_SUBSTRING_TPL.replace("{SEARCH_DESCRIPTION}", description);
    }

    public void waitForElementByTitleAndDescription(String title, String description){
        String searchResultTitleById = getSearchResultByTitle(title);
        String searchResultDescriptionById = getSearchResultByDescription(description);
        this.waitForElementPresent((searchResultTitleById),"Can't find article's title"+ " " + title,15);
        this.waitForElementPresent((searchResultDescriptionById),"Can't find article's description"+ " " + description,15);
    }

    public void initSearchInput() {
        this.waitForElementPresent((SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element", 5);
        this.waitForElementAndClick((SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys((SEARCH_INPUT), search_line, "Can't find and type into search input", 5);
    }

    public void waitForSearchResult(String substring) {
        String searchResultXpath = getResultSearchElement(substring);
        this.waitForElementPresent((searchResultXpath), "Can't find search result with substring " + substring);
    }

    public void clickByArticleWithSubstring(String substring) {
        String searchResultXpath = getResultSearchElement(substring);
        this.waitForElementAndClick((searchResultXpath), "Can't find and click search result with substring " + substring, 10);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent((SEARCH_CANCEL_BUTTON), "Can't find search cancel button", 5);
    }

    public void clickCanselSearch() {
        this.waitForElementAndClick((SEARCH_CANCEL_BUTTON), "Can't find and click search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent((SEARCH_CANCEL_BUTTON), "Search cancel button is still present", 5);
    }

    public int getAmountOfFoundArticles() {
        if(Platform.getInstance().isMW()){
            this.waitForElementPresent(
                    SEARCH_RESULT_BY_TITLE,
                    "Can't find anything by request",
                    30);
            return this.getAmountOfElements((SEARCH_RESULT_BY_TITLE));
        }else {
            this.waitForElementPresent(
                    SEARCH_RESULT_ELEMENT_BY_ID,
                    "Can't find anything by request",
                    30);
            return this.getAmountOfElements((SEARCH_RESULT_ELEMENT_BY_ID));
        }
    }

    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT_BY_ID,
                "Can't find empty result element",
                15);
    }

    public void assertThereIsNoResultOfSearch() {
        this.assertElementNotPresent(
                SEARCH_RESULT_ELEMENT,
                "We can't find any results",
                15);
    }
}
