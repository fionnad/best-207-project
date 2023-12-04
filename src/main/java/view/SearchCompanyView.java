package view;

import app.SearchCompanyUseCaseFactory;
import interface_adapter.SearchCompany.SearchCompanyController;
import interface_adapter.SearchCompany.SearchCompanyState;
import interface_adapter.SearchCompany.SearchCompanyViewModel;
import view.Utilities.LabelTextPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchCompanyView extends JPanel implements ActionListener, PropertyChangeListener {
    private final SearchCompanyViewModel searchCompanyViewModel;
    private final JTextField searchCompanyInputField = new JTextField(15);
    private final JButton searchCompanyButton;
    private JPanel informationPresentedPanel;

    public SearchCompanyView(SearchCompanyViewModel newSearchCompanyViewModel) {
        this.searchCompanyViewModel = newSearchCompanyViewModel;
        searchCompanyViewModel.addPropertyChangeListener(this);
        this.informationPresentedPanel = new JPanel();

        // Title Row (1st Row)
        JPanel titleRowPanel = new JPanel();
        JLabel title = new JLabel(SearchCompanyViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleRowPanel.add(title);

        // Search Box Row (2nd Row)
        JPanel searchRowPanel = new JPanel();
        LabelTextPanel companyInfo = new LabelTextPanel(new JLabel(SearchCompanyViewModel.SEARCH_LABEL), searchCompanyInputField);
        searchRowPanel.add(companyInfo);

        // Search Button Row (3rd Row)
        JPanel buttonRowPanel = new JPanel();
        searchCompanyButton = new JButton("Search Company");
        buttonRowPanel.add(searchCompanyButton);

        // Information Presented Row (4th Row)
        JLabel financialData = new JLabel(this.searchCompanyViewModel.getState().getCompanyFrontEndState());
        informationPresentedPanel.add(financialData);

        // Main Panel to Hold All Rows (Nested Panels)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical arrangement
        mainPanel.add(titleRowPanel);
        mainPanel.add(searchRowPanel);
        mainPanel.add(buttonRowPanel);
        mainPanel.add(this.informationPresentedPanel);

        // Adding Main to View
        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.NORTH);

        searchCompanyInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SearchCompanyState currentState = searchCompanyViewModel.getState();
                        currentState.setCompanyTicker(searchCompanyInputField.getText() + e.getKeyChar());
                        searchCompanyViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        searchCompanyButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(searchCompanyButton)) {
                            SearchCompanyController searchCompanyController = SearchCompanyUseCaseFactory.create(searchCompanyViewModel, searchCompanyViewModel.getState().getCompanyTicker());
                            searchCompanyController.execute();
                        }
                    }
                }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ;
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        // Updating informationPresentedPanel with new company information
        informationPresentedPanel.removeAll();
        SearchCompanyState state = (SearchCompanyState) e.getNewValue();
        if (state.getCompanyFrontEndState().equals("Search Complete")) {
            JPanel financialDataPanel = new JPanel(new GridBagLayout());
            JPanel contentPanel = new JPanel(new GridBagLayout());
            EmptyBorder labelInsetsAll = new EmptyBorder(5, 5, 5, 5);

            // Top Left Box, contains basic information about the company
            GridBagConstraints basicInfoBox = new GridBagConstraints();
            basicInfoBox.gridx = 0;
            basicInfoBox.gridy = 0;
            basicInfoBox.anchor = GridBagConstraints.CENTER;
            basicInfoBox.weightx = 1;
            basicInfoBox.weighty = 0.85;
            basicInfoBox.insets = new Insets(10, 10, 10, 10);

            // Top right box, contains information about important past and upcoming dates
            GridBagConstraints datesBox = new GridBagConstraints();
            datesBox.gridx = 1;
            datesBox.gridy = 0;
            datesBox.anchor = GridBagConstraints.CENTER;
            datesBox.weightx = 0.5;
            datesBox.insets = new Insets(10, 10, 10, 10);

            // Middle Box, contains basic metrics about the company
            GridBagConstraints metricsBox = new GridBagConstraints();
            metricsBox.gridx = 0; // Column 1
            metricsBox.gridy = 1; // Row 2
            metricsBox.gridwidth = 2; // Span two columns
            metricsBox.anchor = GridBagConstraints.CENTER;
            metricsBox.weightx = 1.0; // Full width
            metricsBox.insets = new Insets(10, 10, 10, 10);

            // Bottom Box, contains additional company metrics
            GridBagConstraints additionalMetricsBox = new GridBagConstraints();
            additionalMetricsBox.gridx = 0;
            additionalMetricsBox.gridy = 2;
            additionalMetricsBox.gridwidth = 2;
            additionalMetricsBox.anchor = GridBagConstraints.CENTER;
            additionalMetricsBox.weightx = 1.0;
            additionalMetricsBox.insets = new Insets(10, 10, 10, 10);

            // Updating Top Left Box (basicInfoBox)
            JLabel currentPrice = createLabelWithText("Current Price", state.getCompanyCurrentPrice());
            currentPrice.setBorder(labelInsetsAll);
            JLabel totalSharesOutstanding = createLabelWithText("Total Shares Outstanding", state.getCompanyTotalSharesOutstanding());
            totalSharesOutstanding.setBorder(labelInsetsAll);
            JLabel marketCapitalization = createLabelWithText("Market Capitalization", state.getCompanyMarketCapitalization());
            marketCapitalization.setBorder(labelInsetsAll);

            JPanel basicInfoPanel = new JPanel(new GridLayout(0, 1));
            basicInfoPanel.setBorder(BorderFactory.createTitledBorder("Basic Company Information"));
            TitledBorder titledBorderInfo = (TitledBorder) basicInfoPanel.getBorder();
            titledBorderInfo.setTitleJustification(TitledBorder.CENTER);

            basicInfoPanel.add(currentPrice);
            basicInfoPanel.add(totalSharesOutstanding);
            basicInfoPanel.add(marketCapitalization);

            // Updating Top Right Box (datesBox)
            JLabel earningsDateLabel = createLabelWithText("Next Earnings Release", state.getEarningsDate());
            earningsDateLabel.setBorder(labelInsetsAll);
            JLabel exDividendDateLabel = createLabelWithText("Previous Dividend Release", state.getExDividendDate());
            exDividendDateLabel.setBorder(labelInsetsAll);
            JLabel dividendDateLabel = createLabelWithText("Closest Dividend Release", state.getDividendDate());
            dividendDateLabel.setBorder(labelInsetsAll);

            JPanel datesPanel = new JPanel(new BorderLayout());
            datesPanel.setBorder(BorderFactory.createTitledBorder("Important Dates"));
            TitledBorder titledBorderDates = (TitledBorder) datesPanel.getBorder();
            titledBorderDates.setTitleJustification(TitledBorder.CENTER);
            JPanel datesInfoPanel = new JPanel(new GridLayout(0, 1));
            datesInfoPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            datesInfoPanel.add(earningsDateLabel);
            datesInfoPanel.add(dividendDateLabel);
            datesInfoPanel.add(exDividendDateLabel);

            datesPanel.add(datesInfoPanel, BorderLayout.CENTER);

            // Updating Middle Box (metricsBox)
            JLabel ebitdaMarginLabel = createLabelWithText("EBITDA Margin", state.getCompanyEbitdaMargin());
            ebitdaMarginLabel.setBorder(labelInsetsAll);
            JLabel ebitdaMarginCommentLabel = createLabelWithText("Comment", state.getCompanyEbitdaMarginComment());
            ebitdaMarginCommentLabel.setBorder(labelInsetsAll);

            JLabel debtToEquityLabel = createLabelWithText("Debt to Equity", state.getCompanyDebtToEquity());
            debtToEquityLabel.setBorder(labelInsetsAll);
            JLabel debtToEquityCommentLabel = createLabelWithText("Comment", state.getCompanyDebtToEquityComment());
            debtToEquityCommentLabel.setBorder(labelInsetsAll);

            JLabel revenueGrowthLabel = createLabelWithText("Revenue Growth", state.getCompanyRevenueGrowth());
            revenueGrowthLabel.setBorder(labelInsetsAll);
            JLabel revenueGrowthCommentLabel = createLabelWithText("Comment", state.getCompanyRevenueGrowthComment());
            revenueGrowthCommentLabel.setBorder(labelInsetsAll);

            JPanel metricsPanel = new JPanel(new GridLayout(0, 1));
            metricsPanel.setBorder(BorderFactory.createTitledBorder("Company Metrics"));
            TitledBorder titledBorderMetrics = (TitledBorder) metricsPanel.getBorder();
            titledBorderMetrics.setTitleJustification(TitledBorder.CENTER);

            metricsPanel.add(ebitdaMarginLabel);
            metricsPanel.add(ebitdaMarginCommentLabel);
            metricsPanel.add(debtToEquityLabel);
            metricsPanel.add(debtToEquityCommentLabel);
            metricsPanel.add(revenueGrowthLabel);
            metricsPanel.add(revenueGrowthCommentLabel);

            // Updating Bottom Box
            JLabel freeCashFlowMarginLabel = createLabelWithText("FCF Margin", state.getCompanyFreeCashFlowMargin());
            freeCashFlowMarginLabel.setBorder(labelInsetsAll);
            JLabel freeCashFlowMarginCommentLabel = createLabelWithText("FCF Comments", state.getCompanyFreeCashFlowMarginComment());
            freeCashFlowMarginCommentLabel.setBorder(labelInsetsAll);
            JLabel freeCashFlowPerShareLabel = createLabelWithText("FCF Per Share", state.getCompanyFreeCashFlowPerShare());
            freeCashFlowPerShareLabel.setBorder(labelInsetsAll);
            JLabel freeCashFlowPerShareCommentLabel = createLabelWithText("FCF Comment", state.getCompanyFreeCashFlowPerShareComment());
            freeCashFlowPerShareCommentLabel.setBorder(labelInsetsAll);
            JLabel freeCashFlowYieldLabel = createLabelWithText("FCF Yield", state.getCompanyFreeCashFlowYield());
            freeCashFlowYieldLabel.setBorder(labelInsetsAll);
            JLabel freeCashFlowYieldCommentLabel = createLabelWithText("FCF Comment", state.getCompanyFreeCashFlowYieldComment());
            freeCashFlowYieldCommentLabel.setBorder(labelInsetsAll);

            JPanel additionalMetricsPanel = new JPanel(new GridLayout(0, 1));
            additionalMetricsPanel.setBorder(BorderFactory.createTitledBorder("Free Cash Flow Analysis"));
            TitledBorder titledBorderAdditionalMetrics = (TitledBorder) additionalMetricsPanel.getBorder();
            titledBorderAdditionalMetrics.setTitleJustification(TitledBorder.CENTER);

            additionalMetricsPanel.add(freeCashFlowMarginLabel);
            additionalMetricsPanel.add(freeCashFlowMarginCommentLabel);
            additionalMetricsPanel.add(freeCashFlowPerShareLabel);
            additionalMetricsPanel.add(freeCashFlowPerShareCommentLabel);
            additionalMetricsPanel.add(freeCashFlowYieldLabel);
            additionalMetricsPanel.add(freeCashFlowYieldCommentLabel);

            // Adding all panels to main panel
            contentPanel.add(basicInfoPanel, basicInfoBox);
            contentPanel.add(datesPanel, datesBox);
            contentPanel.add(metricsPanel, metricsBox);
            contentPanel.add(additionalMetricsPanel, additionalMetricsBox);
            financialDataPanel.add(contentPanel);

            // Reflecting changes to the Front End
            informationPresentedPanel.add(financialDataPanel);
            informationPresentedPanel.revalidate();
            informationPresentedPanel.repaint();

            // Show the dialog only if there is a change in company's frontend state
            if (!state.getCompanyFrontEndState().equals("Nothing to show")) {
                JOptionPane.showMessageDialog(this, state.getCompanyFrontEndState());
            }
        } else {
            JLabel financialData = new JLabel(state.getCompanyFrontEndState());
            informationPresentedPanel.add(financialData);
        }
    }
    private JLabel createLabelWithText(String labelText, String value) {
        return new JLabel(labelText + ": " + value);
    }
}