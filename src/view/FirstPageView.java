package view;

import interface_adapter.FirstPage.FirstPageViewModel;
import use_case.FetchNews.NewsOutputData;

import javax.swing.*;
import java.awt.*;

public class FirstPageView extends JPanel {
    private final FirstPageViewModel firstPageViewModel;

    public FirstPageView(FirstPageViewModel firstPageViewModel) {
        this.firstPageViewModel = firstPageViewModel;

        JLabel title = new JLabel(FirstPageViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // TODO: Make API call and get the trending articles from the Presenter
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
    }
    public void displayNews(List newsList) {
        // Create UI components based on the newsList and add them to the view
    }
}
