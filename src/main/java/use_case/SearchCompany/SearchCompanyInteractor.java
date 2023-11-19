package use_case.SearchCompany;

import org.json.simple.parser.ParseException;

import java.time.LocalDateTime;
import java.util.HashMap;

public class SearchCompanyInteractor implements SearchCompanyInputBoundary {
    final SearchCompanyDataAccessInterface searchCompanyDataAccessInterface;
    final SearchCompanyOutputBoundary searchCompanyOutputBoundary;

    public SearchCompanyInteractor(SearchCompanyDataAccessInterface searchCompanyDataAccessInterface, SearchCompanyOutputBoundary newSearchCompanyOutputBoundary) {
        this.searchCompanyDataAccessInterface = searchCompanyDataAccessInterface;
        this.searchCompanyOutputBoundary = newSearchCompanyOutputBoundary;
    }

    public void execute() {
        HashMap<String, Object> finDataInfo = searchCompanyDataAccessInterface.getParsedFinData();
        SearchCompanyOutputData searchCompanyOutputData = new SearchCompanyOutputData(finDataInfo);
        searchCompanyOutputBoundary.prepareSuccessView(searchCompanyOutputData);
    }

    public boolean validateCompany() {
        return true;
    };
}