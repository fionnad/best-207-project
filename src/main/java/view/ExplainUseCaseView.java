package view;

import interface_adapter.ExplainUseCase.ExplainUseCaseViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public class ExplainUseCaseView extends JPanel implements PropertyChangeListener {
    private final ExplainUseCaseViewModel viewModel;
    private final Map<String, JButton> termButtons = new HashMap<>();
    private final JTextArea definitionsTextArea;

    public ExplainUseCaseView(ExplainUseCaseViewModel viewModel) {
        this.viewModel = viewModel;
        this.definitionsTextArea = new JTextArea(10, 30); // Adjust size as needed
        this.viewModel.addPropertyChangeListener(this);

        this.setLayout(new BorderLayout());
        initialize();
    }

    private void initialize() {
        // Set up buttons for each financial term
        setupTermButtons();

        // Add the button panel
        this.add(createButtonPanel(), BorderLayout.NORTH);

        // Set up the text area for definitions
        this.definitionsTextArea.setEditable(false);
        this.add(new JScrollPane(definitionsTextArea), BorderLayout.CENTER);
    }

    private void setupTermButtons() {
        // Initialize buttons for each financial term
        // Example:
        termButtons.put("Debt", new JButton("Debt"));
        termButtons.put("Equity", new JButton("Equity"));
        // ... Add other term buttons as needed ...

        // Set up the button actions
        termButtons.forEach((term, button) -> button.addActionListener(e -> viewModel.setCurrentTerm(term)));
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(0, 3)); // Adjust layout as needed
        termButtons.values().forEach(buttonPanel::add);
        return buttonPanel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // React to changes in the viewModel
        if ("definition".equals(evt.getPropertyName())) {
            definitionsTextArea.setText(viewModel.getDefinition());
        }
    }
}
