package interface_adapter.SearchCompany;

import java.util.Objects;

public class SearchCompanyState {
    public String companyTicker = "";
    public String companyInformation = "Nothing to show";
    public SearchCompanyState(SearchCompanyState copy) {
        companyTicker = copy.companyTicker;
    }
    public SearchCompanyState() {}

    public String getCompanyTicker() {
        return companyTicker;
    }

    public String getCompanyInformation() {
        return this.companyInformation;
    }

    public void setCompanyTicker(String companyTicker) {
            this.companyTicker = companyTicker;
    }

    public void setCompanyInformation(String newCompanyInformation) {
        if (newCompanyInformation != null) {
            this.companyInformation = newCompanyInformation;
        }
    }
}