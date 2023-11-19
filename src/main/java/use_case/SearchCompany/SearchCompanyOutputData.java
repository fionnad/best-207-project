package use_case.SearchCompany;

import java.time.LocalDateTime;

public class SearchCompanyOutputData {
    private final String companyFinData;
    private String creationTime;

    private boolean doesCompanyExist;

    public SearchCompanyOutputData(String companyFinancialData, LocalDateTime creationTime, boolean companyExists) {
        this.companyFinData = companyFinancialData;
        this.creationTime = creationTime.toString();
        this.doesCompanyExist = companyExists;
    }

    public String getCompanyFinData() {
        return companyFinData;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}