package use_case.SearchCompany;

public interface SearchCompanyOutputBoundary {
    void prepareSuccessView(SearchCompanyOutputData companyFinancialData);

    void prepareFailView(String error);
}