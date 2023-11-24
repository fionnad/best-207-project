package view;

import interface_adapter.ExplainUseCase.ExplainUseCaseViewModel;
import interface_adapter.FirstPage.FirstPageViewModel;

import javax.swing.*;
import java.awt.*;

public class ExplainUseCaseView extends JPanel {
    private final ExplainUseCaseViewModel explainUseCaseViewModel;

    public ExplainUseCaseView(ExplainUseCaseViewModel explainUseCaseViewModel) {
        this.explainUseCaseViewModel = explainUseCaseViewModel;

        JLabel title = new JLabel(ExplainUseCaseViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // TODO: Make API call and get the trending articles from the Presenter

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
    }
}