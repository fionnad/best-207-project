package interface_adapter.RefreshButton;

import interface_adapter.ViewManagerModel;
import use_case.RefreshButton.RefreshOutputBoundary;
import use_case.RefreshButton.RefreshOutputData;
import use_case.SearchCompany.SearchCompanyOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RefreshPresenter implements RefreshOutputBoundary {

    private final RefreshViewModel refreshViewModel;
    private ViewManagerModel viewManagerModel;

    public RefreshPresenter(RefreshViewModel refreshViewModel, ViewManagerModel viewManagerModel) {
        this.refreshViewModel = refreshViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RefreshOutputData refreshOutputData) {
        LocalDateTime responseTime = LocalDateTime.parse(refreshOutputData.getCreationTime());
        refreshOutputData.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        RefreshState refreshState = refreshViewModel.getState();
        refreshState.setCompanyInfo(refreshOutputData.getCompanies());
        refreshState.setRefreshTime("Successful Refresh at " + refreshOutputData.getCreationTime());
        refreshState.setRefreshStatus("Successful Refresh");
        refreshViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView() {
        RefreshState refreshState = refreshViewModel.getState();
        refreshState.setRefreshError("Refresh Failed");
        refreshState.setRefreshStatus("Refresh Failed");
        refreshViewModel.firePropertyChanged();
    }
}
