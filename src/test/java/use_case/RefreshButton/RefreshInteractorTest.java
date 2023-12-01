package use_case.RefreshButton;

import data_access.RefreshDataAccessObject;
import entities.CompanyDataFactory;
import interface_adapter.RefreshButton.RefreshController;
import interface_adapter.RefreshButton.RefreshPresenter;
import interface_adapter.RefreshButton.RefreshViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class RefreshInteractorTest {
    @Test
    public void testRefreshInteractorSuccess() {

        RefreshDataAccessObject refreshDataAccessObject;

        try {
            refreshDataAccessObject = new RefreshDataAccessObject("./Tickers.csv","./Tickers.txt", new CompanyDataFactory());
        }
        catch (
                IOException e) {
            throw new RuntimeException(e);
        }


        ViewManagerModel viewManagerModel = new ViewManagerModel();
        RefreshViewModel refreshViewModel = new RefreshViewModel();

        RefreshOutputBoundary refreshOutputBoundary = new RefreshPresenter(refreshViewModel, viewManagerModel);
        RefreshInteractor refreshInteractor = new RefreshInteractor(refreshDataAccessObject, refreshOutputBoundary);
        RefreshController refreshController = new RefreshController(refreshInteractor);

        refreshController.execute();

        assertEquals("Successful Refresh", refreshViewModel.getState().getRefreshStatus());
    }

}