package view;

import interface_adapter.ExplainUseCase.ExplainUseCaseViewModel;
import interface_adapter.FirstPage.FirstPageViewModel;

import javax.swing.*;
import java.awt.*;

public class ExplainUseCaseView extends JPanel {
    private final ExplainUseCaseViewModel explainUseCaseViewModel;
    private final JTextField financialTermsDefnition = new JTextField(15);


    public ExplainUseCaseView(ExplainUseCaseViewModel explainUseCaseViewModel) {
        this.explainUseCaseViewModel = explainUseCaseViewModel;

        JLabel title = new JLabel(ExplainUseCaseViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        // Button for each term
        JPanel debtButton = new JPanel();
        JButton financialTerms = new JButton("Debt");
        debtButton.add(financialTerms);

        JPanel equityButton = new JPanel();
        JButton financialTerms2 = new JButton("Equity");
        equityButton.add(financialTerms2);

        JPanel deButton = new JPanel();
        JButton financialTerms3 = new JButton("Debt to Equity");
        deButton.add(financialTerms3);

        JPanel ebitdaButton = new JPanel();
        JButton financialTerms4 = new JButton("EBITDA Margin");
        ebitdaButton.add(financialTerms4);

        // Main Panel to Hold All Rows (Nested Panels)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical arrangement
//        mainPanel.add(titleRowPanel);
//        mainPanel.add(searchRowPanel);
        mainPanel.add(debtButton);
        mainPanel.add(equityButton);
        mainPanel.add(deButton);
        mainPanel.add(ebitdaButton);
//        mainPanel.add(this.informationPresentedPanel);

        // Adding Main to View
        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.NORTH);




        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


    }
}