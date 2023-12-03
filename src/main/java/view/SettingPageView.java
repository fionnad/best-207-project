package view;

import interface_adapter.SettingPage.GlobalFontSizeManager;
import interface_adapter.SettingPage.SettingPageViewModel;
import interface_adapter.SettingPage.SettingPageState;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SettingPageView extends JPanel {
    private final SettingPageViewModel settingPageViewModel;
    private final JLabel fontSizeDisplayLabel = new JLabel("Current Font Size: ", JLabel.CENTER);
    private final JButton increase;
    private final JButton decrease;

    public SettingPageView(SettingPageViewModel settingPageViewModel) {
        this.settingPageViewModel = settingPageViewModel;
        settingPageViewModel.addPropertyChangeListener(e -> SwingUtilities.invokeLater(this::updateFontSizeDisplay));

        increase = new JButton(SettingPageViewModel.INCREASE_BUTTON_LABEL);
        decrease = new JButton(SettingPageViewModel.DECREASE_BUTTON_LABEL);
        increase.addActionListener(e -> settingPageViewModel.increaseFontSize());
        decrease.addActionListener(e -> settingPageViewModel.decreaseFontSize());

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(fontSizeDisplayLabel);
        add(increase);
        add(decrease);

        updateFontSizeDisplay();
    }

    private void updateFontSizeDisplay() {
        SettingPageState state = settingPageViewModel.getState();
        fontSizeDisplayLabel.setText("Current Font Size: " + state.getFontSize());
        updateUIFontSize(state.getFontSize());
    }

    private void updateUIFontSize(int newSize) {
        Font newFont = new Font(getFont().getName(), getFont().getStyle(), newSize);
        fontSizeDisplayLabel.setFont(newFont);
        increase.setFont(newFont);
        decrease.setFont(newFont);
    }
    public void actionPerformed(ActionEvent e) {
        int currentSize = GlobalFontSizeManager.getInstance().getFontSize();
        if (e.getSource() == increase) {
            GlobalFontSizeManager.getInstance().setFontSize(currentSize + 1);
        } else if (e.getSource() == decrease) {
            GlobalFontSizeManager.getInstance().setFontSize(currentSize - 1);
        }
    }

}
