package entities.FinDataCurators;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EbitdaMarginCurator {
    public Object ebitdaMargins;
    public String ebitdaMarginsPercentage;
    public String ebitdaMarginsComment = "";

    public EbitdaMarginCurator(Object ebitdaMarginsObject) {
        if (ebitdaMarginsObject instanceof JSONArray) {
            this.ebitdaMargins = "No Data";
            this.ebitdaMarginsPercentage = "No Data";
            this.ebitdaMarginsComment = "No data, so no interpretation can be determined.";
        } else {
            JSONObject ebitdaMarginsJSON = (JSONObject) ebitdaMarginsObject;
            if (ebitdaMarginsJSON.get("fmt").equals("0.00%")) {
                this.ebitdaMargins = "No Data";
                this.ebitdaMarginsPercentage = "No Data";
                this.ebitdaMarginsComment = "No data, so no interpretation can be determined.";
            } else {
                this.ebitdaMargins = ebitdaMarginsJSON.get("raw").toString();
                this.ebitdaMarginsPercentage = (String) ebitdaMarginsJSON.get("fmt");
                this.ebitdaMarginsComment = EbitdaMarginCommentDetermination();
            }
        }
    }

    public String EbitdaMarginCommentDetermination() {
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
