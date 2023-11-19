package data_access;

import entities.FinDataCuratorService;
import entities.StringToJsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import use_case.SearchCompany.SearchCompanyDataAccessInterface;

public class GetYahooFinanceApiData implements SearchCompanyDataAccessInterface {
    public String ticker;
    public String urlMain;

    public GetYahooFinanceApiData(String companyTicker) {
        this.ticker = companyTicker;
        this.urlMain = String.format("https://yahoo-finance15.p.rapidapi.com/api/yahoo/qu/quote/%s/financial-data", this.ticker);
    }

    public String getFinData() {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(this.urlMain)
                    .get()
                    .addHeader("X-RapidAPI-Key", "9b0be126c5msh89b252e1f24238cp1ac534jsn35fcd4caef3e")
                    .addHeader("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
                    .build();

            Response response = client.newCall(request).execute();
            assert response.body() != null;
            return response.body().string();

        } catch (IOException e) {
            return "Error";
        }
    }

    @Override
    public HashMap<String, Object> getParsedFinData() {
        try {
            String finData = this.getFinData();
            StringToJsonParser stringToJsonParser = new StringToJsonParser(finData);
            JSONObject finJSONObject = stringToJsonParser.parseJson();
            FinDataCuratorService finDataCuratorService = new FinDataCuratorService(finJSONObject);
            return finDataCuratorService.retrieveFinData();
        } catch (ParseException e) {
            return null;
        }
    }
}
