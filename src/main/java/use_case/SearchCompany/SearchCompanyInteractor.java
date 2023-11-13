package use_case.SearchCompany;

import java.io.IOException;

public class SearchCompanyInteractor implements SearchCompanyInputBoundary {
    final String ticker;

    public SearchCompanyInteractor(String ticker) {
        this.ticker = ticker;
    }

    public void execute() {
        SearchCompanyDataAccessInterface searchCompanyDataAccessInterface = new SearchCompanyDataAccessInterface(this.ticker);
        System.out.println(searchCompanyDataAccessInterface.getFinData());
    }

    public boolean validateCompany() {
        return true;
    };
}
