package src;

import okhttp3.*;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://yahoo-finance15.p.rapidapi.com/api/yahoo/qu/quote/AAPL/financial-data")
                .get()
                .addHeader("X-RapidAPI-Key", "e76b123b18msh7e298fdfd0b1bbep11a821jsn4dfea0e597e8")
                .addHeader("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();

    }
}