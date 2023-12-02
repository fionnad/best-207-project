package use_case.ExplainUseCase;

import entities.FinancialTermDefinition;

public class ExplainUseCaseOutputData {
    private final FinancialTermDefinition definition;

    public ExplainUseCaseOutputData(FinancialTermDefinition definition) {
        this.definition = definition;
    }

    // A method to get the definition of a specific financial term
    public String getFinancialTermDefinition(String term) {
        switch (term.toLowerCase()) {
            case "debt":
                return definition.getDebt();
            case "equity":
                return definition.getEquity();
            case "debttoequity":
                return definition.getDebtToEquity();
            case "ebitdamargin":
                return definition.getEbitdaMargin();
            case "revenuegrowth":
                return definition.getRevenueGrowth();
            case "freecashflow":
                return definition.getFreeCashFlow();
            case "freecashflowmargin":
                return definition.getFreeCashFlowMargin();
            case "freecashflowpershare":
                return definition.getFreeCashFlowPerShare();
            case "freecashflowyield":
                return definition.getFreeCashFlowYield();
            default:
                return "Definition not found for the term: " + term;
        }
    }
}
