package data_access;


import entities.CompanyData;
import entities.CompanyDataFactory;
import use_case.RefreshButton.RefreshDataAccessInterface;

import java.io.*;
import java.util.*;

public class RefreshDataAccessObject implements RefreshDataAccessInterface {
    private final File csvFile;
    private final File txtFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<Double, CompanyData> companies = new HashMap<>();
    private final CompanyDataFactory companyDataFactory;
    public RefreshDataAccessObject(String csvPath, String txtPath, CompanyDataFactory companyDataFactory) throws IOException {
        this.companyDataFactory = companyDataFactory;

        csvFile = new File(csvPath);
        txtFile = new File(txtPath);

        headers.put("Symbol", 0);
        headers.put("Ranking Value", 1);
        headers.put("Debt To Equity", 2);
        headers.put("Ebitda Margin", 3);
        headers.put("Revenue Growth", 4);
        headers.put("Free Cashflow Margin", 5);
        headers.put("Free Cashflow Per Share", 6);
        headers.put("Free Cashflow Yield", 7);
    }

    public CompanyData getParsedFinData(String ticker) {
        return CompanyDataFactory.execute(ticker);
    }

    @Override
    public String[] refresh() {
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

                    if (i == null) {
                        count += 0;
                    }
                    else {
                        count += i;
                    }

                }


                Double companyAverage = (count/6);

                companies.put(companyAverage, companyData);

            }
            reader.close();

            TreeMap<Double, CompanyData> sortedHashMap = sortbykey();

            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();
            for (Map.Entry<Double, CompanyData> companyData2 : sortedHashMap.entrySet()) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                        companyData2.getValue().getTicker() ,
                        companyData2.getKey(),
                        companyData2.getValue().getDebtToEquity(),
                        companyData2.getValue().getEbitdaMargins(),
                        companyData2.getValue().getRevenueGrowth(),
                        companyData2.getValue().getFreeCashFlowMargin(),
                        companyData2.getValue().getFreeCashFlowPerShare(),
                        companyData2.getValue().getFreeCashFlowYield());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

            int i = 0;
            String[] top5 = new String[5];
            Iterator<Map.Entry<Double, CompanyData>> iterator = sortedHashMap.entrySet().iterator();
            while (iterator.hasNext() && i < 5) {

                Map.Entry<Double, CompanyData> entry = iterator.next();
//                String key = entry.getKey();
//                String value = entry.getValue();
                top5[i] = entry.getValue().getTicker();
                i++;
            }
            return top5;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getFinData(String ticker) {
        return null;
    }

    public TreeMap<Double, CompanyData> sortbykey() {
        // TreeMap to store values of HashMap
        TreeMap<Double, CompanyData> sorted = new TreeMap<Double, CompanyData>(Comparator.reverseOrder());

        // Copy all data from hashMap into TreeMap
        sorted.putAll(companies);

        return sorted;

    }


}
