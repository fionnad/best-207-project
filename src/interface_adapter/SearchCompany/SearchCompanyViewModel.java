package interface_adapter.SearchCompany;

import interface_adapter.ViewModel;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchCompanyViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Search a Company's Financial Data:";
    public static final String SEARCH_LABEL = "Find:";
    private SearchCompanyState state = new SearchCompanyState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public static final String DISPLAY_INFORMATION = "Please search a company";

    public SearchCompanyViewModel() {
        super("Company Financial Data Search Page");
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void setState(SearchCompanyState state) {
        this.state = state;
        firePropertyChanged();
    }

    public SearchCompanyState getState() {
        return state;
    }

}
