package app;

import interface_adapter.SearchCompany.SearchCompanyController;
import use_case.SearchCompany.SearchCompanyInputBoundary;
import use_case.SearchCompany.SearchCompanyInteractor;

public class SearchCompanyUseCaseFactory {

    private SearchCompanyUseCaseFactory() {}

    public static SearchCompanyController create(String ticker)  {
        SearchCompanyInputBoundary searchCompanyInteractor = new SearchCompanyInteractor(ticker);
        return new SearchCompanyController(searchCompanyInteractor);
    }
}
