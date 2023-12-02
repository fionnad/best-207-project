package interface_adapter.ExplainUseCase;

import data_access.ExplainUseCaseDataAcessObject;
import interface_adapter.SearchCompany.SearchCompanyState;
import interface_adapter.ViewModel;
import use_case.ExplainUseCase.ExplainUseCaseDataAccessInterface;
import use_case.ExplainUseCase.ExplainUseCaseInteractor;
import use_case.ExplainUseCase.ExplainUseCaseOutputBoundary;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ExplainUseCaseViewModel extends ViewModel {
    public ExplainUseCaseState state = new ExplainUseCaseState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ExplainUseCaseViewModel() {
        super("Financial Terminology Definitions");
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void setState(ExplainUseCaseState state) {
        this.state = state;
    }

    public ExplainUseCaseState getState() {
        return state;
    }
}
