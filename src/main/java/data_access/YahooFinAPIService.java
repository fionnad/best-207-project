package data_access;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class YahooFinAPIService {
    public static String getFinData(String ticker) {
        try {
            OkHttpClient client = new OkHttpClient();
            String url = String.format("https://yahoo-finance15.p.rapidapi.com/api/v1/markets/stock/modules?ticker=%s&module=financial-data", ticker);

            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .addHeader("X-RapidAPI-Key", "7aa0af6cf0mshc69956a71e31b89p19cb70jsn7137ce116466")
                    .addHeader("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
                    .build();

            Response response = client.newCall(request).execute();
            assert response.body() != null;
            return response.body().string();

        } catch (IOException e) {
            return "Error";
        }
    }
}
