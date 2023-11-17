package app;

import interface_adapter.FirstPage.FirstPageViewModel;
import interface_adapter.SearchCompany.SearchCompanyViewModel;
import view.FirstPageView;
import view.SearchCompanyView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        FirstPageViewModel firstPageViewModel = new FirstPageViewModel();
        SearchCompanyViewModel searchCompanyViewModel = new SearchCompanyViewModel();

        FirstPageView firstPageView = new FirstPageView(firstPageViewModel);
        SearchCompanyView searchCompanyView = new SearchCompanyView(searchCompanyViewModel);

        views.add(firstPageView);
        views.add(searchCompanyView);

        JButton changeView = new JButton("Switch Page");
        changeView.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed (ActionEvent e) {
                        CardLayout cardLayout1 = (CardLayout)(views.getLayout());
                        cardLayout1.next(views);
            }
        });
        Container pane = application.getContentPane();
        pane.add(views, BorderLayout.CENTER);
        JPanel btnPanel = new JPanel();
        btnPanel.add(changeView);
        pane.add(btnPanel, BorderLayout.SOUTH);

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);
    }
}