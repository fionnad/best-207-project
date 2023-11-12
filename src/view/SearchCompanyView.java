package view;

import interface_adapter.FirstPage.FirstPageViewModel;
import interface_adapter.SearchCompany.SearchCompanyController;
import interface_adapter.SearchCompany.SearchCompanyViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchCompanyView extends JPanel implements ActionListener {
    private final SearchCompanyViewModel searchCompanyViewModel;
    private final SearchCompanyController searchCompanyController;
    private final JButton searchCompanyButton;

    public SearchCompanyView(SearchCompanyViewModel newSearchCompanyViewModel, SearchCompanyController newSearchCompanyController) {
        this.searchCompanyViewModel = newSearchCompanyViewModel;
        this.searchCompanyController = newSearchCompanyController;

        JPanel panel = new JPanel();
        JLabel title = new JLabel(SearchCompanyViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchCompanyButton = new JButton("Output Apple Information");
        panel.add(searchCompanyButton);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(panel);

        searchCompanyButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(searchCompanyButton)) {
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

