package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ResultPage;

import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest {

    private String searchText = "купить кофемашину bork c804";
    private String resultText = "mvideo.ru";

    @Test
    public void testSearchCountIsMoreThanTen() {
        ResultPage resultPage = searchPage.searchByText(searchText);
        int resultsCount = resultPage.getResultsCount();
        assertTrue(resultsCount > 10, "There are not enough results");
    }

    @Test
    public void testResultsContainGivenValue() {
        ResultPage resultPage = searchPage.searchByText(searchText);
        boolean resultExists = resultPage.checkGivenLinkIsInResults(resultText);
        assertTrue(resultExists, "mvideo.ru is missing from search results");
    }

}
