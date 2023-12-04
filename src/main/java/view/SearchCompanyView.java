package view;

import app.SearchCompanyUseCaseFactory;
import interface_adapter.SearchCompany.SearchCompanyController;
import interface_adapter.SearchCompany.SearchCompanyState;
import interface_adapter.SearchCompany.SearchCompanyViewModel;
import view.Utilities.LabelTextPanel;

import javax.swing.*;
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
        System.out.println(state.getCompanyFrontEndState());
        if (state.getCompanyFrontEndState().equals("Search Complete")) {
            JPanel financialDataPanel = new JPanel(new GridBagLayout());
            JPanel contentPanel = new JPanel(new GridBagLayout());

            // Top Left Box, contains basic information about the company
            GridBagConstraints basicInfoBox = new GridBagConstraints();
            basicInfoBox.gridx = 0;
            basicInfoBox.gridy = GridBagConstraints.RELATIVE;
            basicInfoBox.anchor = GridBagConstraints.NORTHWEST;
            basicInfoBox.weightx = 0.4;
            basicInfoBox.insets = new Insets(10, 10, 10, 10);
            JLabel currentTime = createLabelWithText("True As Of", state.getCompanyDataFetchTime());
            JLabel currentPrice = createLabelWithText("Current Price", state.getCompanyCurrentPrice());
            JLabel totalSharesOutstanding = createLabelWithText("Total Shares Outstanding", state.getCompanyTotalSharesOutstanding());
            JLabel marketCapitlization = createLabelWithText("Market Capitalization", state.getCompanyMarketCapitalization());

            JPanel basicInfoPanel = new JPanel(new GridLayout(0, 1));
            basicInfoPanel.setBorder(BorderFactory.createTitledBorder("Basic Company Information"));
            TitledBorder titledBorderInfo = (TitledBorder) basicInfoPanel.getBorder();
            titledBorderInfo.setTitleJustification(TitledBorder.CENTER);

            basicInfoPanel.add(currentTime);
            basicInfoPanel.add(currentPrice);
            basicInfoPanel.add(totalSharesOutstanding);
            basicInfoPanel.add(marketCapitlization);

            // Top right box, contains information about important past and upcoming dates
            GridBagConstraints datesBox = new GridBagConstraints();
            datesBox.gridx = 1;
            datesBox.gridy = GridBagConstraints.RELATIVE;
            datesBox.anchor = GridBagConstraints.NORTHWEST;
            datesBox.weightx = 0.6;
            datesBox.insets = new Insets(10, 10, 10, 10);

            // Fill datesBox with date-related information
            JLabel earningsDateLabel = createLabelWithText("Earnings Date", state.getEarningsDate());
            JLabel exDividendDateLabel = createLabelWithText("Ex-Dividend Date", state.getExDividendDate());
            JLabel dividendDateLabel = createLabelWithText("Dividend Date", state.getDividendDate());

            JPanel datesPanel = new JPanel(new BorderLayout());
            datesPanel.setBorder(BorderFactory.createTitledBorder("Important Dates"));
            TitledBorder titledBorderDates = (TitledBorder) datesPanel.getBorder();
            titledBorderDates.setTitleJustification(TitledBorder.CENTER);
            JPanel datesInfoPanel = new JPanel(new GridLayout(0, 1));
            datesInfoPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            datesInfoPanel.add(earningsDateLabel);
            datesInfoPanel.add(exDividendDateLabel);
            datesInfoPanel.add(dividendDateLabel);

            datesPanel.add(datesInfoPanel, BorderLayout.CENTER);

            // Add basicInfoPanel and datesPanel to the content panel
            contentPanel.add(basicInfoPanel, basicInfoBox);
            contentPanel.add(datesPanel, datesBox);
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