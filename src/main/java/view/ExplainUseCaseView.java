package view;

import interface_adapter.ExplainUseCase.ExplainUseCaseViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExplainUseCaseView extends JPanel {
    private final ExplainUseCaseViewModel explainUseCaseViewModel;

    public ExplainUseCaseView(ExplainUseCaseViewModel explainUseCaseViewModel) {
        this.explainUseCaseViewModel = explainUseCaseViewModel;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(ExplainUseCaseViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        // Upper Button Panel
        JPanel upperButtonPanel = new JPanel();
        upperButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton debtButton = new JButton("Debt");
        debtButton.addActionListener(e -> showDefinition("Debt", "Debt is something one party owes to another."));
        JButton equityButton = new JButton("Equity");
        equityButton.addActionListener(e -> showDefinition("Equity", "Equity represents the value that would be returned to shareholders if all assets were liquidated."));
        upperButtonPanel.add(debtButton);
        upperButtonPanel.add(equityButton);

        // Lower Button Panel
        JPanel lowerButtonPanel = new JPanel();
        lowerButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton debtToEquityButton = new JButton("Debt to Equity");
        debtToEquityButton.addActionListener(e -> showDefinition("Debt to Equity", "Debt to Equity ratio indicates the relative proportion of equity and debt used to finance a company's assets."));
        JButton ebitdaMarginButton = new JButton("EBITDA Margin");
        ebitdaMarginButton.addActionListener(e -> showDefinition("EBITDA Margin", "EBITDA Margin is a measure of a company's operating profit as a percentage of its revenue."));
        lowerButtonPanel.add(debtToEquityButton);
        lowerButtonPanel.add(ebitdaMarginButton);

        // Adding Button Panels to Main Panel
        add(upperButtonPanel);
        add(lowerButtonPanel);
    }

    private void showDefinition(String term, String definition) {
        JOptionPane.showMessageDialog(this, definition, term + " Definition", JOptionPane.INFORMATION_MESSAGE);
    }
}