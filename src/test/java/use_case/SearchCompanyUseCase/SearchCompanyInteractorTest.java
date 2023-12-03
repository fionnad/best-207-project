package use_case.SearchCompanyUseCase;

import data_access.SearchCompanyDataAccessObject;
import interface_adapter.SearchCompany.SearchCompanyPresenter;
import interface_adapter.SearchCompany.SearchCompanyState;
import interface_adapter.SearchCompany.SearchCompanyViewModel;
import org.junit.jupiter.api.Test;
import use_case.SearchCompany.SearchCompanyDataAccessInterface;
import use_case.SearchCompany.SearchCompanyInteractor;

import static org.junit.jupiter.api.Assertions.*;

class SearchCompanyInteractorTest {

    @Test
    void executeValidCompany() {
        SearchCompanyViewModel searchCompanyViewModel = new SearchCompanyViewModel();
        SearchCompanyDataAccessInterface searchCompanyDataAccessInterface = new SearchCompanyDataAccessObject("PEP");
        SearchCompanyPresenter searchCompanyPresenter = new SearchCompanyPresenter(searchCompanyViewModel);
        SearchCompanyInteractor searchCompanyInteractor = new SearchCompanyInteractor(searchCompanyDataAccessInterface, searchCompanyPresenter);
        searchCompanyInteractor.execute(); // If executed properly, information will be updated in view
        assertEquals("PEP", searchCompanyViewModel.getState().getCompanyTicker());
    }

    @Test
    void executeInvalidCompany() {
    }

    @Test
    void executeValidCompanyMissingData() {
    }

    @Test
    void executeEmptyString() {
    }
}