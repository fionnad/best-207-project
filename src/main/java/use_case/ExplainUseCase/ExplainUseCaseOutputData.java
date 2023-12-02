package use_case.ExplainUseCase;

import entities.FinancialTermDefinition;

public class ExplainUseCaseOutputData {
    private final FinancialTermDefinition financialTermDefinition;

    public ExplainUseCaseOutputData(FinancialTermDefinition financialTermDefinition) {
        this.financialTermDefinition = financialTermDefinition;
    }

    public FinancialTermDefinition getDefinition() {
        return financialTermDefinition;
    }
}
