package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyDataFactoryTest {

    public final String validTicker = "AAPL"; // Apple Company JSON contains all financial information
    public final String invalidTicker = "abcdefg";
    public final String validTickerMissingData = "JPM"; // J.P. Morgan Company JSON Contains only some financial information
    @Test
    void executeValidCompanyTest() {
        CompanyData companyData = CompanyDataFactory.execute(this.validTicker);
        Double currentPrice = companyData.getCurrentPrice();
        assertTrue(companyData.isValidCompany());
        assertEquals("AAPL", companyData.getTicker());
        assertTrue(currentPrice>100);
    }
    @Test
    void executeInvalidCompanyTest() {
        CompanyData companyData = CompanyDataFactory.execute(this.invalidTicker);
        assertFalse(companyData.isValidCompany());
    }

    @Test
    void executeValidCompanyMissingDataTest() {
        CompanyData companyData = CompanyDataFactory.execute(this.validTickerMissingData);
        assertTrue(companyData.isValidCompany());
        assertEquals("JPM", companyData.getTicker());
        assertNull(companyData.getFreeCashFlow());
    }

    @Test
    void analyzeDebtToEquityTest() {
        assertEquals(null, CompanyDataFactory.analyzeDebtToEquity(null));
        assertEquals("The company's Debt to Equity ratio is low, indicates it has much more equity than debt, which is favorable.", CompanyDataFactory.analyzeDebtToEquity(70.00));
        assertEquals("The company's Debt to Equity ratio is near 100%, indicating it has near equal amounts of debt and equity.", CompanyDataFactory.analyzeDebtToEquity(90.00));
        assertEquals("The company's Debt to Equity ratio is high, indicating it has much more debt than equity, which is unfavorable.", CompanyDataFactory.analyzeDebtToEquity(130.00));
    }

    @Test
    void analyzeRevenueGrowthTest() {
        assertEquals(null, CompanyDataFactory.analyzeRevenueGrowth(null));
        assertEquals("The Revenue Growth is negative, indicating concerning or negative trends for the company.", CompanyDataFactory.analyzeRevenueGrowth(-0.05));
        assertEquals("The Revenue Growth is very narrow, indicating stability for the company.", CompanyDataFactory.analyzeRevenueGrowth(0.05));
        assertEquals("The Revenue Growth is very high, signifying healthy growth for the company.", CompanyDataFactory.analyzeRevenueGrowth(0.15));
    }

    @Test
    void analyzeFreeCashFlowMarginTest() {
        assertEquals(null, CompanyDataFactory.analyzeFreeCashFlowMargin(null));
        assertEquals("The FCF Margin is very small, indicating poor financial health and operational efficiency.", CompanyDataFactory.analyzeFreeCashFlowMargin(0.049));
        assertEquals("The FCF Margin is stable, indicating stable financial health and operational efficiency.", CompanyDataFactory.analyzeFreeCashFlowMargin(0.05));
        assertEquals("The FCF Margin is very high, signifying large potential profitability for the company.", CompanyDataFactory.analyzeFreeCashFlowMargin(0.1501));
    }

    @Test
    void analyzeFreeCashFlowPerShareTest() {
        assertEquals(null, CompanyDataFactory.analyzeFreeCashFlowPerShare(null));
        assertEquals("The FCF Per Share is very small, indicating an inability to meet financial and debt obligations.", CompanyDataFactory.analyzeFreeCashFlowPerShare(0.049));
        assertEquals("The FCF Per Share is stable, indicating only satisfactory cash to satisfy some debt obligations.", CompanyDataFactory.analyzeFreeCashFlowPerShare(0.05));
        assertEquals("The FCF Per Share is very high, signifying satisfaction of all its debt obligations, including dividend payouts.", CompanyDataFactory.analyzeFreeCashFlowPerShare(0.1501));
    }

    @Test
    void analyzeFreeCashFlowYieldTest() {
        assertEquals(null, CompanyDataFactory.analyzeFreeCashFlowYield(null));
        assertEquals("The FCF Yield is very small, and may not warrant further research on the company as value is low.", CompanyDataFactory.analyzeFreeCashFlowYield(0.039));
        assertEquals("The FCF Yield stable, indicating possible growth for the company as value is neutral.", CompanyDataFactory.analyzeFreeCashFlowYield(0.05));
        assertEquals("The FCF Yield very high, signifying strong value for return on stock.", CompanyDataFactory.analyzeFreeCashFlowYield(0.1501));
    }
}