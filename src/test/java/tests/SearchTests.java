package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class SearchTests extends CoreTestCase {

    @Test
    public void testSearch() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    @Test
    public void testSearchByTitleAndDescription() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForSearchResult("Object-oriented programming language");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        searchPageObject.waitForElementByTitleAndDescription("Java","Object-oriented programming language");
    }

    @Test
    public void testCancelSearch() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.waitForCancelButtonToAppear();
        searchPageObject.clickCanselSearch();
        searchPageObject.waitForCancelButtonToDisappear();

    }

    @Test
    public void testAmountOfNotEmptySearch() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        String searchLine = "Linkin Park Discography";
        searchPageObject.typeSearchLine(searchLine);

        int amountOfSearchResults = searchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found few results",
                amountOfSearchResults > 0);
    }

    @Test
    public void testAmountOfEmptySearch() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        String searchLine = "ghjghfjghfjghfj";
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.waitForEmptyResultsLabel();
        searchPageObject.assertThereIsNoResultOfSearch();
    }

    @Test
    public void testCancelingASearch() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        String searchLine = "Linkin Park Discography";
        searchPageObject.typeSearchLine(searchLine);

        int amountOfSearchResults = searchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found few results",
                amountOfSearchResults > 0);

        searchPageObject.clickCanselSearch();
        searchPageObject.waitForEmptyResultsLabel();
        searchPageObject.assertThereIsNoResultOfSearch();
    }

    @Test
    public void testCheckValidSearch() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Horse");
        searchPageObject.getAmountOfFoundArticles();

        int amountOfSearchResults = searchPageObject.getAmountOfFoundArticles();

        assertNotEquals("NOT EQUALS WITH SEARCH", 0, amountOfSearchResults);

        driver.navigate().back();

        searchPageObject.clickCanselSearch();
        searchPageObject.waitForCancelButtonToDisappear();

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.getAmountOfFoundArticles();

        amountOfSearchResults = searchPageObject.getAmountOfFoundArticles();

        assertNotEquals("NOT EQUALS WITH SEARCH", 0, amountOfSearchResults);

        driver.navigate().back();

        searchPageObject.clickCanselSearch();
        searchPageObject.waitForCancelButtonToDisappear();

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("GG");
        searchPageObject.getAmountOfFoundArticles();

        amountOfSearchResults = searchPageObject.getAmountOfFoundArticles();

        assertNotEquals("NOT EQUALS WITH SEARCH", 0, amountOfSearchResults);

    }
}
