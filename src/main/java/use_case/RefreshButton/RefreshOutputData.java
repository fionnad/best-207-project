package use_case.RefreshButton;

public class RefreshOutputData {

    private String creationTime;
    public String company1;
    public String company2;
    public String company3;
    public String company4;
    public String company5;


    public RefreshOutputData(String creationTime, String[] tickers) {
        this.creationTime = creationTime;
        this.company1 = tickers[0];
        this.company2 = tickers[1];
        this.company3 = tickers[2];
        this.company4 = tickers[3];
        this.company5 = tickers[4];
    }
    public String getCreationTime() {
        return creationTime;
    }
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String[] getCompanies() {
        return new String[]{company1, company2, company3, company4, company5};
    }
}
