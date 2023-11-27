package entities;

public interface CompanyFactory {

    Company create(String symbol, Double revenueGrowth1, Double edibtaMargins, Double debtToEquity, Double freeCashflowMargin, Double freeCashflowPerShare, Double freeCashflowYield);
}
