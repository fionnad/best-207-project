package use_case.RefreshButton;

import entities.CompanyData;

import java.util.TreeMap;

public interface RefreshDataAccessInterface {
    String[] refresh();

    String getFinData(String ticker);
}
