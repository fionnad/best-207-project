package src.dataAccessInterface;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class FinancialDataRetriever {
    public String ticker;
    public String urlMain;

    public FinancialDataRetriever(String companyTicker) {
        this.ticker = companyTicker;
        this.urlMain = String.format("https://yahoo-finance15.p.rapidapi.com/api/yahoo/qu/quote/%s/financial-data", this.ticker);
    }

    public String getFinancialData() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(this.urlMain)
                .get()
                .addHeader("X-RapidAPI-Key", "e76b123b18msh7e298fdfd0b1bbep11a821jsn4dfea0e597e8")
                .addHeader("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    };
}
