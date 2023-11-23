package entities;

public class CompanyData implements Company {
    private final String symbol;

    private final Double revenueGrowth;

    private final Double ebidta;

    private final Double debtToEquity;

    private final Double freeCashflowMargin;

    private final Double freeCashflowPerShare;

    private final Double freeCashflowYield;







    public CompanyData(String symbol, Double revenueGrowth, Double ebidta, Double debtToEquity, Double freeCashflowMargin, Double freeCashflowPerShare, Double freeCashflowYield) {
        this.symbol = symbol;
        this.revenueGrowth = revenueGrowth;
        this.ebidta = ebidta;
        this.debtToEquity = debtToEquity;
        this.freeCashflowMargin = freeCashflowMargin;
        this.freeCashflowPerShare = freeCashflowPerShare;
        this.freeCashflowYield = freeCashflowYield;



    }
    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public Double getRevenueGrowth() {
        return revenueGrowth;
    }

    @Override
    public Double getEbidtaMargins() {
        return ebidta;
    }

    @Override
    public Double getDebtToEquity() {
        return debtToEquity;
    }

    @Override
    public Double getFreeCashflowMargin() {
        return freeCashflowMargin;
    }

    @Override
    public Double getFreeCashflowPerShare() {
        return freeCashflowPerShare;
    }

    @Override
    public Double getFreeCashflowYield() {
        return freeCashflowYield;
    }

    public Double[] getAllFinData() {
       Double[] allFinData = {revenueGrowth, ebidta, debtToEquity, freeCashflowMargin, freeCashflowPerShare, freeCashflowYield};
       return allFinData;
    }


}
