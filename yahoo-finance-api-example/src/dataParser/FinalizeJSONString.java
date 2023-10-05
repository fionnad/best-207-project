package src.dataParser;

import src.dataAccessInterface.FinDataRetriever;

import java.io.IOException;

public class FinalizeJSONString {
    public String companyName;
    public String companyTicker;
    public String companyIndustry;
    public String finDataString;

    public FinalizeJSONString(String companyNameStr, String companyTickerStr, String companyIndustryStr, String finDataJson) {
        this.companyName = companyNameStr;
        this.companyTicker = companyTickerStr;
        this.companyIndustry = companyIndustryStr;
        this.finDataString = finDataJson;
    }

    public String OutputString() throws IOException {
        String prefix = "{\n    \"symbol\": \"" + this.companyTicker + "\",\n    \"company\": \"" + this.companyName + "\",\n    \"industry\": \"" + this.companyIndustry + "\",\n    \"link\": \" https://finance.yahoo.com/quote/" + this.companyTicker + "/ \",\n";
        FinDataRetriever finDataRetriever = new FinDataRetriever(this.companyTicker);
        String finData = finDataRetriever.getFinData();
        StringBuilder stringBuilder = new StringBuilder(finData);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(0);
        String resultString = stringBuilder.toString();
        return prefix + resultString + "\n";
    }
}
