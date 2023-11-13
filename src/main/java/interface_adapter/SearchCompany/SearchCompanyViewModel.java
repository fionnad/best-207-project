package interface_adapter.SearchCompany;

import interface_adapter.ViewModel;

import javax.swing.*;

public class SearchCompanyViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Search a Company's Financial Data:";
    public static final String SEARCH_LABEL = "Find:";

    private SearchCompanyState state = new SearchCompanyState();

    public SearchCompanyViewModel() {
        super("Company Financial Data Search Page");
    }

    public void setState(SearchCompanyState state) {
        this.state = state;
    }

    public SearchCompanyState getState() {
        return state;
    }
}
