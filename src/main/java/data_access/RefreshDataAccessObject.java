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

    private final Map<Double, CompanyData> companies = new HashMap<>();
    private CompanyDataFactory companyDataFactory;
    public RefreshDataAccessObject(String csvPath, String txtPath, CompanyDataFactory companyDataFactory) throws IOException {
        this.companyDataFactory = companyDataFactory;

        csvFile = new File(csvPath);
        txtFile = new File(txtPath);

        headers.put("Symbol", 0);
        headers.put("Ranking Value", 1);
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
            return response.body().string();

        } catch (IOException e) {
            return "Error";
        }
    }

    public CompanyData getParsedFinData(String ticker) {
        try {
            System.out.println("0");
            String finData = getFinData(ticker);
            System.out.println("1");
            JSONObject finJSONObject = parseJson(finData);
            System.out.println("2");
            System.out.println("3");
            JSONObject financialData = (JSONObject) finJSONObject.get("financialData");
            System.out.println("4");
            JSONObject ebidtaMarginsJSON = (JSONObject) financialData.get("ebitdaMargins");
            Double ebidtaMargins = (Double) ebidtaMarginsJSON.get("raw");
            System.out.println("5");
            JSONObject revenueGrowthJSON = (JSONObject) financialData.get("revenueGrowth");
            Double revenueGrowth = (Double) revenueGrowthJSON.get("raw");

            JSONObject debtToEquityJSON = (JSONObject) financialData.get("debtToEquity");
            Double debtToEquity = (Double) debtToEquityJSON.get("raw");


            JSONObject freeCashFlowJSON = (JSONObject) financialData.get("freeCashflow");

            JSONObject totalRevenueJSON = (JSONObject) financialData.get("totalRevenue");

            JSONObject currentPriceJSON = (JSONObject) financialData.get("currentPrice");


            JSONObject revenuePerShareJSON = (JSONObject) financialData.get("revenuePerShare");
            ArrayList<Double> calculatedVariables = calculate((Long)freeCashFlowJSON.get("raw"), (Long)totalRevenueJSON.get("raw"), (Double)currentPriceJSON.get("raw"), (Double)revenuePerShareJSON.get("raw"));
            return companyDataFactory.create(ticker, ebidtaMargins, revenueGrowth, debtToEquity, calculatedVariables.get(0), calculatedVariables.get(1), calculatedVariables.get(2));

        } catch (ParseException e) {
            return null;
        }
    }

    public JSONObject parseJson(String finData) throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(finData);
    }

    public ArrayList<Double> calculate(Long freeCashFlow, Long totalRevenue, Double currentPrice, Double revenuePerShare) {
        ArrayList<Double> variables = new ArrayList<Double>();
        Long freeCashFlowMarginL = (freeCashFlow/totalRevenue);
        Double freeCashFlowMargin = freeCashFlowMarginL.doubleValue();
        Double freeCashFlowPerShare = (freeCashFlow/totalRevenue/revenuePerShare);
        Double freeCashFlowYield = (freeCashFlow/currentPrice*totalRevenue/revenuePerShare);
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
                companyData = getParsedFinData(row);
                Double count = 0.0;
                for (Double i : companyData.getAllFinData()) {
                    count += i;
                }
                Double companyAverage = (count/6);
                companies.put(companyAverage, companyData);

            }

            TreeMap<Double, CompanyData> sortedHashMap = sortbykey();


            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();


            for (Map.Entry<Double, CompanyData> companyData2 : sortedHashMap.entrySet()) {
                String line = String.format("%s,%s", companyData2.getValue().getSymbol() , companyData2.getKey());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public TreeMap<Double, CompanyData> sortbykey()
    {
        // TreeMap to store values of HashMap
        TreeMap<Double, CompanyData> sorted = new TreeMap<Double, CompanyData>();

        // Copy all data from hashMap into TreeMap
        sorted.putAll(companies);

        return sorted;

    }

}
