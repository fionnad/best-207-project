package interface_adapter.RefreshButton;

import interface_adapter.SearchCompany.SearchCompanyState;
import interface_adapter.SettingPage.GlobalFontSizeManager;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RefreshViewModel extends ViewModel {
    public static final String REFRESH_BUTTON_LABEL = "Refresh";
    public static final String TITLE_LABEL = "Top Companies";
    public RefreshState state = new RefreshState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public RefreshViewModel() {
        super("Ranking");
        GlobalFontSizeManager.getInstance().addPropertyChangeListener(evt -> {
            if ("fontSize".equals(evt.getPropertyName())) {
                firePropertyChanged(); // Notify the view to update
            }
        });
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
