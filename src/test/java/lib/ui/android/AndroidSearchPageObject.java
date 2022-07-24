package lib.ui.android;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
        SEARCH_INPUT = "xpath://*[contains(@text,'Search')]";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(@text,'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/search_container']";
        SEARCH_RESULT_ELEMENT_BY_ID = "id:org.wikipedia:id/fragment_main_coordinator";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results found']";
        SEARCH_RESULT_BY_TITLE_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/view_page_title_text']/*[@text='{SEARCH_TITLE}']";
        SEARCH_RESULT_BY_DESCRIPTION_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/view_page_subtitle_text']/*[@text='{SEARCH_DESCRIPTION}']";
    }

    public AndroidSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }


}
