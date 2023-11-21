package interface_adapter.RefreshButton;

import use_case.RefreshButton.RefreshOutputBoundary;
import use_case.RefreshButton.RefreshOutputData;
import use_case.SearchCompany.SearchCompanyOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RefreshPresenter implements RefreshOutputBoundary {

    private final RefreshViewModel refreshViewModel;

    public RefreshPresenter(RefreshViewModel refreshViewModel) {
        this.refreshViewModel = refreshViewModel;
    }

    @Override
    public void prepareSuccessView(RefreshOutputData successMessage) {
        LocalDateTime responseTime = LocalDateTime.parse(successMessage.getCreationTime());
        successMessage.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        RefreshState refreshState = refreshViewModel.getState();
        refreshState.setRefreshSuccess("Success Refresh" + successMessage.getCreationTime());
        refreshViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView() {
        RefreshState refreshState = refreshViewModel.getState();
        refreshState.setRefreshError("Refresh Failed");
        refreshViewModel.firePropertyChanged();
    }
}
