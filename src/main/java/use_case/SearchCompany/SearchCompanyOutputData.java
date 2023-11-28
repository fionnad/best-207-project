package use_case.SearchCompany;

import entities.CompanyData;

public class SearchCompanyOutputData {
    public boolean isValidCompany;
    public String companyDataFetchTime;
    public String companyEbitdaMargin;
    public String companyEbitdaMarginComment;
    public String companyDebtToEquity;
    public String companyDebtToEquityComment;

    public SearchCompanyOutputData(CompanyData companyFinancialData) {
        this.isValidCompany = companyFinancialData.isValidCompany();
        this.companyDataFetchTime = companyFinancialData.getTimeFetched();
        this.companyEbitdaMargin = validator(companyFinancialData.getEbitdaMargins());
        this.companyEbitdaMarginComment = validator(companyFinancialData.getEbitdaMarginsAnalysis());
        this.companyDebtToEquity = validator(companyFinancialData.getDebtToEquity());
        this.companyDebtToEquityComment = validator(companyFinancialData.getDebtToEquityAnalysis());
    }

    public String validator(Object object) {
        if (object == null) {
            return "No data";
        } else {
            return object.toString();
        }
    }

    public boolean getIsValidCompany() {
        return this.isValidCompany;
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
