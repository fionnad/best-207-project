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
    public void prepareSuccessView(RefreshOutputData successMessage) {
        LocalDateTime responseTime = LocalDateTime.parse(successMessage.getCreationTime());
        successMessage.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        RefreshState refreshState = refreshViewModel.getState();
        refreshState.setRefreshSuccess("Successful Refresh at " + successMessage.getCreationTime());
        refreshViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView() {
        RefreshState refreshState = refreshViewModel.getState();
        refreshState.setRefreshError("Refresh Failed");
        refreshViewModel.firePropertyChanged();
    }
}
