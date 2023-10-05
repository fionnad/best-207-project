package src;

import src.dataAccessInterface.FinDataRetriever;
import src.dataParser.FinalizeJSONString;
import src.dataParser.ParseCSVData;

import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        ParseCSVData companiesArray = new ParseCSVData("Top Companies By Marketcap.csv");
        ArrayList<ArrayList<String>> companies = companiesArray.parseData();

        for (int i = 0; i < 3; i++) {
            FinDataRetriever finDataRetriever = new FinDataRetriever(companies.get(i).get(0));
            String finDataString = finDataRetriever.getFinData();
            FinalizeJSONString finalizeJSONString = new FinalizeJSONString(companies.get(i).get(0), companies.get(i).get(1), companies.get(i).get(2), finDataString);
            System.out.println(finalizeJSONString.OutputString() + ',');
        }
    }

}