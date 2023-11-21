package data_access;

import use_case.RefreshButton.RefreshDataAccessInterface;

public class RefreshDataAccessObject extends GetYahooFinanceApiData implements RefreshDataAccessInterface {
    public RefreshDataAccessObject() {
        super();
    }
    @Override
    public void refresh() {

    }
}
