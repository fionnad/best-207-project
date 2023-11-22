package entities;

public class CompanyDataFactory implements CompanyFactory{
    @Override
    public CompanyData create(String symbol, Float revenueGrowth, Float ebidta, Float debtToEquity, Float freeCashflowMargin, Float freeCashflowPerShare, Float freeCashflowYield) {
        return new CompanyData(symbol, revenueGrowth, ebidta, debtToEquity, freeCashflowMargin, freeCashflowPerShare, freeCashflowYield);
    }
}
