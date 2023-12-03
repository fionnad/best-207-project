package use_case.SearchCompanyUseCase;

import data_access.SearchCompanyDataAccessObject;
import entities.CompanyData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SearchCompanyDataAccessObjectTest {

    @Test
    void getCompanyDataNoString() {
        String ticker = "";
        SearchCompanyDataAccessObject searchCompanyDataAccessObject = new SearchCompanyDataAccessObject(ticker);
        CompanyData companyData = searchCompanyDataAccessObject.getCompanyData();
        assertFalse(companyData.isValidCompany());
        Double[] nullArray = new Double[12];
        Arrays.fill(nullArray, null);
        assertArrayEquals(nullArray, companyData.getAllFinData());
    }
}