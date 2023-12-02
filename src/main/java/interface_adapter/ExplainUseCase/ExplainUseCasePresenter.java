package interface_adapter.ExplainUseCase;

import use_case.ExplainUseCase.ExplainUseCaseOutputBoundary;
import use_case.ExplainUseCase.ExplainUseCaseOutputData;

import javax.swing.*;
import java.util.Map;

public class ExplainUseCasePresenter implements ExplainUseCaseOutputBoundary {
    private final Map<String, JButton> termButtons;
    private final JTextArea definitionsTextArea;

    public ExplainUseCasePresenter(Map<String, JButton> termButtons, JTextArea definitionsTextArea) {
        this.termButtons = termButtons;
        this.definitionsTextArea = definitionsTextArea;
        setupButtonListeners();
    }

    private void setupButtonListeners() {
        for (Map.Entry<String, JButton> entry : termButtons.entrySet()) {
            JButton button = entry.getValue();
            String term = entry.getKey();
            button.addActionListener(e -> handleButtonClick(term));
        }
    }

    private void handleButtonClick(String term) {
        // When a button is clicked, the corresponding definition will be fetched
        // This can be done by triggering the use case interactor (not shown here)
        // For now, just display a placeholder text
        definitionsTextArea.setText("Fetching definition for: " + term);
    }

    @Override
    public void present(ExplainUseCaseOutputData outputData) {
        // Loop through all terms and update their definitions
        for (String term : termButtons.keySet()) {
            String definition = outputData.getFinancialTermDefinition(term);
            JButton button = termButtons.get(term);
            button.addActionListener(e -> definitionsTextArea.setText(definition));
        }
    }
}
