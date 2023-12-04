package view;

import app.RankingsPageUseCaseFactory;
import data_access.RefreshDataAccessObject;
import entities.CompanyDataFactory;
import interface_adapter.RefreshButton.RefreshController;
import interface_adapter.RefreshButton.RefreshPresenter;
import interface_adapter.RefreshButton.RefreshViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;
import use_case.RefreshButton.RefreshInteractor;
import use_case.RefreshButton.RefreshOutputBoundary;

import javax.swing.*;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class RankingsPageViewTest {
    @Test
    public void testView() {
        RefreshDataAccessObject refreshDataAccessObject;

        try {
            refreshDataAccessObject = new RefreshDataAccessObject("./TestTickers.csv","./TestTickers.txt", new CompanyDataFactory());
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
        JPanel refreshView = RankingsPageUseCaseFactory.create(viewManagerModel, refreshViewModel, refreshDataAccessObject);
        JFrame jf = new JFrame();
        jf.setContentPane(refreshView);
        jf.pack();
        jf.setVisible(true);
        refreshController.execute();
        assertEquals("Successful Refresh", refreshViewModel.getState().getRefreshStatus());
    }

}