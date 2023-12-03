package use_case.SearchCompanyUseCase;

import data_access.SearchCompanyDataAccessObject;
import entities.CompanyData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SearchCompanyDataAccessObjectTest {

    @Test
    void getCompanyDataValidCompany() {
        String ticker = "UNH";
        SearchCompanyDataAccessObject searchCompanyDataAccessObject = new SearchCompanyDataAccessObject(ticker);
        CompanyData companyData = searchCompanyDataAccessObject.getCompanyData();
        assertTrue(companyData.isValidCompany());
        assertEquals("UNH", companyData.getTicker());
        assertTrue(companyData.getCurrentPrice() > 450);
    }

    @Test
    void getCompanyDataInvalidCompany() {
        String ticker = "abcdefg";
        SearchCompanyDataAccessObject searchCompanyDataAccessObject = new SearchCompanyDataAccessObject(ticker);
        CompanyData companyData = searchCompanyDataAccessObject.getCompanyData();
        assertFalse(companyData.isValidCompany());
        Double[] nullArray = new Double[12];
        Arrays.fill(nullArray, null);
        assertArrayEquals(nullArray, companyData.getAllFinData());
    }
    @Test
    void getCompanyDataValidCompanyMissingData() {
        String ticker = "JPM";
        SearchCompanyDataAccessObject searchCompanyDataAccessObject = new SearchCompanyDataAccessObject(ticker);
        CompanyData companyData = searchCompanyDataAccessObject.getCompanyData();
        int count = 0;
        for (Double item : companyData.getAllFinData()) {
            if (item == null) {
                count += 1;
            }
        }
        assertEquals("JPM", companyData.getTicker());
        assertTrue(companyData.isValidCompany());
        assertEquals(7, count); // 7 variables will be null as a result of freeCashFlow variable missing
    }

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