package interface_adapter.SettingPage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GlobalFontSizeManager {
    private static GlobalFontSizeManager instance = new GlobalFontSizeManager();
    private int fontSize = 12; // default font size
    private final PropertyChangeSupport support;

    private GlobalFontSizeManager() {
        support = new PropertyChangeSupport(this);
    }

    public static GlobalFontSizeManager getInstance() {
        return instance;
    }

    public void setFontSize(int newFontSize) {
        int oldFontSize = this.fontSize;
        this.fontSize = newFontSize;
        support.firePropertyChange("fontSize", oldFontSize, newFontSize);
    }

    public int getFontSize() {
        return fontSize;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
