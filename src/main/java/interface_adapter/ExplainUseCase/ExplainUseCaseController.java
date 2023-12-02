package interface_adapter.ExplainUseCase;

import use_case.ExplainUseCase.ExplainUseCaseInteractor;
import use_case.ExplainUseCase.ExplainUseCaseDataAccessInterface;
import use_case.ExplainUseCase.ExplainUseCaseOutputBoundary;

public class ExplainUseCaseController {
    private final ExplainUseCaseInteractor explainUseCaseInteractor;

    public ExplainUseCaseController(ExplainUseCaseDataAccessInterface dataAccess, ExplainUseCaseOutputBoundary outputBoundary) {
        this.explainUseCaseInteractor = new ExplainUseCaseInteractor(dataAccess, outputBoundary);
    }

    public void getDefinition(String term) {
        explainUseCaseInteractor.getFinancialTermDefinitions(term);
        // The outputBoundary (presenter) will handle the presentation logic
    }
}
