package view;

import app.ExplainUseCaseFactory;
import app.SearchCompanyUseCaseFactory;
import interface_adapter.ExplainUseCase.ExplainUseCaseController;
import interface_adapter.ExplainUseCase.ExplainUseCaseState;
import interface_adapter.ExplainUseCase.ExplainUseCaseViewModel;
import interface_adapter.SearchCompany.SearchCompanyController;
import interface_adapter.SearchCompany.SearchCompanyState;
import interface_adapter.SearchCompany.SearchCompanyViewModel;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class ExplainUseCaseTest {

    @Test
    void ExplainUseCaseRevenueGrowthTest() {
        // Initializing ExplainUseCase
        ExplainUseCaseState explainUseCaseState = new ExplainUseCaseState();
        explainUseCaseState.setCurrentTerm("RevenueGrowth");

        // Initializing SearchCompanyView and setting SearchCompanyState
        ExplainUseCaseViewModel explainUseCaseViewModel = new ExplainUseCaseViewModel();
        explainUseCaseViewModel.setState(explainUseCaseState);

        ExplainUseCaseController explainUseCaseController = ExplainUseCaseFactory.create();

        // Passing SearchCompanyState to SearchCompanyViewModel
        JPanel explainView = new ExplainUseCaseView(explainUseCaseViewModel);

        JFrame jf = new JFrame();
        jf.setContentPane(explainView);
        jf.pack();
        jf.setVisible(true);
        explainUseCaseController.onTermSelected("RevenueGrowth");
        assertEquals("Revenue Growth is the increase in a company's total revenue or sales over a specific period of time.", explainUseCaseViewModel.getState().getDefinitionForCurrentTerm());
    }
}
