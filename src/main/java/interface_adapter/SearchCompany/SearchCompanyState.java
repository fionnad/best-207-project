package interface_adapter.SearchCompany;
import use_case.SearchCompany.SearchCompanyOutputData;

public class SearchCompanyState {
    public String companyTicker = "";
    public String companyFrontEndState = "Nothing to show";
    public String companyDataFetchTime = null;
    public String companyEbitdaMargin = null;
    public String companyEbitdaMarginComment = null;
    public String companyDebtToEquity = null;
    public String companyDebtToEquityComment = null;
    public String companyRevenueGrowth = null;
    public String companyRevenueGrowthComment = null;
    public String companyFreeCashFlowMargin = null;
    public String companyFreeCashFlowMarginComment = null;
    public String companyFreeCashFlowPerShare = null;
    public String companyFreeCashFlowPerShareComment = null;
    public String companyFreeCashFlowYield = null;
    public String companyFreeCashFlowYieldComment = null;
    public String earningsDate = null;
    public String dividendDate = null;
    public String exDividendDate = null;

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
    }
    public String getCompanyFreeCashFlowPerShare() {
        return this.companyFreeCashFlowPerShare;
    }
    public String getCompanyFreeCashFlowPerShareComment() {
        return this.companyFreeCashFlowPerShareComment;
    }
    public String getCompanyFreeCashFlowYield() {
        return this.companyFreeCashFlowYield;
    }
    public String getCompanyFreeCashFlowYieldComment() {
        return this.companyFreeCashFlowYieldComment;
    }
    public String getEarningsDate() {
        return this.earningsDate;
    }

    public String getDividendDate() {
        return this.dividendDate;
    }

    public String getExDividendDate() {
        return this.exDividendDate;
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

    public void setCompanyRevenueGrowth(String newCompanyCompanyRevenueGrowth) {
        this.companyRevenueGrowth = newCompanyCompanyRevenueGrowth;
    }

    public void setCompanyRevenueGrowthComment(String newCompanyRevenueGrowthComment) {
        this.companyRevenueGrowthComment = newCompanyRevenueGrowthComment;
    }
    public void setCompanyFreeCashFlowMargin(String newCompanyFreeCashFlowMargin) {
        this.companyFreeCashFlowMargin = newCompanyFreeCashFlowMargin;
    }

    public void setCompanyFreeCashFlowMarginComment(String newCompanyFreeCashFlowMarginComment) {
        this.companyFreeCashFlowMarginComment = newCompanyFreeCashFlowMarginComment;
    }
    public void setCompanyFreeCashFlowPerShare(String newCompanyFreeCashFlowPerShare) {
        this.companyFreeCashFlowPerShare = newCompanyFreeCashFlowPerShare;
    }

    public void setCompanyFreeCashFlowPerShareComment(String newCompanyFreeCashFlowPerShareComment) {
        this.companyFreeCashFlowPerShareComment = newCompanyFreeCashFlowPerShareComment;
    }
    public void setCompanyFreeCashFlowYield(String newCompanyFreeCashFlowYield) {
        this.companyFreeCashFlowYield = newCompanyFreeCashFlowYield;
    }
    public void setCompanyFreeCashFlowYieldComment(String newCompanyFreeCashFlowYieldComment) {
        this.companyFreeCashFlowYieldComment = newCompanyFreeCashFlowYieldComment;
    }
    public void setEarningsDate(String earningsDate) {
        this.earningsDate = earningsDate;
    }

    public void setDividendDate(String dividendDate) {
        this.dividendDate = dividendDate;
    }

    public void setExDividendDate(String exDividendDate) {
        this.exDividendDate = exDividendDate;
    }

    public void setCompanyInformation(SearchCompanyOutputData companyFinancialData) {
        this.setCompanyDataFetchTime(companyFinancialData.getCompanyDataFetchTime());
        this.setCompanyEbitdaMargin(companyFinancialData.getCompanyEbitdaMargin());
        this.setCompanyEbitdaMarginComment(companyFinancialData.getCompanyEbitdaMarginComment());
        this.setCompanyDebtToEquity(companyFinancialData.getCompanyDebtToEquity());
        this.setCompanyDebtToEquityComment(companyFinancialData.getCompanyDebtToEquityComment());
        this.setCompanyRevenueGrowth(companyFinancialData.getCompanyRevenueGrowth());
        this.setCompanyRevenueGrowthComment(companyFinancialData.getCompanyRevenueGrowthComment());
        this.setCompanyFreeCashFlowMargin(companyFinancialData.getCompanyFreeCashFlowMargin());
        this.setCompanyFreeCashFlowMarginComment(companyFinancialData.getCompanyFreeCashFlowMarginComment());
        this.setCompanyFreeCashFlowPerShare(companyFinancialData.getCompanyFreeCashFlowPerShare());
        this.setCompanyFreeCashFlowPerShareComment(companyFinancialData.getCompanyFreeCashFlowPerShareComment());
        this.setCompanyFreeCashFlowYield(companyFinancialData.getCompanyFreeCashFlowYield());
        this.setCompanyFreeCashFlowYieldComment(companyFinancialData.getCompanyFreeCashFlowYieldComment());
        this.setEarningsDate(companyFinancialData.getEarningsDate());
        this.setDividendDate(companyFinancialData.getDividendDate());
        this.setExDividendDate(companyFinancialData.getExDividendDate());
    }

    public void setCompanyInformationNull() {
        this.setCompanyDataFetchTime(null);
        this.setCompanyEbitdaMargin(null);
        this.setCompanyEbitdaMarginComment(null);
        this.setCompanyDebtToEquity(null);
        this.setCompanyDebtToEquityComment(null);
        this.setCompanyRevenueGrowth(null);
        this.setCompanyRevenueGrowthComment(null);
        this.setCompanyFreeCashFlowMargin(null);
        this.setCompanyFreeCashFlowMarginComment(null);
        this.setCompanyFreeCashFlowPerShare(null);
        this.setCompanyFreeCashFlowPerShareComment(null);
        this.setCompanyFreeCashFlowYield(null);
        this.setCompanyFreeCashFlowYieldComment(null);
    }
}
