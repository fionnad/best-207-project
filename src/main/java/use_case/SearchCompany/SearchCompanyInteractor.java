package use_case.SearchCompany;

import entities.CompanyData;

public class SearchCompanyInteractor implements SearchCompanyInputBoundary {
    final SearchCompanyDataAccessInterface searchCompanyDataAccessInterface;
    final SearchCompanyOutputBoundary searchCompanyOutputBoundary;

    public SearchCompanyInteractor(SearchCompanyDataAccessInterface searchCompanyDataAccessInterface, SearchCompanyOutputBoundary newSearchCompanyOutputBoundary) {
        this.searchCompanyDataAccessInterface = searchCompanyDataAccessInterface;
        this.searchCompanyOutputBoundary = newSearchCompanyOutputBoundary;
    }

    public void execute() {
        CompanyData finDataInfo = searchCompanyDataAccessInterface.getCompanyData();
        if (finDataInfo.isValidCompany()) {
            SearchCompanyOutputData searchCompanyOutputData = new SearchCompanyOutputData(finDataInfo);
            searchCompanyOutputBoundary.prepareSuccessView(searchCompanyOutputData);
        } else {
            searchCompanyOutputBoundary.prepareFailView();
        }
    }
}