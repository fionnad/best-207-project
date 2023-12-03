package interface_adapter.SettingPage;

public class SettingPageState {
    private int fontSize;

    public SettingPageState(int fontSize) {
        this.fontSize = fontSize;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}
