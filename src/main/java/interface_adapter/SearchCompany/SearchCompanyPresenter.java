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
        searchCompanyState.setCompanyFrontEndState("Search Complete");
        searchCompanyState.setCompanyInformation(companyFinancialData);
        searchCompanyViewModel.firePropertyChanged();
    }

    @Override
    public void prepareInvalidFindView() {
        SearchCompanyState searchCompanyState = searchCompanyViewModel.getState();
        searchCompanyState.setCompanyFrontEndState("Invalid company, please search again.");
        searchCompanyState.setCompanyInformationNull();
        searchCompanyViewModel.firePropertyChanged();
    }

    @Override
    public void prepareEmptySearchView() {
        SearchCompanyState searchCompanyState = searchCompanyViewModel.getState();
        searchCompanyState.setCompanyFrontEndState("Nothing was searched!");
        searchCompanyState.setCompanyInformationNull();
        searchCompanyViewModel.firePropertyChanged();
    }
}