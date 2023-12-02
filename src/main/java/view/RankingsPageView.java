package view;

import interface_adapter.RefreshButton.RefreshController;
import interface_adapter.RefreshButton.RefreshState;
import interface_adapter.RefreshButton.RefreshViewModel;
import interface_adapter.SearchCompany.SearchCompanyState;
import interface_adapter.SearchCompany.SearchCompanyViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

public class  RankingsPageView extends JPanel implements ActionListener, PropertyChangeListener {
    private final RefreshViewModel refreshViewModel;
    private final RefreshController refreshController;
    private final JButton refresh;
    private JPanel rankingsPanel;

    public RankingsPageView(RefreshViewModel refreshViewModel, RefreshController refreshController) {

        this.refreshViewModel = refreshViewModel;
        this.refreshController = refreshController;
        this.rankingsPanel = new JPanel();

        refreshViewModel.addPropertyChangeListener(this);

        JPanel titleRowPanel = new JPanel();
        JLabel title = new JLabel(RefreshViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleRowPanel.add(title);

        JPanel buttonsPanel = new JPanel();
        refresh = new JButton(RefreshViewModel.REFRESH_BUTTON_LABEL);
        buttonsPanel.add(refresh);
        RefreshState state = this.refreshViewModel.getState();
        JLabel currentFinancialDataLabel = new JLabel(
                "<html>Rankings:" +
                        "<br>#1. " + state.getRefreshSuccess()[0] +
                        "<br>#2. " + state.getRefreshSuccess()[1] +
                        "<br>#3. " + state.getRefreshSuccess()[2] +
                        "<br>#4. " + state.getRefreshSuccess()[3] +
                        "<br>#5. " + state.getRefreshSuccess()[4] + "</html>"
        );
        rankingsPanel.add(currentFinancialDataLabel);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(titleRowPanel);
        mainPanel.add(buttonsPanel);
        mainPanel.add(this.rankingsPanel);

        refresh.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(refresh)) {
                            RefreshState currentState = refreshViewModel.getState();
                            refreshController.execute();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void propertyChange(PropertyChangeEvent e) {
        // Update the informationPresentedPanel with the new state information
        rankingsPanel.removeAll(); // Clear the panel for new information

        RefreshState state = (RefreshState) e.getNewValue();

        // Instead of printing to the console, update the JLabel with the new information
        JLabel financialDataLabel = new JLabel(
                "<html>Rankings:" +
                        "<br>#1. " + state.getRefreshSuccess()[0] +
                        "<br>#2. " + state.getRefreshSuccess()[1] +
                        "<br>#3. " + state.getRefreshSuccess()[2] +
                        "<br>#4. " + state.getRefreshSuccess()[3] +
                        "<br>#5. " + state.getRefreshSuccess()[4] + "</html>"
        );

        // Add the updated label to the panel
        rankingsPanel.add(financialDataLabel);

        // Revalidate and repaint the panel to reflect the changes
        rankingsPanel.revalidate();
        rankingsPanel.repaint();

        // Show the dialog only if there is a change in company's frontend state
    }
}