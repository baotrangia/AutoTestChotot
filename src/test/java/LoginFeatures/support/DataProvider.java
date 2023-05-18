package LoginFeatures.support;

import com.github.javafaker.Faker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataProvider {

    static String pathFileReader = "src/test/resources/conf/single.conf.json";
    static String dataValue;

    public static final Faker faker = new Faker();
    public DataProvider(){

    }
    public String getData() throws IOException, FileNotFoundException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(new FileReader(pathFileReader));
        JSONArray array = new JSONArray();
        array.add(object);
        for (Object o :array )
        {
            JSONObject singleConfig = (JSONObject) o;
            dataValue = singleConfig.get("browserName").toString();
        }
        return dataValue;
    }
}
