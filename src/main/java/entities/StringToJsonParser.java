package entities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StringToJsonParser {
    public final String jsonObject;

    public StringToJsonParser(String jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JSONObject parseJson() throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(this.jsonObject);
    }
}
