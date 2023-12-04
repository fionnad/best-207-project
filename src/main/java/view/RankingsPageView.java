package view;

import data_access.RefreshDataAccessObject;
import entities.CompanyDataFactory;
import interface_adapter.RefreshButton.RefreshController;
import interface_adapter.RefreshButton.RefreshState;
import interface_adapter.RefreshButton.RefreshViewModel;
import interface_adapter.SearchCompany.SearchCompanyState;
import interface_adapter.SearchCompany.SearchCompanyViewModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.Ref;
import java.util.ArrayList;
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

        //Updates the view on startup
        RefreshDataAccessObject refreshDataAccessObject;
        try {
            refreshDataAccessObject = new RefreshDataAccessObject("./Tickers.csv","./Tickers.txt", new CompanyDataFactory());
        }
        catch (
                IOException e) {
            throw new RuntimeException(e);
        }

        // Updates the view on startup
        ArrayList<String[]> oldData = refreshDataAccessObject.update();

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Rank");
        tableModel.addColumn("Company");
        tableModel.addColumn("Current Stock Price");
        tableModel.addColumn("Market Capitalization");
        tableModel.addColumn("Shares Outstanding");
        tableModel.addColumn("Total Revenue");
        tableModel.addColumn("Revenue Growth");
        tableModel.addColumn("EBITDA Margins");
        tableModel.addColumn("Debt/Equity Ratio");
        tableModel.addColumn("FCF Margin");

        // Populate the table model with initial data
        for (int i = 0; i < oldData.size(); i++) {
            String[] rowData = oldData.get(i);
            tableModel.addRow(new Object[]{i + 1,
                    rowData[0],
                    rowData[2],
                    rowData[3],
                    rowData[4],
                    rowData[5],
                    rowData[6],
                    rowData[7],
                    rowData[8],
                    rowData[9]});
        }

        // Creating table
        JTable rankingsTable = new JTable(tableModel);
        rankingsTable.setRowHeight(30);

        // Creating scroll feature
        JScrollPane tableScrollPane = new JScrollPane(rankingsTable);
        tableScrollPane.setPreferredSize(new Dimension(400, 200));
        rankingsTable.getColumnModel().getColumn(0).setPreferredWidth(27);
        rankingsTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        rankingsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        rankingsTable.getColumnModel().getColumn(3).setPreferredWidth(90);

        // Clear existing components in rankingsPanel and add the tableScrollPane
        rankingsPanel.removeAll();
        rankingsPanel.setLayout(new BorderLayout());
        rankingsPanel.add(tableScrollPane, BorderLayout.CENTER);

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
                            JOptionPane.showMessageDialog(null, currentState.getRefreshTime());
                        }
                    }
                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ;
    }

    public void propertyChange(PropertyChangeEvent e) {
        // Update the informationPresentedPanel with the new state information
        rankingsPanel.removeAll(); // Clear the panel for new information

        RefreshState state = (RefreshState) e.getNewValue();

        ArrayList<String[]> newData = state.getRefreshSuccess();

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Rank");
        tableModel.addColumn("Company");
        tableModel.addColumn("Current Stock Price");
        tableModel.addColumn("Market Capitalization");
        tableModel.addColumn("Shares Outstanding");
        tableModel.addColumn("Total Revenue");
        tableModel.addColumn("Revenue Growth");
        tableModel.addColumn("EBITDA Margins");
        tableModel.addColumn("Debt/Equity Ratio");
        tableModel.addColumn("FCF Margin");

        // Populate the table model with initial data
        for (int i = 0; i < newData.size(); i++) {
            String[] rowData = newData.get(i);
            tableModel.addRow(new Object[]{i + 1,
                    rowData[0],
                    rowData[2],
                    rowData[3],
                    rowData[4],
                    rowData[5],
                    rowData[6],
                    rowData[7],
                    rowData[8],
                    rowData[9]});
        }

        // Creating table
        JTable rankingsTable = new JTable(tableModel);
        rankingsTable.setRowHeight(30);

        // Creating scroll feature
        JScrollPane tableScrollPane = new JScrollPane(rankingsTable);
        tableScrollPane.setPreferredSize(new Dimension(400, 200));
        rankingsTable.getColumnModel().getColumn(0).setPreferredWidth(27);
        rankingsTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        rankingsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        rankingsTable.getColumnModel().getColumn(3).setPreferredWidth(90);

        // Clear existing components in rankingsPanel and add the tableScrollPane
        rankingsPanel.removeAll();
        rankingsPanel.setLayout(new BorderLayout()); // Set BorderLayout for rankingsPanel
        rankingsPanel.add(tableScrollPane, BorderLayout.CENTER);

        // Show the dialog only if there is a change in company's frontend state
    }
}