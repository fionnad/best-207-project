package app;

import data_access.GetYahooFinanceApiData;
import interface_adapter.SearchCompany.SearchCompanyController;
import interface_adapter.SearchCompany.SearchCompanyPresenter;
import interface_adapter.SearchCompany.SearchCompanyViewModel;
import use_case.SearchCompany.SearchCompanyDataAccessInterface;
import use_case.SearchCompany.SearchCompanyInputBoundary;
import use_case.SearchCompany.SearchCompanyInteractor;
import use_case.SearchCompany.SearchCompanyOutputData;

public class SearchCompanyUseCaseFactory {

    private SearchCompanyUseCaseFactory() {}

    public static SearchCompanyController create(SearchCompanyViewModel currentSearchCompanyViewModel, String ticker)  {
        SearchCompanyDataAccessInterface searchCompanyDataAccessInterface = new GetYahooFinanceApiData(ticker);
        SearchCompanyPresenter searchCompanyPresenter = new SearchCompanyPresenter(currentSearchCompanyViewModel);
        SearchCompanyInputBoundary searchCompanyInteractor = new SearchCompanyInteractor(searchCompanyDataAccessInterface, searchCompanyPresenter);
        return new SearchCompanyController(searchCompanyInteractor);
    }
}