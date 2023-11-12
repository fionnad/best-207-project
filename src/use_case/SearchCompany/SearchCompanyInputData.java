package use_case.SearchCompany;

public class SearchCompanyInputData {
    final private String ticker;

    public SearchCompanyInputData(String ticker) {
        this.ticker = ticker;
    }

    public String getTicker() {
        return ticker;
    }
}
