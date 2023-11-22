package entities;

public class CompanyDataFactory implements CompanyFactory{
    @Override
    public CompanyData create(String symbol, Float marketcap) {
        return new CompanyData(symbol, marketcap);
    }
}
