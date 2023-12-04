package app;

import entities.CompanyDataFactory;
import interface_adapter.ExplainUseCase.ExplainUseCaseViewModel;
import data_access.RefreshDataAccessObject;
//import entities.CompanyDataFactory;
import interface_adapter.RefreshButton.RefreshViewModel;
import interface_adapter.SearchCompany.SearchCompanyViewModel;
import view.ExplainUseCaseView;
import view.RankingsPageView;
import view.SearchCompanyView;
import interface_adapter.ViewManagerModel;
import view.Utilities.CreateTheme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

import static view.Utilities.PaddedJPanel.createPaddedPanel;

public class Main {
    public static void main(String[] args) {
        // Setting theme
        CreateTheme.setTheme();

        // Main application window
        JFrame application = new JFrame("best-207-project");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Panel projected unto the front screen
        JPanel mainPanel = new JPanel(new BorderLayout());
        application.add(mainPanel);

        // The tabbed pane for switching between pages
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBorder(new EmptyBorder(20, 10, 10, 10));
        mainPanel.add(tabbedPane, BorderLayout.CENTER);

        // ViewManager to manage switching between pages
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        // Creating Pages
        RefreshViewModel refreshViewModel = new RefreshViewModel();
        SearchCompanyViewModel searchCompanyViewModel = new SearchCompanyViewModel();
        ExplainUseCaseViewModel explainUseCaseViewModel = new ExplainUseCaseViewModel();

        // Initiate Refresh DAO on start
        RefreshDataAccessObject refreshDataAccessObject;
        try {
            refreshDataAccessObject = new RefreshDataAccessObject("./Tickers.csv","./Tickers.txt", new CompanyDataFactory());
        }
        catch (
                IOException e) {
            throw new RuntimeException(e);
        }

        RankingsPageView rankingsPageView = RankingsPageUseCaseFactory.create(viewManagerModel, refreshViewModel, refreshDataAccessObject);
        SearchCompanyView searchCompanyView = new SearchCompanyView(searchCompanyViewModel);
        ExplainUseCaseView explainUseCaseView = new ExplainUseCaseView(explainUseCaseViewModel);

        // Add the pages to the tabs
        tabbedPane.addTab("Daily Rankings", createPaddedPanel(rankingsPageView, 30, 30));
        tabbedPane.addTab("Search A Company", createPaddedPanel(searchCompanyView, 30, 30));
        tabbedPane.addTab("Definitions", createPaddedPanel(explainUseCaseView, 30, 30));

        // Execute refresh
//        refreshDataAccessObject.refresh();

        application.pack();
        application.setVisible(true);
    }
}