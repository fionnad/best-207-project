package entities;

public class CompanyData implements Company {
    private final String symbol;

    private final Float revenueGrowth;

    private final Float ebidta;

    private final Float debtToEquity;

    private final Float freeCashflowMargin;

    private final Float freeCashflowPerShare;

    private final Float freeCashflowYield;





    public CompanyData(String symbol, Float revenueGrowth, Float ebidta, Float debtToEquity, Float freeCashflowMargin, Float freeCashflowPerShare, Float freeCashflowYield) {
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
    public Float getRevenueGrowth() {
        return revenueGrowth;
    }

    @Override
    public Float getEbidta() {
        return ebidta;
    }

    @Override
    public Float getDebtToEquity() {
        return debtToEquity;
    }

    @Override
    public Float getFreeCashflowMargin() {
        return freeCashflowMargin;
    }

    @Override
    public Float getFreeCashflowPerShare() {
        return freeCashflowPerShare;
    }

    @Override
    public Float getFreeCashflowYield() {
        return freeCashflowYield;
    }


}
