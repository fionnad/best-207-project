package data_access;


import entities.CompanyData;
import entities.CompanyDataFactory;
import use_case.RefreshButton.RefreshDataAccessInterface;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//TODO: should we make another use case where we have it update whatever is displayed?
public class RefreshDataAccessObject extends GetYahooFinanceApiData implements RefreshDataAccessInterface {
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


    @Override
    public void refresh() {
        BufferedWriter writer;
        BufferedReader reader;
        CompanyData companyData;

        try {
            reader = new BufferedReader(new FileReader(txtFile));
            String row;
            while ((row = reader.readLine()) != null) {
                companyData = companyDataFactory.create(row, calculateMarketcap(row));
                companies.put(companyData.getMarketcap(), companyData);
                //TODO: sort the hashmap wtf!?!?
            }


            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            //TODO: how to iterate through only n number of companies
            for (CompanyData companyData2 : companies.values()) {
                String line = String.format("%s,%s", companyData2.getSymbol() , companyData2.getMarketcap());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sort() {
        //TODO: sort the ugly ass hashmap? but class is not this one!
    }

    private Float calculateMarketcap(String symbol) {
        //TODO: implement method to calculate marketcap from given ticker (this is where we make api call)
        return null;
    }
}
