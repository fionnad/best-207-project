package data_access;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class YahooFinAPIService {
    public static String getFinData(String ticker) {
        try {
            OkHttpClient client = new OkHttpClient();
            String url = String.format("https://yahoo-finance15.p.rapidapi.com/api/yahoo/qu/quote/%s/financial-data", ticker);

            Request request = new Request.Builder()
                    .url(url)
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
}
