package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject {
    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE_TPL,
            REMOVE_FROM_SAVED_BUTTON,
            ARTICLE_WITH_STAR_IN_WATCHLIST;

    private static String getFolderXpathByName(String nameOfFolder) {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", nameOfFolder);
    }

    private static String getSavedArticleXpathByTitle(String articleTitle) {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", articleTitle);
    }

    private static String getRemoveButtonByTitle(String article_title) {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }


    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void openFolderByName(String nameOfFolder) {
        this.waitForFolderAppear(nameOfFolder);
        String folderNameXpath = getFolderXpathByName(nameOfFolder);
        waitForElementAndClick(
                folderNameXpath,
                "Can't find folder by name" + nameOfFolder,
                15);
    }

    public void waitForFolderAppear(String nameOfFolder) {
        String folderNameXpath = getFolderXpathByName(nameOfFolder);
        waitForElementPresent(
                folderNameXpath,
                "Can't find the " + nameOfFolder,
                15);
    }

    public void swipeByArticleToDelete(String articleTitle) {
        this.waitForArticleToAppearByTitle(articleTitle);
        String articleXpath = getFolderXpathByName(articleTitle);

        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            this.swipeElementToLeft(
                    articleXpath,
                    "Can't find saved article");
        }else{
            String removeLocator = getRemoveButtonByTitle(articleTitle);
            this.waitForElementAndClick(removeLocator,
                    "Can't click button to remove article from saved",
                    10);
        }

        if(Platform.getInstance().isIOS()){
            this.clickElementToTheRightUpperCorner(articleXpath,"Can't find saved article");
        }
        if (Platform.getInstance().isMW()){
            driver.navigate().refresh();
        }

        this.waitForArticleToDisappearByTitle(articleTitle);
    }

    public void removeArticleFromSaved(String articleTitle){
        String removeLocator = getRemoveButtonByTitle(articleTitle);
        this.waitForElementAndClick(removeLocator,
                "Can't click button to remove article from saved",
                10);
        driver.navigate().refresh();
        this.waitForArticleToDisappearByTitle(articleTitle);
    }

    public void waitForArticleToDisappearByTitle(String articleTitle) {
        String articleXpath;
        if (Platform.getInstance().isMW()) {
            articleXpath = getSavedArticleXpathByTitle(articleTitle);
        } else {
            articleXpath = getFolderXpathByName(articleTitle);
        }

        this.waitForElementNotPresent(
                articleXpath,
                "Saved article still present with title" + articleTitle,
                15);
    }

    public void waitForListPresent() {
        this.waitForElementPresent(
                ARTICLE_WITH_STAR_IN_WATCHLIST,
                "Can't find anything by request",
                30);
    }

    public void waitForArticleToAppearByTitle(String articleTitle) {
        String articleXpath;
        if (Platform.getInstance().isMW()){
            articleXpath = getSavedArticleXpathByTitle(articleTitle);
        } else {
            articleXpath = getFolderXpathByName(articleTitle);
        }

        this.waitForElementPresent(
                articleXpath,
                "Can't find saved article by title" + articleTitle,
                15);
    }
    public int getAmountOfSavedArticles() {
        this.waitForElementPresent(
                ARTICLE_WITH_STAR_IN_WATCHLIST,
                "Can't find anything by request",
                30);
        return this.getAmountOfElements((ARTICLE_WITH_STAR_IN_WATCHLIST));
    }

}
