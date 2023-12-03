package interface_adapter.SettingPage;

import javax.swing.event.SwingPropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class SettingPageViewModel {
    public static final String INCREASE_BUTTON_LABEL = "Increase Font Size";
    public static final String DECREASE_BUTTON_LABEL = "Decrease Font Size";
    private static final int DEFAULT_FONT_SIZE = 12; // Set a default font size

    private final SwingPropertyChangeSupport propertyChangeSupport;
    private SettingPageState state;

    public SettingPageViewModel() {
        this.state = new SettingPageState(DEFAULT_FONT_SIZE);
        this.propertyChangeSupport = new SwingPropertyChangeSupport(this);
    }

    public void increaseFontSize() {
        int currentSize = state.getFontSize();
        state.setFontSize(currentSize + 1);
        propertyChangeSupport.firePropertyChange("fontSize", currentSize, currentSize + 1);
    }

    public void decreaseFontSize() {
        int currentSize = state.getFontSize();
        state.setFontSize(currentSize - 1);
        propertyChangeSupport.firePropertyChange("fontSize", currentSize, currentSize - 1);
    }

    public SettingPageState getState() {
        return state;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    public void setFontSize(int newFontSize) {
        int currentSize = state.getFontSize();
        state.setFontSize(newFontSize);
        propertyChangeSupport.firePropertyChange("fontSize", currentSize, newFontSize);
    }

}
