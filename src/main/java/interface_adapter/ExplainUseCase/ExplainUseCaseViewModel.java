package interface_adapter.ExplainUseCase;

import interface_adapter.SettingPage.GlobalFontSizeManager;
import interface_adapter.ViewModel;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ExplainUseCaseViewModel extends ViewModel {
    public ExplainUseCaseState state = new ExplainUseCaseState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ExplainUseCaseViewModel() {
        super("Financial Terminology Definitions");
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void setState(ExplainUseCaseState state) {
        this.state = state;
        GlobalFontSizeManager.getInstance().addPropertyChangeListener(evt -> {
            if ("fontSize".equals(evt.getPropertyName())) {
                firePropertyChanged(); // Notify the view to update
            }
        });
    }

    public ExplainUseCaseState getState() {
        return state;
    }
}
