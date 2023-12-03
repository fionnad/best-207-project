package use_case.SettingPage;

public class SettingPageInteractor {
    private static final int DEFAULT_FONT_SIZE = 12;
    private int fontSize;

    public SettingPageInteractor() {
        this.fontSize = DEFAULT_FONT_SIZE; // Or load this from a persistent storage
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
        // Persist the font size change here if necessary
    }

    public void increaseFontSize() {
        setFontSize(getFontSize() + 1);
    }

    public void decreaseFontSize() {
        setFontSize(getFontSize() - 1);
    }
}
