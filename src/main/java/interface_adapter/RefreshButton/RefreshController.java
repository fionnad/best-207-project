package interface_adapter.RefreshButton;

import use_case.RefreshButton.RefreshInteractor;

public class RefreshController {
    private final RefreshInteractor refreshInteractor;


    public RefreshController(RefreshInteractor refreshInteractor) {
        this.refreshInteractor = refreshInteractor;
    }

    public void execute() {
        refreshInteractor.execute(); }
}
