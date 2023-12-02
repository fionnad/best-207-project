package use_case.ExplainUseCase;

import entities.FinancialTermDefinition;

public class ExplainUseCaseInteractor {
    private final ExplainUseCaseDataAccessInterface dataAccess;
    private final ExplainUseCaseOutputBoundary presenter;

    public ExplainUseCaseInteractor(ExplainUseCaseDataAccessInterface dataAccess, ExplainUseCaseOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    public void getFinancialTermDefinitions() {
        FinancialTermDefinition definitions = dataAccess.getFinancialTermDefinitions();
        ExplainUseCaseOutputData outputData = new ExplainUseCaseOutputData(definitions);
        presenter.present(outputData);
    }
}
