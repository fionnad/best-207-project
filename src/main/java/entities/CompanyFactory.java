package entities;

public interface CompanyFactory {

    Company create(String symbol, Float revenueGrowth1, Float edibta, Float debtToEquity, Float freeCashflowMargin, Float freeCashflowPerShare, Float freeCashflowYield);
}
