package interface_adapter.SearchCompany;

public class SearchCompanyState {
    public String companyTicker = "";

    public SearchCompanyState(SearchCompanyState copy) {
        companyTicker = copy.companyTicker;
    }
    public SearchCompanyState() {}

    public String getCompanyTicker() {
        return companyTicker;
    }

    public void setCompanyTicker(String companyTicker) {
            this.companyTicker = companyTicker;
    }
}