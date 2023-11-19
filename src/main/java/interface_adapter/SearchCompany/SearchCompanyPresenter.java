package interface_adapter.SearchCompany;

import use_case.SearchCompany.SearchCompanyOutputBoundary;
import use_case.SearchCompany.SearchCompanyOutputData;

import java.time.format.DateTimeFormatter;

public class SearchCompanyPresenter implements SearchCompanyOutputBoundary {

    private final SearchCompanyViewModel searchCompanyViewModel;

    public SearchCompanyPresenter(SearchCompanyViewModel newSearchCompanyViewModel) {
        this.searchCompanyViewModel = newSearchCompanyViewModel;
    }


    @Override
    public void prepareSuccessView(SearchCompanyOutputData companyFinancialData) {
        SearchCompanyState searchCompanyState = searchCompanyViewModel.getState();
        if (companyFinancialData.getContainsErrorCheck()) {
            searchCompanyState.setCompanyFrontEndState("Invalid company, please search again.");
            searchCompanyState.setCompanyInformationNull();
        } else {
            searchCompanyState.setCompanyFrontEndState("Valid Company");
            searchCompanyState.setCompanyInformation(companyFinancialData);
        }
        searchCompanyViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}