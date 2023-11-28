package data_access;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConvertToJSONService {
    public static JSONObject convertToJSONObject(String jsonObject) throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(jsonObject);
    }
}