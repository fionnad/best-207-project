package entities;

public class CompanyData {
    private final boolean isValidCompany;
    private final String ticker;
    private final String timeFetched;
    private final Double currentPrice; // Variable in marketCapitalization
    private final Long freeCashFlow; // Variable in freeCashFlowMargin, freeCashFlowPerShare, freeCashFlowYield
    private final Long totalRevenue; // Variable in freeCashFlowMargin, totalSharesOutstanding
    private final Double revenuePerShare; // Variable in totalSharesOutstanding
    private final Double totalSharesOutstanding; // Variable in freeCashFlowPerShare, marketCapitalization
    private final Double marketCapitalization; // Variable in freeCashFlowYield
    private final Double ebitdaMargins;
    private final String ebitdaMarginsAnalysis;
    private final Double debtToEquity;
    private final String debtToEquityAnalysis;
    private final Double revenueGrowth;
    private final String revenueGrowthAnalysis;
    private final Double freeCashFlowMargin;
    private final String freeCashFlowMarginAnalysis;
    private final Double freeCashFlowPerShare;
    private final String freeCashFlowPerShareAnalysis;
    private final Double freeCashFlowYield;
    private final String freeCashFlowYieldAnalysis;


    public CompanyData(boolean isValidCompany, String ticker, String timeFetched, Double currentPrice,
                       Long freeCashFlow, Long totalRevenue, Double revenuePerShare, Double totalSharesOutstanding,
                       Double marketCapitalization, Double ebitdaMargins, String ebitdaMarginsAnalysis,
                       Double debtToEquity, String debtToEquityAnalysis, Double revenueGrowth,
                       String revenueGrowthAnalysis, Double freeCashFlowMargin, String freeCashFlowMarginAnalysis,
                       Double freeCashFlowPerShare, String freeCashFlowPerShareAnalysis, Double freeCashFlowYield,
                       String freeCashFlowYieldAnalysis) {
        this.isValidCompany = isValidCompany;
        this.ticker = ticker;
        this.timeFetched = timeFetched;
        this.currentPrice = currentPrice;
        this.freeCashFlow = freeCashFlow;
        this.totalRevenue = totalRevenue;
        this.revenuePerShare = revenuePerShare;
        this.totalSharesOutstanding = totalSharesOutstanding;
        this.marketCapitalization = marketCapitalization;
        this.ebitdaMargins = ebitdaMargins;
        this.ebitdaMarginsAnalysis = ebitdaMarginsAnalysis;
        this.debtToEquity = debtToEquity;
        this.debtToEquityAnalysis = debtToEquityAnalysis;
        this.revenueGrowth = revenueGrowth;
        this.revenueGrowthAnalysis = revenueGrowthAnalysis;
        this.freeCashFlowMargin = freeCashFlowMargin;
        this.freeCashFlowMarginAnalysis = freeCashFlowMarginAnalysis;
        this.freeCashFlowPerShare = freeCashFlowPerShare;
        this.freeCashFlowPerShareAnalysis = freeCashFlowPerShareAnalysis;
        this.freeCashFlowYield = freeCashFlowYield;
        this.freeCashFlowYieldAnalysis = freeCashFlowYieldAnalysis;
    }

    // Getters for fields
    public boolean isValidCompany() {
        return isValidCompany;
    }

    public String getTicker() {
        return ticker;
    }

    public String getTimeFetched() {
        return timeFetched;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public Long getFreeCashFlow() {
        return freeCashFlow;
    }

    public Long getTotalRevenue() {
        return totalRevenue;
    }

    public Double getRevenuePerShare() {
        return revenuePerShare;
    }

    public Double getTotalSharesOutstanding() {
        return totalSharesOutstanding;
    }

    public Double getMarketCapitalization() {
        return marketCapitalization;
    }

    public Double getEbitdaMargins() {
        return ebitdaMargins;
    }

    public String getEbitdaMarginsAnalysis() {
        return ebitdaMarginsAnalysis;
    }

    public Double getDebtToEquity() {
        return debtToEquity;
    }

    public String getDebtToEquityAnalysis() {
        return debtToEquityAnalysis;
    }

    public Double getRevenueGrowth() {
        return revenueGrowth;
    }

    public String getRevenueGrowthAnalysis() {
        return revenueGrowthAnalysis;
    }

    public Double getFreeCashFlowMargin() {
        return freeCashFlowMargin;
    }

    public String getFreeCashFlowMarginAnalysis() {
        return freeCashFlowMarginAnalysis;
    }

    public Double getFreeCashFlowPerShare() {
        return freeCashFlowPerShare;
    }

    public String getFreeCashFlowPerShareAnalysis() {
        return freeCashFlowPerShareAnalysis;
    }

    public Double getFreeCashFlowYield() {
        return freeCashFlowYield;
    }

    public String getFreeCashFlowYieldAnalysis() {
        return freeCashFlowYieldAnalysis;
    }

    public Double[] getAllFinData() {
        try {
            return new Double[]{
                    currentPrice, freeCashFlow * 1.0, totalRevenue * 1.0, revenuePerShare,
                    totalSharesOutstanding, marketCapitalization, ebitdaMargins, debtToEquity,
                    revenueGrowth, freeCashFlowMargin, freeCashFlowPerShare, freeCashFlowYield
            };
        } catch (NullPointerException e) {
            return new Double[]{
                    currentPrice, null, null, revenuePerShare,
                    totalSharesOutstanding, marketCapitalization, ebitdaMargins, debtToEquity,
                    revenueGrowth, freeCashFlowMargin, freeCashFlowPerShare, freeCashFlowYield
            };
        }
    }

}
