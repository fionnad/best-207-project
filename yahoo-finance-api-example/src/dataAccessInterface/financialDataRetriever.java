package src.dataAccessInterface;


public class financialDataRetriever {
    public String ticker;
    public String urlMain;

    public financialDataRetriever(String companyTicker) {
        this.ticker = companyTicker;
        this.urlMain = String.format("https://yahoo-finance15.p.rapidapi.com/api/yahoo/qu/quote/%s/financial-data", this.ticker);
    }


}
