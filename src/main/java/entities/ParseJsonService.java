package entities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ParseJsonService {
    public final String jsonObject;

    public ParseJsonService(String jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JSONObject parseJson() throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(this.jsonObject);
    }
}
