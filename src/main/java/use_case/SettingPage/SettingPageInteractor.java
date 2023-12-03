package use_case.SettingPage;

public class SettingPageInteractor {

    // Presuming there's a mechanism to store and retrieve the font size
    // For example, this could be a preference system, database, or in-memory state
    private int fontSize;

    public SettingPageInteractor() {
        this.fontSize = retrieveInitialFontSize();
    }

    public void increaseFontSize() {
        fontSize++;
        applyFontSizeChange(fontSize);
    }

    public void decreaseFontSize() {
        fontSize--;
        applyFontSizeChange(fontSize);
    }

    public int getInitialFontSize() {
        // This method should return the actual initial font size
        // For now, returning a placeholder value
        return fontSize;
    }

    private void applyFontSizeChange(int newFontSize) {
        // Here we would have logic to change the font size in the application
        // This might involve updating a configuration file, database, or directly applying to the UI components
        // For example:
        // updateApplicationFontSize(newFontSize);
    }

    private int retrieveInitialFontSize() {
        return 12; // Default value
    }
}
