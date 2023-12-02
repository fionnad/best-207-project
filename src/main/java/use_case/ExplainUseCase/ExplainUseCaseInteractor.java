package use_case.ExplainUseCase;

import entities.FinancialTermDefinition;

public class ExplainUseCaseInteractor{
    private final ExplainUseCaseDataAccessInterface explainUseCaseDataAccessObject;
    private final ExplainUseCaseOutputBoundary explainUseCaseOutputBoundary;

    public ExplainUseCaseInteractor(ExplainUseCaseDataAccessInterface explainUseCaseDataAccessInterface, ExplainUseCaseOutputBoundary explainUseCaseOutputBoundary) {
        this.explainUseCaseDataAccessObject = explainUseCaseDataAccessInterface;
        this.explainUseCaseOutputBoundary = explainUseCaseOutputBoundary;
    }

    public void getFinancialTermDefinitions(String term) {
        FinancialTermDefinition definitions = explainUseCaseDataAccessObject.getFinancialTermDefinitions(term);
        ExplainUseCaseOutputData outputData = new ExplainUseCaseOutputData(definitions);
        explainUseCaseOutputBoundary.present(outputData);
    }
}
