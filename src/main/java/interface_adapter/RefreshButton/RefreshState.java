package interface_adapter.RefreshButton;

public class RefreshState {

    private String refreshError = "Refresh Error";

    private String refreshSuccess = "Refresh Success";

    public RefreshState(RefreshState copy) {
        this.refreshError = copy.refreshError;
    }

    public RefreshState() {
    }


    public void setRefreshError(String refreshError) {this.refreshError = refreshError;}
    public void setRefreshSuccess(String refreshSuccess) {this.refreshSuccess = refreshSuccess;}

    public String getRefreshSuccess() {return refreshSuccess;}
}
