package entities;

import data_access.ConvertToJSONService;
import data_access.YahooFinAPIService;
import data_access.YahooFinDatesService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.time.LocalTime;
import java.util.HashMap;

public class CompanyDataFactory {
    public static CompanyData execute(String ticker) {
        try {
            String finData = YahooFinAPIService.getFinData(ticker);
            String eventData = YahooFinDatesService.getEconomicEvents(ticker);
            JSONObject finJSONObject = ConvertToJSONService.convertToJSONObject(finData);
            JSONObject eventJSONObject = ConvertToJSONService.convertToJSONObject(eventData);
            if (finJSONObject.containsKey("message")) {
                return createNullCompany(ticker);
            } else {
                HashMap<String, Object> finJsonData = extractCompanyFinInfo((JSONObject) finJSONObject.get("body"), (JSONObject) eventJSONObject.get("body"));
                return createNewCompany(ticker, finJsonData);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static CompanyData createNullCompany(String ticker) {
        return new CompanyData(false,
                ticker,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    public static CompanyData createNewCompany(String ticker, HashMap<String, Object> companyFinData) {
        return new CompanyData(true,
                ticker,
                LocalTime.now().toString(),
                (Double) companyFinData.get("currentPrice"),
                (Long) companyFinData.get("freeCashFlow"),
                (Long) companyFinData.get("totalRevenue"),
                (Double) companyFinData.get("revenuePerShare"),
                (Double) companyFinData.get("totalSharesOutstanding"),
                (Double) companyFinData.get("marketCapitalization"),
                (Double) companyFinData.get("ebitdaMargins"),
                (String) companyFinData.get("ebitdaMarginsAnalysis"),
                (Double) companyFinData.get("debtToEquity"),
                (String) companyFinData.get("debtToEquityAnalysis"),
                (Double) companyFinData.get("revenueGrowth"),
                (String) companyFinData.get("revenueGrowthAnalysis"),
                (Double) companyFinData.get("freeCashFlowMargin"),
                (String) companyFinData.get("freeCashFlowMarginAnalysis"),
                (Double) companyFinData.get("freeCashFlowPerShare"),
                (String) companyFinData.get("freeCashFlowPerShareAnalysis"),
                (Double) companyFinData.get("freeCashFlowYield"),
                (String) companyFinData.get("freeCashFlowYieldAnalysis"),
                (String) companyFinData.get("earningsDate"),
                (String) companyFinData.get("dividendDate"),
                (String) companyFinData.get("exDividendDate"));
    }

    public static HashMap<String, Object> extractCompanyFinInfo(JSONObject jsonFinData, JSONObject jsonEventData) {
        HashMap<String, Object> finDataHashMap = new HashMap<>();
        HashMap<String, String> eventDataHashMap = extractCompanyEventData(jsonEventData);
        finDataHashMap.put("currentPrice", validateDouble(jsonFinData.get("currentPrice")));
        finDataHashMap.put("freeCashFlow", validateLong(jsonFinData.get("freeCashflow")));
        finDataHashMap.put("totalRevenue", validateLong(jsonFinData.get("totalRevenue")));
        finDataHashMap.put("revenueGrowth", validateDouble(jsonFinData.get("revenueGrowth")));
        finDataHashMap.put("ebitdaMargins", validateDouble(jsonFinData.get("ebitdaMargins")));
        finDataHashMap.put("debtToEquity", validateDouble(jsonFinData.get("debtToEquity")));
        finDataHashMap.put("revenuePerShare", validateDouble(jsonFinData.get("revenuePerShare")));
        finDataHashMap.put("totalSharesOutstanding", calculate("division", (Long) finDataHashMap.get("totalRevenue"), (Double) finDataHashMap.get("revenuePerShare")));
        finDataHashMap.put("marketCapitalization", calculate("multiplication", (Double) finDataHashMap.get("currentPrice"), (Double) finDataHashMap.get("totalSharesOutstanding")));
        finDataHashMap.put("freeCashFlowMargin", calculate("division", (Long) finDataHashMap.get("freeCashFlow"), (Long) finDataHashMap.get("totalRevenue")));
        finDataHashMap.put("freeCashFlowPerShare", calculate("division", (Long) finDataHashMap.get("freeCashFlow"), (Double) finDataHashMap.get("totalSharesOutstanding")));
        finDataHashMap.put("freeCashFlowYield", calculate("division", (Long) finDataHashMap.get("freeCashFlow"), (Double) finDataHashMap.get("marketCapitalization")));
        finDataHashMap.put("ebitdaMarginsAnalysis", analyzeEbitdaMargins((Double) finDataHashMap.get("ebitdaMargins")));
        finDataHashMap.put("debtToEquityAnalysis", analyzeDebtToEquity((Double) finDataHashMap.get("debtToEquity")));
        finDataHashMap.put("revenueGrowthAnalysis", analyzeRevenueGrowth((Double) finDataHashMap.get("revenueGrowth")));
        finDataHashMap.put("freeCashFlowMarginAnalysis", analyzeFreeCashFlowMargin((Double) finDataHashMap.get("freeCashFlowMargin")));
        finDataHashMap.put("freeCashFlowPerShareAnalysis", analyzeFreeCashFlowPerShare((Double) finDataHashMap.get("freeCashFlowPerShare")));
        finDataHashMap.put("freeCashFlowYieldAnalysis", analyzeFreeCashFlowYield((Double) finDataHashMap.get("freeCashFlowYield")));
        finDataHashMap.put("earningsDate", eventDataHashMap.get("earningsDate"));
        finDataHashMap.put("dividendDate", eventDataHashMap.get("dividendDate"));
        finDataHashMap.put("exDividendDate", eventDataHashMap.get("exDividendDate"));
        return finDataHashMap;
    }

    public static HashMap<String, String> extractCompanyEventData(JSONObject jsonObject) {
        HashMap<String, String> eventDataHashMap = new HashMap<>();
        JSONObject earnings = (JSONObject) jsonObject.get("earnings");
        JSONArray earningsDateArray = (JSONArray) earnings.get("earningsDate");
        JSONObject earningsDateObject = (JSONObject) earningsDateArray.get(0);
        Object dividendDateObject = jsonObject.get("dividendDate");
        Object exDividendDateObject =  jsonObject.get("exDividendDate");
        eventDataHashMap.put("earningsDate", (String) earningsDateObject.get("fmt"));

        if (nullCheckFinData(dividendDateObject)) {
            eventDataHashMap.put("dividendDate", "N/A");
        }

        else {
            JSONObject dividendDateJSONObject = (JSONObject) dividendDateObject;
            eventDataHashMap.put("dividendDate", (String) dividendDateJSONObject.get("fmt"));
        }

        if (nullCheckFinData(exDividendDateObject)) {
            eventDataHashMap.put("earningsDate", "N/A");
        }
        else {
            JSONObject exDividendDateJSONObject = (JSONObject) exDividendDateObject;
            eventDataHashMap.put("exDividendDate", (String) exDividendDateJSONObject.get("fmt"));
        }

        return eventDataHashMap;
    }

    public static Double calculate(String operation, Number input1, Number input2) {
        if (input1 == null || input2 == null) { // This is to catch the case such that one of the input variables doesn't exist, thus the formulation isn't possible.
            return null;
        } else if (operation.equals("division")) {
            return ((Number) input1).doubleValue() / ((Number) input2).doubleValue();
        } else {
            return ((Number) input1).doubleValue() * ((Number) input2).doubleValue();
        }
    }

    public static Double validateDouble(Object object) {
        if (nullCheckFinData(object)) {
            return null;
        } else {
            JSONObject newObject = (JSONObject) object;
            try {
                return (double) newObject.get("raw");
            } catch (ClassCastException e) {
                long number = (long) newObject.get("raw");
                return number * 1.0;
            }
        }
    }

    public static Long validateLong(Object object) {
        if (nullCheckFinData(object)) {
            return null;
        } else {
            JSONObject newObject = (JSONObject) object;
            return (Long) newObject.get("raw");
        }
    }

    public static boolean nullCheckFinData(Object object) {
        if (object instanceof JSONArray) { // Case 1: Within an existing company JSON, variable data is missing. The API returns this as [].
            return true;
        } else {
            JSONObject newObject = (JSONObject) object;
            // Case 2: Within an existing company JSON, an output variable with missing input variables would produce "0.00%". This is an error and must be caught.
            return newObject.get("fmt").equals("0.00%");
        }
    }

    public static String analyzeEbitdaMargins(Double number) {
        if (number == null) {
            return null;
        } else {
            if (number < 0) {
                return "The EBITDA Margin is negative, indicating it's operating profitability is less then it's revenue.";
            } else if (number >= 0 && number <= 0.1) {
                return "The EBITDA Margin very narrow, indicating a very small difference between operating profitable and revenue.";
            } else {
                return "The EBITDA Margin is relative high, signifying healthy profit margins for the company";
            }
        }
    }

    public static String analyzeDebtToEquity(Double number) {
        if (number == null) {
            return null;
        } else {
            if (number < 80) {
                return "The company's Debt to Equity ratio is low, indicates it has much more equity than debt, which is favorable.";
            } else if (number >= 80 && number <= 120) {
                return "The company's Debt to Equity ratio is near 100%, indicating it has near equal amounts of debt and equity.";
            } else {
                return "The company's Debt to Equity ratio is high, indicating it has much more debt than equity, which is unfavorable.";
            }
        }
    }

    public static String analyzeRevenueGrowth(Double number) {
        if (number == null) {
            return null;
        } else {
            if (number < 0) {
                return "The Revenue Growth is negative, indicating concerning or negative trends for the company.";
            } else if (number >= 0 && number <= 0.1) {
                return "The Revenue Growth is very narrow, indicating stability for the company.";
            } else {
                return "The Revenue Growth is very high, signifying healthy growth for the company.";
            }
        }
    }

    public static String analyzeFreeCashFlowMargin(Double number) {
        if (number == null) {
            return null;
        } else {
            if (number < 0.05) {
                return "The FCF Margin is very small, indicating poor financial health and operational efficiency.";
            } else if (number >= 0.05 && number <= 0.15) {
                return "The FCF Margin is stable, indicating stable financial health and operational efficiency.";
            } else {
                return "The FCF Margin is very high, signifying large potential profitability for the company.";
            }
        }
    }

    public static String analyzeFreeCashFlowPerShare(Double number) {
        if (number == null) {
            return null;
        } else {
            if (number < 0.05) {
                return "The FCF Per Share is very small, indicating an inability to meet financial and debt obligations.";
            } else if (number >= 0.05 && number <= 0.15) {
                return "The FCF Per Share is stable, indicating only satisfactory cash to satisfy some debt obligations.";
            } else {
                return "The FCF Per Share is very high, signifying satisfaction of all its debt obligations, including dividend payouts.";
            }
        }
    }

    public static String analyzeFreeCashFlowYield(Double number) {
        if (number == null) {
            return null;
        } else {
            if (number < 0.04) {
                return "The FCF Yield is very small, and may not warrant further research on the company as value is low.";
            } else if (number >= 0.04 && number <= 0.1) {
                return "The FCF Yield stable, indicating possible growth for the company as value is neutral.";
            } else {
                return "The FCF Yield very high, signifying strong value for return on stock.";
            }
        }
    }
}