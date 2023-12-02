package interface_adapter.ExplainUseCase;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ExplainUseCaseViewModel {
    private String currentTerm = ""; // This will hold the current financial term
    private String definition = "";  // This will hold the definition of the current term

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public String getCurrentTerm() {
        return currentTerm;
    }

    public void setCurrentTerm(String term) {
        String oldTerm = this.currentTerm;
        this.currentTerm = term;
        support.firePropertyChange("currentTerm", oldTerm, term);
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        String oldDefinition = this.definition;
        this.definition = definition;
        support.firePropertyChange("definition", oldDefinition, definition);
    }
}
