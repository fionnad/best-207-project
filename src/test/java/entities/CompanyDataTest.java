package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class CompanyDataTest {
    @Test
    void companyInfoValidCompanyTest() { // Case 1: Valid company with all data.
        HashMap<String, Object> FinDataHashmap = new HashMap<>(); // Since the financial data for companies change daily, we need to put in fixed variables.
        FinDataHashmap.put("freeCashFlowPerShare", 5.219588171255193);
        FinDataHashmap.put("freeCashFlowPerShareAnalysis", "The FCF Per Share is very high, signifying satisfaction of all its debt obligations, including dividend payouts.");
        FinDataHashmap.put("marketCapitalization", 3.0109852049119946E12);
        FinDataHashmap.put("revenueGrowthAnalysis", "The Revenue Growth is negative, indicating concerning or negative trends for the company.");
        FinDataHashmap.put("freeCashFlowMarginAnalysis", "The FCF Margin is very high, signifying large potential profitability for the company.");
        FinDataHashmap.put("currentPrice", 191.24);
        FinDataHashmap.put("debtToEquityAnalysis", "The company's Debt to Equity ratio is high, indicating it has much more debt than equity, which is unfavorable.");
        FinDataHashmap.put("freeCashFlowMargin", 0.21440963569073251);
        FinDataHashmap.put("freeCashFlow", 82179997696L); // Assuming the freeCashFlow value is a long type
        FinDataHashmap.put("ebitdaMargins", 0.32827);
        FinDataHashmap.put("debtToEquity", 199.418);
        FinDataHashmap.put("freeCashFlowYield", 0.027293391399577458);
        FinDataHashmap.put("ebitdaMarginsAnalysis", "The EBITDA Margin is relatively high, signifying healthy profit margins for the company.");
        FinDataHashmap.put("freeCashFlowYieldAnalysis", "The FCF Yield is very small, and may not warrant further research on the company as value is low.");
        FinDataHashmap.put("revenuePerShare", 24.344);
        FinDataHashmap.put("totalSharesOutstanding", 1.574453673348669E10);
        FinDataHashmap.put("totalRevenue", 383285002240L);
        FinDataHashmap.put("revenueGrowth", -0.007);
        FinDataHashmap.put("dividendDate", "2023-11-16");
        FinDataHashmap.put("exDividendDate", "2023-11-10");
        FinDataHashmap.put("earningsDate", "2024-01-31");
        CompanyData companyData = CompanyDataFactory.createNewCompany("AAPL", FinDataHashmap);
        assertTrue(companyData.isValidCompany());
        assertEquals("AAPL", companyData.getTicker());
        assertEquals("2023-12-02", companyData.getTimeFetched());
        assertEquals(191.24, companyData.getCurrentPrice());
        assertEquals(82179997696L, companyData.getFreeCashFlow());
        assertEquals(383285002240L, companyData.getTotalRevenue());
        assertEquals(24.344, companyData.getRevenuePerShare());
        assertEquals(1.574453673348669E10, companyData.getTotalSharesOutstanding());
        assertEquals(3.0109852049119946E12, companyData.getMarketCapitalization());
        assertEquals(0.32827, companyData.getEbitdaMargins());
        assertEquals("The EBITDA Margin is relatively high, signifying healthy profit margins for the company.", companyData.getEbitdaMarginsAnalysis());
        assertEquals(199.418, companyData.getDebtToEquity());
        assertEquals("The company's Debt to Equity ratio is high, indicating it has much more debt than equity, which is unfavorable.", companyData.getDebtToEquityAnalysis());
        assertEquals(-0.007, companyData.getRevenueGrowth());
        assertEquals("The Revenue Growth is negative, indicating concerning or negative trends for the company.", companyData.getRevenueGrowthAnalysis());
        assertEquals(0.21440963569073251, companyData.getFreeCashFlowMargin());
        assertEquals("The FCF Margin is very high, signifying large potential profitability for the company.", companyData.getFreeCashFlowMarginAnalysis());
        assertEquals(5.219588171255193, companyData.getFreeCashFlowPerShare());
        assertEquals("The FCF Per Share is very high, signifying satisfaction of all its debt obligations, including dividend payouts.", companyData.getFreeCashFlowPerShareAnalysis());
        assertEquals(0.027293391399577458, companyData.getFreeCashFlowYield());
        assertEquals("The FCF Yield is very small, and may not warrant further research on the company as value is low.", companyData.getFreeCashFlowYieldAnalysis());
        assertEquals("2023-11-16", companyData.getDividendDate());
        assertEquals("2023-11-10", companyData.getExDividendDate());
        assertEquals("2024-01-31", companyData.getEarningsDate());
    }
    @Test

    void companyInfoValidCompanyMissingInfoTest() { // Case 2: Valid company but missing data. Test also covers some cases of nullCompany by checking for null attributes.
        HashMap<String, Object> FinDataHashmap = new HashMap<>();
        FinDataHashmap.put("freeCashFlowPerShare", null);
        FinDataHashmap.put("freeCashFlowPerShareAnalysis", null);
        FinDataHashmap.put("marketCapitalization", 4.627804927744376E11);
        FinDataHashmap.put("revenueGrowthAnalysis", "The Revenue Growth is very high, signifying healthy growth for the company.");
        FinDataHashmap.put("freeCashFlowMarginAnalysis", null);
        FinDataHashmap.put("currentPrice", 156.84);
        FinDataHashmap.put("debtToEquityAnalysis", null);
        FinDataHashmap.put("freeCashFlowMargin", null);
        FinDataHashmap.put("freeCashFlow", null);
        FinDataHashmap.put("ebitdaMargins", null);
        FinDataHashmap.put("debtToEquity", null);
        FinDataHashmap.put("freeCashFlowYield", null);
        FinDataHashmap.put("ebitdaMarginsAnalysis", null);
        FinDataHashmap.put("freeCashFlowYieldAnalysis", null);
        FinDataHashmap.put("revenuePerShare", 48.271);
        FinDataHashmap.put("totalSharesOutstanding", 2.950653486192538E9);
        FinDataHashmap.put("totalRevenue", 142430994432L);
        FinDataHashmap.put("revenueGrowth", 0.231);
        FinDataHashmap.put("dividendDate", "2023-10-31");
        FinDataHashmap.put("exDividendDate", "2023-10-05");
        FinDataHashmap.put("earningsDate", "2024-01-12");
        CompanyData companyData = CompanyDataFactory.createNewCompany("JPM", FinDataHashmap);
        assertTrue(companyData.isValidCompany());
        assertEquals("JPM", companyData.getTicker());
        assertEquals("2023-12-02", companyData.getTimeFetched());
        assertEquals(156.84, companyData.getCurrentPrice());
        assertNull(companyData.getFreeCashFlow());
        assertEquals(142430994432L, companyData.getTotalRevenue());
        assertEquals(48.271, companyData.getRevenuePerShare());
        assertEquals(2.950653486192538E9, companyData.getTotalSharesOutstanding());
        assertEquals(4.627804927744376E11, companyData.getMarketCapitalization());
        assertNull(companyData.getEbitdaMargins());
        assertNull(companyData.getEbitdaMarginsAnalysis());
        assertNull(companyData.getDebtToEquity());
        assertNull(companyData.getDebtToEquityAnalysis());
        assertEquals(0.231, companyData.getRevenueGrowth());
        assertEquals("The Revenue Growth is very high, signifying healthy growth for the company.", companyData.getRevenueGrowthAnalysis());
        assertNull(companyData.getFreeCashFlowMargin());
        assertNull(companyData.getFreeCashFlowMarginAnalysis());
        assertNull(companyData.getFreeCashFlowPerShare());
        assertNull(companyData.getFreeCashFlowPerShareAnalysis());
        assertNull(companyData.getFreeCashFlowYield());
        assertNull(companyData.getFreeCashFlowYieldAnalysis());
        assertEquals("2023-10-31", companyData.getDividendDate());
        assertEquals("2023-10-05", companyData.getExDividendDate());
        assertEquals("2024-01-12", companyData.getEarningsDate());
    }
}
