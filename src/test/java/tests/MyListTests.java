package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUiFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class MyListTests extends CoreTestCase {

    private static final String nameOfFolder = "Learning programming";
    private static final String login = "Vikki.Ku",
                                password = "Uni&Clo_1";;


@Test
    public void testSaveArticleToMyList() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();
        String articleTitle = articlePageObject.getArticleTitle();

        articlePageObject.addArticlesToMySaved();

        if (Platform.getInstance().isAndroid()){
            articlePageObject.addArticleToMyList(nameOfFolder);
        } else if (Platform.getInstance().isIOS()){
            articlePageObject.addArticlesToMySaved();
        }else if (Platform.getInstance().isMW()) {
            AuthorizationPageObject auth = new AuthorizationPageObject(driver);
            auth.clickAuthButton();
            auth.enterLoginData(login, password);
            auth.submitForm();
            articlePageObject.waitForTitleElement();

            assertEquals("We are not on the same page after login",
                    articleTitle,
                    articlePageObject.getArticleTitle());

            articlePageObject.addArticlesToMySaved();
        }


        articlePageObject.closeArticle();

        NavigationUi navigationUi = NavigationUiFactory.get(driver);
        navigationUi.openNavigation();
        navigationUi.clickMyLists();

        MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()){
            myListsPageObject.openFolderByName(nameOfFolder);
        }
        myListsPageObject.swipeByArticleToDelete(articleTitle);
    }

    @Test
    public void testSaveArticlesToMyListAndDeleteOne() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Horse");
        searchPageObject.clickByArticleWithSubstring("Horse");

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();
        String articleTitle = articlePageObject.getArticleTitle();

        articlePageObject.addArticlesToMySaved();
        if (Platform.getInstance().isAndroid()){
            articlePageObject.addArticleToMyList(nameOfFolder);
        } else if (Platform.getInstance().isIOS()){
            articlePageObject.addArticlesToMySaved();
        }else if (Platform.getInstance().isMW()) {
            AuthorizationPageObject auth = new AuthorizationPageObject(driver);
            auth.clickAuthButton();
            auth.enterLoginData(login, password);
            auth.submitForm();
            articlePageObject.waitForTitleElement();

            assertEquals("We are not on the same page after login",
                    articleTitle,
                    articlePageObject.getArticleTitle());

            }

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        articlePageObject.waitForTitleElement();
        articlePageObject.addArticlesToMySaved();

        articlePageObject.waitForSaveButton();

        NavigationUi navigationUi = NavigationUiFactory.get(driver);
        navigationUi.openNavigation();
        navigationUi.clickMyLists();

        MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);
        int countSavedArticlesBeforeDeletion = myListsPageObject.getAmountOfSavedArticles();
        //myListsPageObject.waitForArticleToAppearByTitle("Horse");

        if (Platform.getInstance().isAndroid()){
            myListsPageObject.openFolderByName(nameOfFolder);
        }else {
            myListsPageObject.removeArticleFromSaved(articleTitle);
        }

        driver.navigate().back();

        myListsPageObject.waitForListPresent();

        int countSavedArticlesAfterDeletion = myListsPageObject.getAmountOfSavedArticles();

        Assert.assertEquals(
                "Can't find any articles to count",
                countSavedArticlesBeforeDeletion - 1,
                countSavedArticlesAfterDeletion
        );

        System.out.println("There is " + countSavedArticlesAfterDeletion);
    }

 }

