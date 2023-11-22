package entities;

public class CompanyData implements Company {
    private final String symbol;
    private final Float marketcap;
    public CompanyData(String symbol, Float marketcap) {
        this.symbol = symbol;
        this.marketcap = marketcap;
    }
    @Override
    public String getSymbol() {
        return symbol;
    }
    @Override
    public Float getMarketcap() {
        return marketcap;
    }
}
