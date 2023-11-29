package data_access;

import entities.CompanyData;
import entities.CompanyDataFactory;
import use_case.SearchCompany.SearchCompanyDataAccessInterface;

public class SearchCompanyDataAccessObject implements SearchCompanyDataAccessInterface {

    public final String ticker;
    public SearchCompanyDataAccessObject(String ticker) {
        this.ticker = ticker;
    }

    @Override
    public CompanyData getCompanyData() {
        return CompanyDataFactory.execute(this.ticker);
    }
}
