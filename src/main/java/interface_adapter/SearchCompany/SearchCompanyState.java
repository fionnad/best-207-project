package interface_adapter.SearchCompany;

public class SearchCompanyState {
    public String companyTicker = "";
    public String companyFrontEndState = "Nothing to show";
    public String companyDataFetchTime = null;
    public String companyEbitdaMargin = null;
    public String companyEbitdaMarginComment = null;
    public String companyDebtToEquity = null;
    public String companyDebtToEquityComment = null;

    public SearchCompanyState(SearchCompanyState copy) {
        companyTicker = copy.companyTicker;
    }

    public SearchCompanyState() {}

    public String getCompanyTicker() {
        return companyTicker;
    }

    public String getCompanyFrontEndState() {
        return this.companyFrontEndState;
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

    public void setCompanyTicker(String companyTicker) {
        this.companyTicker = companyTicker;
    }

    public void setCompanyFrontEndState(String newCompanyInformation) {
        this.companyFrontEndState = newCompanyInformation;
    }

    public void setCompanyDataFetchTime(String newCompanyDataFetchTime) {
        this.companyDataFetchTime = newCompanyDataFetchTime;
    }

    public void setCompanyEbitdaMargin(String newCompanyEbitdaMargin) {
        this.companyEbitdaMargin = newCompanyEbitdaMargin;
    }

    public void setCompanyEbitdaMarginComment(String newCompanyEbitdaMarginComment) {
        this.companyEbitdaMarginComment = newCompanyEbitdaMarginComment;
    }

    public void setCompanyDebtToEquity(String newCompanyDebtToEquity) {
        this.companyDebtToEquity = newCompanyDebtToEquity;
    }

    public void setCompanyDebtToEquityComment(String newCompanyDebtToEquityComment) {
        this.companyDebtToEquityComment = newCompanyDebtToEquityComment;
    }
}
