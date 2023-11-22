package use_case.RefreshButton;

public interface RefreshDataAccessInterface {
    void refresh();

    String getFinData(String ticker);
}
