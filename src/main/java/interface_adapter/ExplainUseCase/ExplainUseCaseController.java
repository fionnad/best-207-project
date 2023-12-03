package interface_adapter.ExplainUseCase;

import use_case.ExplainUseCase.ExplainUseCaseInteractor;

public class ExplainUseCaseController {
    private final ExplainUseCaseInteractor interactor;

    public ExplainUseCaseController(ExplainUseCaseInteractor interactor) {
        this.interactor = interactor;
    }
}
