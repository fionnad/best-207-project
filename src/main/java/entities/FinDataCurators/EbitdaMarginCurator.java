package entities.FinDataCurators;
import org.json.simple.JSONObject;

import java.math.BigDecimal;

public class EbitdaMarginCurator {
    public Object ebitdaMargins;
    public String ebitdaMarginsPercentage;
    public String ebitdaComment = "";
    public EbitdaMarginCurator(JSONObject ebitdaMarginsJson) {
        if (ebitdaMarginsJson.isEmpty() || ebitdaMarginsJson.get("raw").equals(0)) {
            this.ebitdaMargins = "No Data";
            this.ebitdaMarginsPercentage = "No Data";
            this.ebitdaComment = "No Data";
        } else {
            this.ebitdaMargins = ebitdaMarginsJson.get("raw");
            this.ebitdaMarginsPercentage = (String) ebitdaMarginsJson.get("fmt");
            this.ebitdaComment = EbitdaMarginCommentDetermination();
        }
    }

    public String EbitdaMarginCommentDetermination() {
        if (this.ebitdaMargins instanceof String) {
            return "No data, so no interpretation can be determined.";
        } else {
            double ebidtaMarginValue = Double.parseDouble(this.ebitdaMargins.toString());
            if (ebidtaMarginValue < 0) {
                return "The EBITDA Margin is negative, indicating it's operating profitability is less then it's revenue.";
            } else if (ebidtaMarginValue >= 0 && ebidtaMarginValue <= 0.1) {
                return "The EBITDA Margin very narrow, indicating a very small difference between operating profitable and revenue.";
            } else {
                return "The EBITDA Margin is relative high, signifying healthy profit margins for the company";
            }
        }
    }
}
