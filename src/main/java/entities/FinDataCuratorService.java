package entities;

import entities.FinDataCurators.EbitdaMarginCurator;
import entities.FinDataCurators.DebtToEquityCurator;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.util.HashMap;

public class FinDataCuratorService {
    public JSONObject finJson;

    public FinDataCuratorService(JSONObject finDataJson) {
        this.finJson = finDataJson;
    }

    public HashMap<String, Object> retrieveFinData() {
        HashMap<String, Object> finDataHashMap = new HashMap<>();
        if (this.finJson.containsKey("error")) {
            finDataHashMap.put("containsErrorCheck", true);
        } else {
            JSONObject finJsonData = (JSONObject) this.finJson.get("financialData");
            EbitdaMarginCurator ebitdaMarginCurator = new EbitdaMarginCurator(finJsonData.get("ebitdaMargins"));
            DebtToEquityCurator debtToEquityCurator = new DebtToEquityCurator(finJsonData.get("debtToEquity"));

            finDataHashMap.put("containsErrorCheck", false);
            finDataHashMap.put("companyDataFetchTime", LocalDateTime.now().toString());
            finDataHashMap.put("companyEbitdaMargin", ebitdaMarginCurator.ebitdaMarginsPercentage);
            finDataHashMap.put("companyEbitdaMarginComment", ebitdaMarginCurator.ebitdaMarginsComment);
            finDataHashMap.put("companyDebtToEquity", debtToEquityCurator.debtToEquityPercentange);
            finDataHashMap.put("companyDebtToEquityComment", debtToEquityCurator.debtToEquityComment);
//        finDataHashMap.put("companyFcf");
//        finDataHashMap.put("companyMarketCap");
//        finDataHashMap.put("companyFcfMargin");
//        finDataHashMap.put("companyRevenueGrowth");
//        finDataHashMap.put("companyTotalSharesOutstanding");
//        finDataHashMap.put("companyFcfPerShare");
//        finDataHashMap.put("companyFcfYield");
        }

        return finDataHashMap;
    }
}
