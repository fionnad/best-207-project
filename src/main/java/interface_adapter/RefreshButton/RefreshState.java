package interface_adapter.RefreshButton;

public class RefreshState {

    private String refreshError = "Refresh Error";

    private String refreshSuccess = "Refresh Success";

    private String refreshStatus = null;
    public String company1;
    public String company2;
    public String company3;
    public String company4;
    public String company5;



    public RefreshState(RefreshState copy) {
        this.refreshError = copy.refreshError;
        this.refreshSuccess = copy.refreshSuccess;
        this.refreshStatus = copy.refreshStatus;
    }

    public RefreshState() {

    }

    public void setCompanyInfo(String[] tickers) {
        this.company1 = tickers[0];
        this.company2 = tickers[1];
        this.company3 = tickers[2];
        this.company4 = tickers[3];
        this.company5 = tickers[4];
    }


    public void setRefreshError(String refreshError) {this.refreshError = refreshError;}
    public void setRefreshSuccess(String refreshSuccess) {this.refreshSuccess = refreshSuccess;}

    public void setRefreshStatus(String status) {this.refreshStatus = status;}

    public String getRefreshStatus() {return this.refreshStatus;}

    public String[] getRefreshSuccess() {
        return new String[]{company1, company2, company3, company4, company5};
    }


}
