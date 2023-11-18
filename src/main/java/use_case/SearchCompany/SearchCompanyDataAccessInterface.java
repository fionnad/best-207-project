package use_case.SearchCompany;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SearchCompanyDataAccessInterface {
    public String ticker;
    public String urlMain;

    public SearchCompanyDataAccessInterface(String companyTicker) {
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
            String jsonString = response.body().string();

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(jsonString);

            // quick demo on how to index through this object
            // might be easier ways of doing it, not 100% sure
            // say we wanted to get the current price:

            // JSONObject financialData = (JSONObject)json.get("financialData");
            // JSONObject currentPrice = (JSONObject)financialData.get("currentPrice");
            // double currPrice = (double)currentPrice.get("raw");
            // return currPrice;

            return json.get("financialData").toString();

        } catch (IOException e) {
            return "Error";
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }
    };
}
