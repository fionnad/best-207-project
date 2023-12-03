package interface_adapter.SettingPage;

import interface_adapter.SettingPage.SettingPageState;
import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SettingPageViewModel extends ViewModel {
    private SettingPageState state = new SettingPageState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SettingPageViewModel() {
        super("Settings");
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void setState(SettingPageState state) {
        this.state = state;
        firePropertyChanged();
    }

    public SettingPageState getState() {
        return state;
    }

    // The method signatures for increasing and decreasing the font size
    // would be implemented here, calling the interactor and updating the state.
}
