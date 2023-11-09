package view;

import interface_adapter.FirstPage.FirstPageViewModel;

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
}
