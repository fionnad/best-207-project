package interface_adapter.SearchCompany;
import use_case.SearchCompany.SearchCompanyInputBoundary;
import use_case.SearchCompany.SearchCompanyInputData;
import use_case.SearchCompany.SearchCompanyInteractor;

public class SearchCompanyController {
    final SearchCompanyInputBoundary userSearchCompanyUseCaseInteractor;

    public SearchCompanyController(SearchCompanyInputBoundary userSearchCompanyUseCaseInteractor) {
        this.userSearchCompanyUseCaseInteractor = userSearchCompanyUseCaseInteractor;
    }

    public void execute() {
        userSearchCompanyUseCaseInteractor.execute();
    }
}
