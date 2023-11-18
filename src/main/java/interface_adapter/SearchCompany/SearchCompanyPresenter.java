package interface_adapter.SearchCompany;

import use_case.SearchCompany.SearchCompanyOutputBoundary;
import use_case.SearchCompany.SearchCompanyOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SearchCompanyPresenter implements SearchCompanyOutputBoundary {

    private final SearchCompanyViewModel searchCompanyViewModel;

    public SearchCompanyPresenter(SearchCompanyViewModel newSearchCompanyViewModel) {
        this.searchCompanyViewModel = newSearchCompanyViewModel;
    }


    @Override
    public void prepareSuccessView(SearchCompanyOutputData companyFinancialData) {
        String responseTime = companyFinancialData.getCreationTime();
        companyFinancialData.setCreationTime(responseTime.format(String.valueOf(DateTimeFormatter.ofPattern("hh:mm:ss"))));

        SearchCompanyState searchCompanyState = searchCompanyViewModel.getState();
        searchCompanyState.setCompanyInformation(companyFinancialData.getCompanyFinData());
        searchCompanyViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}