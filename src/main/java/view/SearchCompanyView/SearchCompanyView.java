package view.SearchCompanyView;

import app.SearchCompanyUseCaseFactory;
import interface_adapter.SearchCompany.SearchCompanyController;
import interface_adapter.SearchCompany.SearchCompanyState;
import interface_adapter.SearchCompany.SearchCompanyViewModel;

import javax.swing.*;
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
                        System.out.println(currentState.getCompanyTicker());
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
        SearchCompanyState state = (SearchCompanyState) e.getNewValue();
        System.out.println("-----COMPANY INFORMATION-----");
        System.out.printf("Fetching time is %s%n", state.getCompanyDataFetchTime());
        System.out.printf("Debt/Equity ratio is %s%n", state.getCompanyDebtToEquity());
        System.out.printf("Debt/Equity notes: %s%n", state.getCompanyDebtToEquityComment());
        System.out.printf("Ebidta Margin is %s%n", state.getCompanyEbitdaMargin());
        System.out.printf("Ebidta Margin notes: %s%n", state.getCompanyEbitdaMarginComment());
        JOptionPane.showMessageDialog(this, state.getCompanyFrontEndState());
    }
}