package view;

import app.ExplainUseCaseFactory;
import interface_adapter.ExplainUseCase.ExplainUseCaseController;
import interface_adapter.ExplainUseCase.ExplainUseCaseViewModel;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class ExplainUseCaseView extends JPanel implements PropertyChangeListener {
    private final ExplainUseCaseViewModel viewModel;
    private final JTextArea definitionsTextArea = new JTextArea(10, 30);
    private final Map<String, JButton> termButtons = new HashMap<>();

    public ExplainUseCaseView(ExplainUseCaseViewModel viewModel) {
        this.viewModel = viewModel;
        viewModel.addPropertyChangeListener(this);
        setLayout(new BorderLayout());
        initializeUI();
    }

    private void initializeUI() {
        setupTermButtons();
        add(createButtonPanel(), BorderLayout.NORTH);
        definitionsTextArea.setEditable(false);
        add(new JScrollPane(definitionsTextArea), BorderLayout.CENTER);
    }

    private void setupTermButtons() {
        termButtons.put("Debt", new JButton("Debt"));
        termButtons.put("Equity", new JButton("Equity"));
        termButtons.put("DebtToEquity", new JButton("DebtToEquity"));
        termButtons.put("EbitdaMargin", new JButton("EbitdaMargin"));
        termButtons.put("RevenueGrowth", new JButton("RevenueGrowth"));
        termButtons.put("FreeCashFlow", new JButton("FreeCashFlow"));
        termButtons.put("FreeCashFlowMargin", new JButton("FreeCashFlowMargin"));
        termButtons.put("FreeCashFlowPerShare", new JButton("FreeCashFlowPerShare"));
        termButtons.put("FreeCashFlowYield", new JButton("FreeCashFlowYield"));
        termButtons.forEach((term, button) -> button.addActionListener(e -> {
            viewModel.getState().setCurrentTerm(term);
            viewModel.firePropertyChanged();
        }));
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(0, 3));
        termButtons.values().forEach(buttonPanel::add);
        return buttonPanel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            ExplainUseCaseController explainUseCaseController = ExplainUseCaseFactory.create();
            String term = viewModel.getState().getCurrentTerm();
            explainUseCaseController.onTermSelected(term);

            String definition = viewModel.getState().getDefinitionForCurrentTerm();
            definitionsTextArea.setText(definition);
        }
    }

}
