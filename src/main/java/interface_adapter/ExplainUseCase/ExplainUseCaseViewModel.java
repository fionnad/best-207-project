package interface_adapter.ExplainUseCase;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ExplainUseCaseViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Understanding Financial Terms";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ExplainUseCaseViewModel() {
        super("Financial Terminology Definitions");
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


}
