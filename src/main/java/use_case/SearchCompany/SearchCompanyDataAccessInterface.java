package use_case.SearchCompany;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.HashMap;

public interface SearchCompanyDataAccessInterface {
    String getFinData();
    HashMap<String, Object> getParsedFinData();
}
