package view;

import app.RankingsPageUseCaseFactory;
import app.SearchCompanyUseCaseFactory;
import data_access.SearchCompanyDataAccessObject;
import interface_adapter.RefreshButton.RefreshController;
import interface_adapter.RefreshButton.RefreshPresenter;
import interface_adapter.RefreshButton.RefreshViewModel;
import interface_adapter.SearchCompany.SearchCompanyController;
import interface_adapter.SearchCompany.SearchCompanyPresenter;
import interface_adapter.SearchCompany.SearchCompanyState;
import interface_adapter.SearchCompany.SearchCompanyViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;
import use_case.RefreshButton.RefreshInteractor;
import use_case.RefreshButton.RefreshOutputBoundary;
import use_case.SearchCompany.SearchCompanyInteractor;
import use_case.SearchCompany.SearchCompanyOutputBoundary;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class SearchCompanyViewTest {

    @Test
    void SearchCompanyValidCompanyTest() {
        // Initializing SearchCompanyState to contain ticker
        SearchCompanyState searchCompanyState = new SearchCompanyState();
        searchCompanyState.setCompanyTicker("AVGO");

        // Initializing SearchCompanyView and setting SearchCompanyState
        SearchCompanyViewModel searchCompanyViewModel = new SearchCompanyViewModel();
        searchCompanyViewModel.setState(searchCompanyState);

        SearchCompanyController searchCompanyController = SearchCompanyUseCaseFactory.create(searchCompanyViewModel, searchCompanyState.getCompanyTicker());

        // Passing SearchCompanyState to SearchCompanyViewModel
        JPanel searchView = new SearchCompanyView(searchCompanyViewModel);
        searchCompanyController.execute();

        JFrame jf = new JFrame();
        jf.setContentPane(searchView);
        jf.pack();
        jf.setVisible(true);
        searchCompanyController.execute();
        assertEquals("Search Complete", searchCompanyViewModel.getState().getCompanyFrontEndState());
    }

    @Test
    void SearchCompanyCompanyEmptyString() {
        // Initializing SearchCompanyState to contain ticker
        SearchCompanyState searchCompanyState = new SearchCompanyState();
        searchCompanyState.setCompanyTicker("");

        // Initializing SearchCompanyView and setting SearchCompanyState
        SearchCompanyViewModel searchCompanyViewModel = new SearchCompanyViewModel();
        searchCompanyViewModel.setState(searchCompanyState);

        SearchCompanyController searchCompanyController = SearchCompanyUseCaseFactory.create(searchCompanyViewModel, searchCompanyState.getCompanyTicker());

        // Passing SearchCompanyState to SearchCompanyViewModel
        JPanel searchView = new SearchCompanyView(searchCompanyViewModel);
        searchCompanyController.execute();

        JFrame jf = new JFrame();
        jf.setContentPane(searchView);
        jf.pack();
        jf.setVisible(true);
        searchCompanyController.execute();
        assertEquals("Nothing was searched!", searchCompanyViewModel.getState().getCompanyFrontEndState());
    }
}