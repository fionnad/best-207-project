package interface_adapter.SettingPage;

import use_case.SettingPage.SettingPageInteractor;

public class SettingPageController {
    private final SettingPageInteractor settingPageInteractor;
    private final SettingPageViewModel settingPageViewModel;

    public SettingPageController(SettingPageViewModel settingPageViewModel, SettingPageInteractor settingPageInteractor) {
        this.settingPageViewModel = settingPageViewModel;
        this.settingPageInteractor = settingPageInteractor;
    }

    public void increaseFontSize() {
        settingPageInteractor.increaseFontSize();
        settingPageViewModel.setFontSize(settingPageInteractor.getFontSize());
    }

    public void decreaseFontSize() {
        settingPageInteractor.decreaseFontSize();
        settingPageViewModel.setFontSize(settingPageInteractor.getFontSize());
    }
}
