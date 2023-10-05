package src.dataParser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParseCSVData {
    public String filename;

    public ParseCSVData(String filenameCSV) {
        this.filename = filenameCSV;
    }
    public ArrayList<ArrayList<String>> parseData() {
        ArrayList<ArrayList<String>> companies = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(this.filename))) {
            // Read the CSV file line by line
            String[] nextRecord;

            while ((nextRecord = reader.readNext()) != null) {
                ArrayList<String> aCompany = new ArrayList<>();
                // Assuming your CSV has three columns: symbol, company, industry
                aCompany.add(nextRecord[0]);
                aCompany.add(nextRecord[1]);
                aCompany.add(nextRecord[2]);
                companies.add(aCompany);

            }
            companies.remove(0);
            return companies;
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
