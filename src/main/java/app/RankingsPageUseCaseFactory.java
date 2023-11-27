package app;

import interface_adapter.RefreshButton.RefreshController;
import interface_adapter.RefreshButton.RefreshPresenter;
import interface_adapter.RefreshButton.RefreshViewModel;
import interface_adapter.ViewManagerModel;
import use_case.RefreshButton.RefreshDataAccessInterface;
import use_case.RefreshButton.RefreshInteractor;
import use_case.RefreshButton.RefreshOutputBoundary;
import view.RankingsPageView;

import javax.swing.*;
import java.io.IOException;

public class RankingsPageUseCaseFactory {

    public static RankingsPageView create(
            ViewManagerModel viewManagerModel, RefreshViewModel refreshViewModel, RefreshDataAccessInterface refreshDataAccessObject) {
        try {
            RefreshController refreshController = createRefreshUseCase(viewManagerModel, refreshViewModel, refreshDataAccessObject);
            return new RankingsPageView(refreshViewModel, refreshController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        return null;
    }

    public static RefreshController createRefreshUseCase(ViewManagerModel viewManagerModel, RefreshViewModel refreshViewModel, RefreshDataAccessInterface refreshDataAccessObject) throws IOException {
        RefreshOutputBoundary refreshOutputBoundary = new RefreshPresenter(refreshViewModel, viewManagerModel);
        RefreshInteractor refreshInteractor = new RefreshInteractor(refreshDataAccessObject, refreshOutputBoundary);
        return new RefreshController(refreshInteractor);
    }
}
