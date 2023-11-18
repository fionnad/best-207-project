package use_case.SearchCompany;

import java.time.LocalDateTime;

public class SearchCompanyInteractor implements SearchCompanyInputBoundary {
    final String ticker;
    final SearchCompanyOutputBoundary searchCompanyOutputBoundary;

    public SearchCompanyInteractor(String ticker, SearchCompanyOutputBoundary newSearchCompanyOutputBoundary) {
        this.ticker = ticker;
        this.searchCompanyOutputBoundary = newSearchCompanyOutputBoundary;
    }

    public void execute() {
        SearchCompanyDataAccessInterface searchCompanyDataAccessInterface = new SearchCompanyDataAccessInterface(this.ticker);
        SearchCompanyOutputData searchCompanyOutputData = new SearchCompanyOutputData(searchCompanyDataAccessInterface.getFinData(), LocalDateTime.now(),  true);
        searchCompanyOutputBoundary.prepareSuccessView(searchCompanyOutputData);
    }

    public boolean validateCompany() {
        return true;
    };
}