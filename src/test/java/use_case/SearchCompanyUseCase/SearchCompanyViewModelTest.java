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

    @Test
    void searchCompanyValidCompanyTest() {
        // Initializing SearchCompanyState to contain ticker
        SearchCompanyState searchCompanyState = new SearchCompanyState();
        searchCompanyState.setCompanyTicker("PEP");

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

        // Testing to ensure all data exists in CompanyData Class
        assertEquals("PEP", searchCompanyViewModel.getState().getCompanyTicker());
        assertEquals("Valid Company", searchCompanyViewModel.getState().getCompanyFrontEndState());
        assertNotNull(searchCompanyViewModel.getState().getCompanyFrontEndState());
        assertNotNull(searchCompanyViewModel.getState().getCompanyDataFetchTime());
        assertNotNull(searchCompanyViewModel.getState().getCompanyEbitdaMargin());
        assertNotNull(searchCompanyViewModel.getState().getCompanyEbitdaMarginComment());
        assertNotNull(searchCompanyViewModel.getState().getCompanyDebtToEquity());
        assertNotNull(searchCompanyViewModel.getState().getCompanyDebtToEquityComment());
        assertNotNull(searchCompanyViewModel.getState().getCompanyRevenueGrowth());
        assertNotNull(searchCompanyViewModel.getState().getCompanyRevenueGrowthComment());
        assertNotNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowMargin());
        assertNotNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowMarginComment());
        assertNotNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowPerShare());
        assertNotNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowPerShareComment());
        assertNotNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowYield());
        assertNotNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowYieldComment());
        assertNotNull(searchCompanyViewModel.getState().getEarningsDate());
        assertNotNull(searchCompanyViewModel.getState().getDividendDate());
        assertNotNull(searchCompanyViewModel.getState().getExDividendDate());

        // Testing to ensure front end properties adjust accordingly
    }

    @Test
    void searchCompanyInvalidCompanyTest() {
        // Initializing SearchCompanyState to contain ticker
        SearchCompanyState searchCompanyState = new SearchCompanyState();
        searchCompanyState.setCompanyTicker("abcdefg");

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

        // Testing to ensure all data exists in CompanyData Class
        assertEquals("abcdefg", searchCompanyViewModel.getState().getCompanyTicker());
        assertEquals("Invalid company, please search again.", searchCompanyViewModel.getState().getCompanyFrontEndState());
        assertNull(searchCompanyViewModel.getState().getCompanyDataFetchTime());
        assertNull(searchCompanyViewModel.getState().getCompanyEbitdaMargin());
        assertNull(searchCompanyViewModel.getState().getCompanyEbitdaMarginComment());
        assertNull(searchCompanyViewModel.getState().getCompanyDebtToEquity());
        assertNull(searchCompanyViewModel.getState().getCompanyDebtToEquityComment());
        assertNull(searchCompanyViewModel.getState().getCompanyRevenueGrowth());
        assertNull(searchCompanyViewModel.getState().getCompanyRevenueGrowthComment());
        assertNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowMargin());
        assertNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowMarginComment());
        assertNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowPerShare());
        assertNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowPerShareComment());
        assertNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowYield());
        assertNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowYieldComment());
        assertNull(searchCompanyViewModel.getState().getEarningsDate());
        assertNull(searchCompanyViewModel.getState().getDividendDate());
        assertNull(searchCompanyViewModel.getState().getExDividendDate());

        // Testing to ensure front end properties adjust accordingly
    }

    @Test
    void searchCompanyEmptyCompanyTest() {
        // Initializing SearchCompanyState to contain ticker
        SearchCompanyState searchCompanyState = new SearchCompanyState();
        searchCompanyState.setCompanyTicker("");

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

        // Testing to ensure all data exists in CompanyData Class
        assertEquals("", searchCompanyViewModel.getState().getCompanyTicker());
        assertEquals("Invalid company, please search again.", searchCompanyViewModel.getState().getCompanyFrontEndState());
        assertNull(searchCompanyViewModel.getState().getCompanyDataFetchTime());
        assertNull(searchCompanyViewModel.getState().getCompanyEbitdaMargin());
        assertNull(searchCompanyViewModel.getState().getCompanyEbitdaMarginComment());
        assertNull(searchCompanyViewModel.getState().getCompanyDebtToEquity());
        assertNull(searchCompanyViewModel.getState().getCompanyDebtToEquityComment());
        assertNull(searchCompanyViewModel.getState().getCompanyRevenueGrowth());
        assertNull(searchCompanyViewModel.getState().getCompanyRevenueGrowthComment());
        assertNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowMargin());
        assertNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowMarginComment());
        assertNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowPerShare());
        assertNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowPerShareComment());
        assertNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowYield());
        assertNull(searchCompanyViewModel.getState().getCompanyFreeCashFlowYieldComment());
        assertNull(searchCompanyViewModel.getState().getEarningsDate());
        assertNull(searchCompanyViewModel.getState().getDividendDate());
        assertNull(searchCompanyViewModel.getState().getExDividendDate());
    }
}
