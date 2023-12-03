package use_case.SearchCompanyUseCase;

import data_access.SearchCompanyDataAccessObject;
import interface_adapter.SearchCompany.SearchCompanyController;
import interface_adapter.SearchCompany.SearchCompanyPresenter;
import interface_adapter.SearchCompany.SearchCompanyState;
import interface_adapter.SearchCompany.SearchCompanyViewModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import use_case.SearchCompany.SearchCompanyInteractor;
import use_case.SearchCompany.SearchCompanyOutputBoundary;

public class SearchCompanyViewModelTest {
    public final String ticker = "AAPL";

    @Test
    void searchCompanyValidCompanyTest() {
        // Initializing SearchCompanyState to contain ticker
        SearchCompanyState searchCompanyState = new SearchCompanyState();
        searchCompanyState.setCompanyTicker(this.ticker);

        // Initializing SearchCompanyView and setting SearchCompanyState
        SearchCompanyViewModel searchCompanyViewModel = new SearchCompanyViewModel();
        searchCompanyViewModel.setState(searchCompanyState);

        // Initializing SearchCompanyDataAccessObject
        SearchCompanyDataAccessObject searchCompanyDataAccessObject = new SearchCompanyDataAccessObject(searchCompanyViewModel.getState().getCompanyTicker());

        // Initializing SearchCompanyOutputBoundary
        SearchCompanyOutputBoundary searchCompanyOutputBoundary = new SearchCompanyPresenter(searchCompanyViewModel);
        SearchCompanyInteractor searchCompanyInteractor = new SearchCompanyInteractor(searchCompanyDataAccessObject, searchCompanyOutputBoundary);

        // Passing SearchCompanyState to SearchCompanyViewModel
        SearchCompanyController searchCompanyController = new SearchCompanyController(searchCompanyInteractor);
        searchCompanyController.execute();
        assertEquals("Valid Company", searchCompanyViewModel.getState().getCompanyFrontEndState());
    }
}
