package use_case.SearchCompany;

import java.time.LocalDateTime;
import java.util.HashMap;

public class SearchCompanyOutputData {
    public boolean containsErrorCheck;
    public String companyDataFetchTime;
    public String companyEbitdaMargin;
    public String companyEbitdaMarginComment;
    public String companyDebtToEquity;
    public String companyDebtToEquityComment;

    public SearchCompanyOutputData(HashMap<String, Object> companyFinancialData) {
        this.containsErrorCheck = (boolean) companyFinancialData.get("containsErrorCheck");
        this.companyDataFetchTime = (String) companyFinancialData.get("companyDataFetchTime");
        this.companyEbitdaMargin = (String) companyFinancialData.get("companyEbitdaMargin");
        this.companyEbitdaMarginComment = (String) companyFinancialData.get("companyEbitdaMarginComment");
        this.companyDebtToEquity = (String) companyFinancialData.get("companyDebtToEquity");
        this.companyDebtToEquityComment = (String) companyFinancialData.get("companyDebtToEquityComment");
    }

    public boolean getContainsErrorCheck() {
        return this.containsErrorCheck;
    }

    public String getCompanyDataFetchTime() {
        return this.companyDataFetchTime;
    }

    public String getCompanyEbitdaMargin() {
        return this.companyEbitdaMargin;
    }

    public String getCompanyEbitdaMarginComment() {
        return this.companyEbitdaMarginComment;
    }

    public String getCompanyDebtToEquity() {
        return this.companyDebtToEquity;
    }

    public String getCompanyDebtToEquityComment() {
        return this.companyDebtToEquityComment;
    }

    public void setCompanyDataFetchTime(String companyDataFetchTime) {
        this.companyDataFetchTime = companyDataFetchTime;
    }

    public void setCompanyEbitdaMargin(String companyEbitdaMargin) {
        this.companyEbitdaMargin = companyEbitdaMargin;
    }

    public void setCompanyEbitdaMarginComment(String companyEbitdaMarginComment) {
        this.companyEbitdaMarginComment = companyEbitdaMarginComment;
    }

    public void setCompanyDebtToEquity(String companyDebtToEquity) {
        this.companyDebtToEquity = companyDebtToEquity;
    }

    public void setCompanyDebtToEquityComment(String companyDebtToEquityComment) {
        this.companyDebtToEquityComment = companyDebtToEquityComment;
    }
}
