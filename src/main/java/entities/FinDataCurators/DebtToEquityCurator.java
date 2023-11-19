package entities.FinDataCurators;
import org.json.simple.JSONObject;

import java.math.BigDecimal;

public class DebtToEquityCurator {
    public Object debtToEquity;
    public String debtToEquityPercentange;
    public String debtToEquityComment = "";
    public DebtToEquityCurator(JSONObject debtToEquity) {
        if (debtToEquity.isEmpty() || debtToEquity.get("raw").equals(0)) {
            this.debtToEquity = "No Data";
            this.debtToEquityPercentange = "No Data";
            this.debtToEquityComment = "No Data";
        } else {
            this.debtToEquity = debtToEquity.get("raw");
            this.debtToEquityPercentange = (String) debtToEquity.get("fmt");
            this.debtToEquityComment = DebtToEquityCommentDetermination();
        }
        System.out.println(this.debtToEquity);
    }

    public String DebtToEquityCommentDetermination() {
        if (this.debtToEquity instanceof String) {
            return "No data, so no interpretation can be determined.";
        } else {
            double debtToEquityValue = Double.parseDouble(this.debtToEquity.toString());

            if (debtToEquityValue < 80) {
                return "The company's debtToEquity ratio is low, indicates it has much more equity than debt, which is favorable.";
            } else if (debtToEquityValue >= 80 && debtToEquityValue <= 120) {
                return "The company's debtToEquity ratio is near 100%, indicating it has near equal amounts of debt and equity.";
            } else {
                return "The company's debtToEquity ratio is high, indicating it has much more debt than equity, which is unfavorable.";
            }
        }
    }
}
