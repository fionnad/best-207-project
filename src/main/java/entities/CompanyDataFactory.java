package entities;

public class CompanyDataFactory implements CompanyFactory{
    @Override
    public CompanyData create(String symbol, Double revenueGrowth, Double ebidtaMargins, Double debtToEquity, Double freeCashflowMargin, Double freeCashflowPerShare, Double freeCashflowYield) {
        return new CompanyData(symbol, revenueGrowth, ebidtaMargins, debtToEquity, freeCashflowMargin, freeCashflowPerShare, freeCashflowYield);
    }
}
