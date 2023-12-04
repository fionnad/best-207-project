package interface_adapter.RefreshButton;

import java.util.ArrayList;

public class RefreshState {

    private String refreshError = "Refresh Error";
    private String timeOfRefresh = "Refreshed at";

    private String refreshStatus = null;
    public String[] company1 = new String[] {null, null, null, null, null};
    public String[] company2 = new String[] {null, null, null, null, null};
    public String[] company3 = new String[] {null, null, null, null, null};
    public String[] company4 = new String[] {null, null, null, null, null};
    public String[] company5 = new String[] {null, null, null, null, null};



    public RefreshState(RefreshState copy) {

        this.refreshError = copy.refreshError;


        this.refreshStatus = copy.refreshStatus;
    }

    public RefreshState() {

    }

    public void setCompanyInfo(ArrayList<String[]> tickers) {
        this.company1 = tickers.get(0);
        this.company2 = tickers.get(1);
        this.company3 = tickers.get(2);
        this.company4 = tickers.get(3);
        this.company5 = tickers.get(4);
    }



    public void setRefreshError(String refreshError) {this.refreshError = refreshError;}
    public void setRefreshTime(String time) {this.timeOfRefresh = time;}


    public void setRefreshStatus(String status) {this.refreshStatus = status;}

    public String getRefreshStatus() {return this.refreshStatus;}

    public ArrayList<String[]> getRefreshSuccess() {
        ArrayList<String[]> cList = new ArrayList<>();
        cList.add(company1);
        cList.add(company2);
        cList.add(company3);
        cList.add(company4);
        cList.add(company5);

        return cList;
    }

    public String getRefreshTime() {return this.timeOfRefresh;}

}
