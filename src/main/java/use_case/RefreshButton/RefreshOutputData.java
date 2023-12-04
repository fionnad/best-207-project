package use_case.RefreshButton;

import java.util.ArrayList;

public class RefreshOutputData {

    private String creationTime;
    public String[] company1;
    public String[] company2;
    public String[] company3;
    public String[] company4;
    public String[] company5;


    public RefreshOutputData(String creationTime, ArrayList<String[]> tickers) {
        this.creationTime = creationTime;
        this.company1 = tickers.get(0);
        this.company2 = tickers.get(1);
        this.company3 = tickers.get(2);
        this.company4 = tickers.get(3);
        this.company5 = tickers.get(4);
    }
    public String getCreationTime() {
        return creationTime;
    }
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public ArrayList<String[]> getCompanies() {
        ArrayList<String[]> companyList = new ArrayList<>();
        companyList.add(company1);
        companyList.add(company2);
        companyList.add(company3);
        companyList.add(company4);
        companyList.add(company5);

        return companyList;
    }
}
