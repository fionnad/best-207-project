package interface_adapter.SettingPage;

public class SettingPageState {
    private int fontSize;

    public SettingPageState() {
        this.fontSize = getDefaultFontSize();
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    private int getDefaultFontSize() {
        return 12; // Placeholder value
    }
}
