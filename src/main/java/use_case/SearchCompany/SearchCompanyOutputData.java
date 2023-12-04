package use_case.SearchCompany;

import data_access.NumberFormatterService;
import entities.CompanyData;

import java.text.DecimalFormat;

public class SearchCompanyOutputData {
    public String ticker;
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
    public String companyEarningsDate; // Updated variable name for earnings date
    public String companyDividendDate; // Updated variable name for dividend date
    public String companyExDividendDate; // Updated variable name for ex-dividend date
    public String companyCurrentPrice; // Added variable for current price
    public String companyTotalSharesOutstanding; // Added variable for total shares outstanding
    public String companyMarketCapitalization;

    public SearchCompanyOutputData(CompanyData companyFinancialData) {
        this.ticker = companyFinancialData.getTicker();
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
        this.companyEarningsDate = validator(companyFinancialData.getEarningsDate());
        this.companyDividendDate = validator(companyFinancialData.getDividendDate());
        this.companyExDividendDate = validator(companyFinancialData.getExDividendDate());
        this.companyCurrentPrice = validator(companyFinancialData.getCurrentPrice());
        this.companyTotalSharesOutstanding = validator(companyFinancialData.getTotalSharesOutstanding());
        this.companyMarketCapitalization = validator(companyFinancialData.getMarketCapitalization());
    }

    public String validator(Object object) {
        if (object == null) {
            return "No data";
        } else if (object instanceof Number) {
            return NumberFormatterService.formatNumber(object);
        } else {
            return object.toString();
        }
    }

    public String getTicker() {
        return this.ticker;
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
        return this.companyEarningsDate;
    }

    public String getDividendDate() {
        return this.companyDividendDate;
    }

    public String getExDividendDate() {
        return this.companyExDividendDate;
    }

    public String getCompanyCurrentPrice() {
        return this.companyCurrentPrice;
    }

    public String getCompanyTotalSharesOutstanding() {
        return this.companyTotalSharesOutstanding;
    }

    public String getCompanyMarketCapitalization() {
        return this.companyMarketCapitalization;
    }
}
