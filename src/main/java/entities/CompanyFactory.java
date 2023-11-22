package entities;

public interface CompanyFactory {

    Company create(String symbol, Float marketcap);
}
