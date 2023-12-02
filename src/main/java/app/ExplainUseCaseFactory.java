package app;

import data_access.ExplainUseCaseDataAcessObject;
import interface_adapter.ExplainUseCase.ExplainUseCaseController;
import interface_adapter.ExplainUseCase.ExplainUseCasePresenter;
import interface_adapter.ExplainUseCase.ExplainUseCaseViewModel;
import use_case.ExplainUseCase.ExplainUseCaseInteractor;

public class ExplainUseCaseFactory {

    public static ExplainUseCaseController create() {
        ExplainUseCaseViewModel viewModel = new ExplainUseCaseViewModel();
        ExplainUseCaseDataAcessObject dataAccess = new ExplainUseCaseDataAcessObject();
        ExplainUseCasePresenter presenter = new ExplainUseCasePresenter(viewModel);
        ExplainUseCaseInteractor interactor = new ExplainUseCaseInteractor(dataAccess, presenter);
        return new ExplainUseCaseController(interactor);
    }
}