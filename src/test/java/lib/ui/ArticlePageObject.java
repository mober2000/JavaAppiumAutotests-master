package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
            TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            UPDATE_SAVED_READING_LIST_ITEM;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return waitForElementPresent((TITLE), "Can't find article title on page", 15);
    }

    public WebElement waitForSaveButton() {
        return waitForElementPresent((OPTIONS_ADD_TO_MY_LIST_BUTTON), "Can't find save button on page", 15);
    }

    public String getArticleTitle() {
        WebElement titleElement = waitForTitleElement();
        if (Platform.getInstance().isAndroid()){
            return titleElement.getAttribute("text");
        }else if (Platform.getInstance().isIOS()) {
            return titleElement.getAttribute("name");
        }else{
            return titleElement.getText();
        }
    }
    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()){
            swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Can't find the end of article",
                    40
            );
        }else if (Platform.getInstance().isIOS()) {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
                    "Can't find the end of article",
                    40);
        }else{
            this.scrollWebPageTillElementNotVisible(
                    FOOTER_ELEMENT,
                    "Can't find the end of article",
                    40);
        }
    }
    public void addArticleToMyList(String nameOfFolder) {
        waitForElementAndClick(
                OPTIONS_BUTTON,
                "Can't find button to open list of options",
                15);

        waitForElementPresent(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Can't find option 'Add to reading list'",
                20);

        waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Can't find option 'Add to reading list'",
                15);

        waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Can't find button 'GOT IT'",
                15);

        waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Can't find text input",
                20);

        waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                nameOfFolder,
                "Can't put text into input",
                1);

        waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Can't find button 'OK' to confirm text input",
                5);

    }

    public void closeArticle() {
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Can't find X button to close article",
                    5);
        }else{
            System.out.println("Method closeArticle() does nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }

    /**
     * Method for IOS
     */
    public void addArticlesToMySaved(){
//        if (Platform.getInstance().isMW()){
//            this.removeArticleFromSavedIfItAdded();
//        }
        waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Can't find option to add article to my reading list",
                10);
    }

    public void removeArticleFromSavedIfItAdded(){
        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(
                    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Can't find and click on button to remove article from saved",
                    1);
            this.waitForElementPresent(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Can't find button to add an article to saved list after removing it from saved list");
        }
    }

    public void savedArticleToExistingReadingList() {
        waitForElementPresent(
                OPTIONS_BUTTON,
                "Can't find option 'Add to reading list'",
                20);

        waitForElementAndClick(
                OPTIONS_BUTTON,
                "Can't find button to open list of options",
                15);

        waitForElementPresent(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Can't find option 'Add to reading list'",
                20);

        waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Can't find option 'Add to reading list'",
                15);

        waitForElementAndClick(
                UPDATE_SAVED_READING_LIST_ITEM,
                "Can't find option 'Add to reading list'",
                15);
    }


}
