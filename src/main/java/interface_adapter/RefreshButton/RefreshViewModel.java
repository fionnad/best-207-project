package interface_adapter.RefreshButton;

import interface_adapter.SearchCompany.SearchCompanyState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RefreshViewModel extends ViewModel {

    public RefreshState state = new RefreshState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public String companyInformation = "Please search a company";

    public RefreshViewModel() {
        super("Refresh CSV");
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void setState(RefreshState state) {
        this.state = state;
    }

    public RefreshState getState() {
        return state;
    }

}
