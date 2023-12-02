package interface_adapter.ExplainUseCase;

import entities.FinancialTermDefinition;

public class ExplainUseCaseState {
    private String currentTerm;
    private FinancialTermDefinition definitions;

    public void setCurrentTerm(String term) {
        this.currentTerm = term;
    }
    public String getDefinitionForCurrentTerm() {
        switch (currentTerm.toLowerCase()) {
            case "debt":
                return definitions.getDebt();
            case "equity":
                return definitions.getEquity();
            case "debttoequity":
                return definitions.getDebtToEquity();
            case "ebitdamargin":
                return definitions.getEbitdaMargin();
            case "revenuegrowth":
                return definitions.getRevenueGrowth();
            case "freecashflow":
                return definitions.getFreeCashFlow();
            case "freecashflowmargin":
                return definitions.getFreeCashFlowMargin();
            case "freecashflowpershare":
                return definitions.getFreeCashFlowPerShare();
            case "freecashflowyield":
                return definitions.getFreeCashFlowYield();
            // ... handle other cases ...
            default:
                return "Definition not found for the term: " + currentTerm;
        }
    }

    public String getCurrentTerm() {
        return currentTerm;
    }

    public void setDefinitions(FinancialTermDefinition definitions) {
        this.definitions = definitions;
    }

    public FinancialTermDefinition getDefinitions() {
        return definitions;
    }
}
