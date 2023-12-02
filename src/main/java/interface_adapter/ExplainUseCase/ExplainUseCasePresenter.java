package interface_adapter.ExplainUseCase;

import entities.FinancialTermDefinition;
import use_case.ExplainUseCase.ExplainUseCaseOutputBoundary;
import use_case.ExplainUseCase.ExplainUseCaseOutputData;

public class ExplainUseCasePresenter implements ExplainUseCaseOutputBoundary {
    private final ExplainUseCaseViewModel viewModel;

    public ExplainUseCasePresenter(ExplainUseCaseViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void present(ExplainUseCaseOutputData outputData) {
        viewModel.getState().setDefinitions(outputData.getDefinition());
        viewModel.firePropertyChanged();
    }
}
