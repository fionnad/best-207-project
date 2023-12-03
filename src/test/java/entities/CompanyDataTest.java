package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;

public class CompanyDataTest {
    @Test
    void companyInfoNullCompanyTest() {
        CompanyData companyData = CompanyDataFactory.createNullCompany("abcdefg");
        assertNull(companyData.getTimeFetched());
        assertNull(companyData.getCurrentPrice());
        assertNull(companyData.getFreeCashFlow());
        assertNull(companyData.getTotalRevenue());
        assertNull(companyData.getRevenuePerShare());
        assertNull(companyData.getTotalSharesOutstanding());
        assertNull(companyData.getMarketCapitalization());
        assertNull(companyData.getEbitdaMargins());
        assertNull(companyData.getEbitdaMarginsAnalysis());
        assertNull(companyData.getDebtToEquity());
        assertNull(companyData.getDebtToEquityAnalysis());
        assertNull(companyData.getRevenueGrowth());
        assertNull(companyData.getRevenueGrowthAnalysis());
        assertNull(companyData.getFreeCashFlowMargin());
        assertNull(companyData.getFreeCashFlowMarginAnalysis());
        assertNull(companyData.getFreeCashFlowPerShare());
        assertNull(companyData.getFreeCashFlowPerShareAnalysis());
        assertNull(companyData.getFreeCashFlowYield());
        assertNull(companyData.getFreeCashFlowYieldAnalysis());
        assertNull(companyData.getEarningsDate());
        assertNull(companyData.getDividendDate());
        assertNull(companyData.getExDividendDate());
        Double[] nullArray = new Double[12];
        Arrays.fill(nullArray, null);
        assertArrayEquals(nullArray, companyData.getAllFinData());
    }

    @Test
    void companyInfoEmptyCompanyTest() {
        CompanyData companyData = CompanyDataFactory.createNullCompany("");
        assertNull(companyData.getTimeFetched());
        assertNull(companyData.getCurrentPrice());
        assertNull(companyData.getFreeCashFlow());
        assertNull(companyData.getTotalRevenue());
        assertNull(companyData.getRevenuePerShare());
        assertNull(companyData.getTotalSharesOutstanding());
        assertNull(companyData.getMarketCapitalization());
        assertNull(companyData.getEbitdaMargins());
        assertNull(companyData.getEbitdaMarginsAnalysis());
        assertNull(companyData.getDebtToEquity());
        assertNull(companyData.getDebtToEquityAnalysis());
        assertNull(companyData.getRevenueGrowth());
        assertNull(companyData.getRevenueGrowthAnalysis());
        assertNull(companyData.getFreeCashFlowMargin());
        assertNull(companyData.getFreeCashFlowMarginAnalysis());
        assertNull(companyData.getFreeCashFlowPerShare());
        assertNull(companyData.getFreeCashFlowPerShareAnalysis());
        assertNull(companyData.getFreeCashFlowYield());
        assertNull(companyData.getFreeCashFlowYieldAnalysis());
        assertNull(companyData.getEarningsDate());
        assertNull(companyData.getDividendDate());
        assertNull(companyData.getExDividendDate());
        Double[] nullArray = new Double[12];
        Arrays.fill(nullArray, null);
        assertArrayEquals(nullArray, companyData.getAllFinData());
    }
}
