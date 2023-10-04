package src;

import okhttp3.*;
import src.dataAccessInterface.FinancialDataRetriever;

import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {
        FinancialDataRetriever financialDataRetriever = new FinancialDataRetriever("MSFT");
        System.out.println(financialDataRetriever.getFinancialData());
    }
}