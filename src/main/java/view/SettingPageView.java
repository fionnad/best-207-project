package view;

import interface_adapter.SettingPage.SettingPageViewModel;
import interface_adapter.SettingPage.SettingPageState;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SettingPageView extends JPanel implements PropertyChangeListener {
    private final SettingPageViewModel settingPageViewModel;
    private final JLabel fontSizeDisplayLabel = new JLabel("Current Font Size: ", JLabel.CENTER);
    private final JButton increaseFontSizeButton = new JButton("Increase Font Size");
    private final JButton decreaseFontSizeButton = new JButton("Decrease Font Size");

    public SettingPageView(SettingPageViewModel viewModel) {
        this.settingPageViewModel = viewModel;
        viewModel.addPropertyChangeListener(this);
        setLayout(new BorderLayout());
        initializeUI();
        updateFontSizeDisplay();
    }

    private void initializeUI() {
        setupFontSizeButtons();
        add(fontSizeDisplayLabel, BorderLayout.NORTH);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private void setupFontSizeButtons() {
        increaseFontSizeButton.addActionListener(e -> {
            settingPageViewModel.getState().setFontSize(
                    settingPageViewModel.getState().getFontSize() + 1
            );
            settingPageViewModel.firePropertyChanged();
        });

        decreaseFontSizeButton.addActionListener(e -> {
            settingPageViewModel.getState().setFontSize(
                    settingPageViewModel.getState().getFontSize() - 1
            );
            settingPageViewModel.firePropertyChanged();
        });
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(increaseFontSizeButton);
        buttonPanel.add(decreaseFontSizeButton);
        return buttonPanel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            updateFontSizeDisplay();
        }
    }

    private void updateFontSizeDisplay() {
        SettingPageState state = settingPageViewModel.getState();
        fontSizeDisplayLabel.setText("Current Font Size: " + state.getFontSize());
    }
}
