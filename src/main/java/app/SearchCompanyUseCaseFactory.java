package app;

import data_access.SearchCompanyDataAccessObject;
import interface_adapter.SearchCompany.SearchCompanyController;
import interface_adapter.SearchCompany.SearchCompanyPresenter;
import interface_adapter.SearchCompany.SearchCompanyViewModel;
import use_case.SearchCompany.SearchCompanyDataAccessInterface;
import use_case.SearchCompany.SearchCompanyInputBoundary;
import use_case.SearchCompany.SearchCompanyInputData;
import use_case.SearchCompany.SearchCompanyInteractor;

public class SearchCompanyUseCaseFactory {
    public static SearchCompanyController create(SearchCompanyViewModel currentSearchCompanyViewModel, String ticker)  {
        SearchCompanyInputData searchCompanyInputData = new SearchCompanyInputData(ticker);
        SearchCompanyDataAccessInterface searchCompanyDataAccessInterface = new SearchCompanyDataAccessObject(searchCompanyInputData.getTicker());
        SearchCompanyPresenter searchCompanyPresenter = new SearchCompanyPresenter(currentSearchCompanyViewModel);
        SearchCompanyInputBoundary searchCompanyInteractor = new SearchCompanyInteractor(searchCompanyDataAccessInterface, searchCompanyPresenter);
        return new SearchCompanyController(searchCompanyInteractor);
    }
}