package use_case.SearchCompany;

import entities.CompanyData;

public class SearchCompanyOutputData {
    public boolean isValidCompany;
    public String companyDataFetchTime;
    public String companyEbitdaMargin;
    public String companyEbitdaMarginComment;
    public String companyDebtToEquity;
    public String companyDebtToEquityComment;
    public String companyRevenueGrowth;
    public String companyRevenueGrowthComment;
    public String companyFreeCashFlowMargin;
    public String companyFreeCashFlowMarginComment;
    public String companyFreeCashFlowPerShare;
    public String companyFreeCashFlowPerShareComment;
    public String companyFreeCashFlowYield;
    public String companyFreeCashFlowYieldComment;

    public SearchCompanyOutputData(CompanyData companyFinancialData) {
        this.isValidCompany = companyFinancialData.isValidCompany();
        this.companyDataFetchTime = companyFinancialData.getTimeFetched();
        this.companyEbitdaMargin = validator(companyFinancialData.getEbitdaMargins());
        this.companyEbitdaMarginComment = validator(companyFinancialData.getEbitdaMarginsAnalysis());
        this.companyDebtToEquity = validator(companyFinancialData.getDebtToEquity());
        this.companyDebtToEquityComment = validator(companyFinancialData.getDebtToEquityAnalysis());
        this.companyRevenueGrowth = validator(companyFinancialData.getRevenueGrowth());
        this.companyRevenueGrowthComment = validator(companyFinancialData.getRevenueGrowthAnalysis());
        this.companyFreeCashFlowMargin = validator(companyFinancialData.getFreeCashFlowMargin());
        this.companyFreeCashFlowMarginComment = validator(companyFinancialData.getFreeCashFlowMarginAnalysis());
        this.companyFreeCashFlowPerShare = validator(companyFinancialData.getFreeCashFlowPerShare());
        this.companyFreeCashFlowPerShareComment = validator(companyFinancialData.getFreeCashFlowPerShareAnalysis());
        this.companyFreeCashFlowYield = validator(companyFinancialData.getFreeCashFlowYield());
        this.companyFreeCashFlowYieldComment = validator(companyFinancialData.getFreeCashFlowYieldAnalysis());
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
    public String getCompanyRevenueGrowth() {
        return this.companyRevenueGrowth;
    }

    public String getCompanyRevenueGrowthComment() {
        return this.companyRevenueGrowthComment;
    }
    public String getCompanyFreeCashFlowMargin() {
        return this.companyFreeCashFlowMargin;
    }

    public String getCompanyFreeCashFlowMarginComment() {
        return this.companyFreeCashFlowMarginComment;
    }public String getCompanyFreeCashFlowPerShare() {
        return this.companyFreeCashFlowPerShare;
    }

    public String getCompanyFreeCashFlowPerShareComment() {
        return this.companyFreeCashFlowPerShareComment;
    }public String getCompanyFreeCashFlowYield() {
        return this.companyFreeCashFlowYield;
    }

    public String getCompanyFreeCashFlowYieldComment() {
        return this.companyFreeCashFlowYieldComment;
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
