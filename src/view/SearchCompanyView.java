package view;

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

public class SearchCompanyView extends JPanel implements ActionListener {
    private final SearchCompanyViewModel searchCompanyViewModel;
    private final JTextField searchCompanyInputField = new JTextField(15);
    private final JButton searchCompanyButton;

    public SearchCompanyView(SearchCompanyViewModel newSearchCompanyViewModel) {
        this.searchCompanyViewModel = newSearchCompanyViewModel;

        JPanel panel = new JPanel();
        JLabel title = new JLabel(SearchCompanyViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelTextPanel companyInfo = new LabelTextPanel(new JLabel(SearchCompanyViewModel.SEARCH_LABEL), searchCompanyInputField);
        searchCompanyButton = new JButton("Search Company");
        panel.add(searchCompanyButton);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(companyInfo);
        this.add(panel);

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
                            SearchCompanyController searchCompanyController = SearchCompanyUseCaseFactory.create(searchCompanyViewModel.getState().getCompanyTicker());
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
}

