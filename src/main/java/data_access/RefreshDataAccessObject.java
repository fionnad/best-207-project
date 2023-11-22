package data_access;


import entities.CompanyData;
import entities.CompanyDataFactory;
import entities.FinDataCuratorService;
import entities.StringToJsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import use_case.RefreshButton.RefreshDataAccessInterface;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

//TODO: should we make another use case where we have it update whatever is displayed?
public class RefreshDataAccessObject implements RefreshDataAccessInterface {
    private final File csvFile;
    private final File txtFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<Float, CompanyData> companies = new HashMap<>();
    private CompanyDataFactory companyDataFactory;
    public RefreshDataAccessObject(String csvPath, File txtFile, CompanyDataFactory companyDataFactory) throws IOException {
        super();

        csvFile = new File(csvPath);
        this.txtFile = txtFile;

        headers.put("Symbol", 0);
        headers.put("Marketcap", 1);

        refresh();

        //if (csvFile.length() == 0) {
            //refresh();
        //} else {

            //TODO: do i even need this else statement?
            //try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                //String header = reader.readLine();

                //TODO: create exception.
                //assert header.equals("Symbol,Marketcap");
                //TODO: wtf does this even do?... update: new csv?
                //String row;
                //while ((row = reader.readLine()) != null) {
                    //String[] col = row.split(",");
                    //String symbol = String.valueOf(col[headers.get("Symbol")]);
                    //Float marketcap = Float.valueOf(col[headers.get("Marketcap")]);
                    //CompanyData companyData = companyDataFactory.create(symbol, marketcap);
                    //companies.put(companyData.getMarketcap(), companyData);
                //}
            //}
        //}
    }

    public String getFinData(String ticker) {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(String.format("https://yahoo-finance15.p.rapidapi.com/api/yahoo/qu/quote/%s/financial-data", ticker))
                    .get()
                    .addHeader("X-RapidAPI-Key", "9b0be126c5msh89b252e1f24238cp1ac534jsn35fcd4caef3e")
                    .addHeader("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
                    .build();

            Response response = client.newCall(request).execute();
            assert response.body() != null;
            return response.body().toString();

        } catch (IOException e) {
            return "Error";
        }
    }

    public CompanyData getParsedFinData(String ticker) {
        try {
            String finData = getFinData(ticker);
            StringToJsonParser stringToJsonParser = new StringToJsonParser(finData);
            JSONObject finJSONObject = stringToJsonParser.parseJson();
            JSONObject financialData = (JSONObject) finJSONObject.get("financialData");
            Float ebidta = (Float) financialData.get("ebidta");
            Float revenueGrowth = (Float) financialData.get("revenueGrowth");
            Float debtToEquity = (Float) financialData.get("debtToEquity");
            ArrayList<Float> calculatedVariables = calculate((Float)financialData.get("freeCashFlow"), (Float)financialData.get("totalRevenue"), (Float)financialData.get("currentPrice"), (Float)financialData.get("revenuePerShare"));

            return companyDataFactory.create(ticker, ebidta, revenueGrowth, debtToEquity, calculatedVariables.get(0), calculatedVariables.get(1), calculatedVariables.get(2));

        } catch (ParseException e) {
            return null;
        }
    }

    public ArrayList<Float> calculate(Float freeCashFlow, Float totalRevenue, Float currentPrice, Float revenuePerShare) {
        ArrayList<Float> variables = new ArrayList<Float>();
        Float freeCashFlowMargin = (freeCashFlow/totalRevenue);
        Float freeCashFlowPerShare = (freeCashFlow/totalRevenue/revenuePerShare);
        Float freeCashFlowYield = (freeCashFlow/currentPrice*totalRevenue/revenuePerShare);
        variables.add(freeCashFlowMargin);
        variables.add(freeCashFlowPerShare);
        variables.add(freeCashFlowYield);
        return variables;
    }



    @Override
    public void refresh() {
        BufferedWriter writer;
        BufferedReader reader;
        CompanyData companyData;

        try {
            reader = new BufferedReader(new FileReader(txtFile));
            String row;
            while ((row = reader.readLine()) != null) {
                // companyData = companyDataFactory.create(row, calculateMarketcap(row));
                // companies.put(companyData.getMarketcap(), companyData);
                //TODO: sort the hashmap wtf!?!?
            }

            sortbykey();


            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            //TODO: how to iterate through only n number of companies
            for (CompanyData companyData2 : companies.values()) {
                // String line = String.format("%s,%s", companyData2.getSymbol() , companyData2.getMarketcap());
                // writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void sortbykey()
    {
        // TreeMap to store values of HashMap
        TreeMap<Float, CompanyData> sorted = new TreeMap<Float, CompanyData>();

        // Copy all data from hashMap into TreeMap
        sorted.putAll(companies);
        System.out.println("treeMap : "+sorted);

    }




    private Float calculateMarketcap(String symbol) {
        //TODO: implement method to calculate marketcap from given ticker (this is where we make api call)
        return null;
    }
}
