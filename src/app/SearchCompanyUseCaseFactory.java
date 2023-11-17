package app;

import interface_adapter.SearchCompany.SearchCompanyController;
import interface_adapter.SearchCompany.SearchCompanyPresenter;
import interface_adapter.SearchCompany.SearchCompanyViewModel;
import use_case.SearchCompany.SearchCompanyInputBoundary;
import use_case.SearchCompany.SearchCompanyInteractor;
import use_case.SearchCompany.SearchCompanyOutputData;

public class SearchCompanyUseCaseFactory {

    private SearchCompanyUseCaseFactory() {}

    public static SearchCompanyController create(String ticker)  {
        SearchCompanyViewModel searchCompanyViewModel = new SearchCompanyViewModel();
        SearchCompanyPresenter searchCompanyPresenter = new SearchCompanyPresenter(searchCompanyViewModel);
        SearchCompanyInputBoundary searchCompanyInteractor = new SearchCompanyInteractor(ticker, searchCompanyPresenter);
        return new SearchCompanyController(searchCompanyInteractor);
    }
}
