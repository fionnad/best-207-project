package view;


import interface_adapter.ExplainUseCase.ExplainUseCaseState;
import interface_adapter.ExplainUseCase.ExplainUseCaseViewModel;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class ExplainUseCaseView extends JPanel implements PropertyChangeListener {
    private final ExplainUseCaseViewModel explainUseCaseViewModel;
    private final JTextArea definitionsTextArea = new JTextArea(10, 30);
    private final Map<String, JButton> termButtons = new HashMap<>();

    public ExplainUseCaseView(ExplainUseCaseViewModel viewModel) {
        this.explainUseCaseViewModel = viewModel;
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
            explainUseCaseViewModel.getState().setCurrentTerm(term);
            explainUseCaseViewModel.firePropertyChanged();
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
            ExplainUseCaseState state = explainUseCaseViewModel.getState();
            String definition = state.getDefinitionForCurrentTerm();
            definitionsTextArea.setText(definition);
        }
        if ("fontSize".equals(evt.getPropertyName())) {
            updateUIFontSize((Integer) evt.getNewValue());
        }
    }
    private void updateUIFontSize(int newSize) {
        Font newFont = new Font(getFont().getName(), getFont().getStyle(), newSize);
        definitionsTextArea.setFont(newFont);
        termButtons.values().forEach(button -> button.setFont(newFont));
        // Update other components in ExplainUseCaseView
    }

}
