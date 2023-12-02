package data_access;

import entities.FinancialTermDefinition;
import use_case.ExplainUseCase.ExplainUseCaseDataAccessInterface;

public class ExplainUseCaseDataAcessObject implements ExplainUseCaseDataAccessInterface {
    @Override
    public FinancialTermDefinition getFinancialTermDefinitions() {
        return new FinancialTermDefinition();
    }
}
