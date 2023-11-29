package app;

import entities.CompanyDataFactory;
import interface_adapter.ExplainUseCase.ExplainUseCaseViewModel;
import data_access.RefreshDataAccessObject;
//import entities.CompanyDataFactory;
import interface_adapter.RefreshButton.RefreshViewModel;
import interface_adapter.SearchCompany.SearchCompanyViewModel;
import view.ExplainUseCaseView;
import view.RankingsPageView;
import view.SearchCompanyView.SearchCompanyView;
import interface_adapter.ViewManagerModel;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("best-207-project");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        RefreshViewModel refreshViewModel = new RefreshViewModel();
        SearchCompanyViewModel searchCompanyViewModel = new SearchCompanyViewModel();
        ExplainUseCaseViewModel explainUseCaseViewModel = new ExplainUseCaseViewModel();

        RefreshDataAccessObject refreshDataAccessObject;

        try {refreshDataAccessObject = new RefreshDataAccessObject("./Tickers.csv","./Tickers.txt", new CompanyDataFactory());} catch (
                IOException e) {
            throw new RuntimeException(e);
        }

        RankingsPageView rankingsPageView = RankingsPageUseCaseFactory.create(viewManagerModel, refreshViewModel, refreshDataAccessObject);
        SearchCompanyView searchCompanyView = new SearchCompanyView(searchCompanyViewModel);
        ExplainUseCaseView explainUseCaseView = new ExplainUseCaseView(explainUseCaseViewModel);

        //Add the pages to the JPanel
        views.add(rankingsPageView);
        views.add(searchCompanyView);
        views.add(explainUseCaseView);

        JButton nextView = new JButton("Next Page");

        nextView.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed (ActionEvent e) {
                        CardLayout cardLayout1 = (CardLayout)(views.getLayout());
                        cardLayout1.next(views);
                    }
                });

        Container pane1 = application.getContentPane();
        pane1.add(views, BorderLayout.WEST);

        JPanel nextbtnPanel = new JPanel();
        nextbtnPanel.add(nextView);
        pane1.add(nextbtnPanel, BorderLayout.SOUTH);



        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);

    }
}