package support;

import net.minidev.json.parser.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Config {

    public static String getJson(String filename) throws Exception {
        String file = System.getProperty("user.dir") + "/src/resources/" + filename + ".json";
        return readFileAsString(file);
    }

    public static String readFileAsString(String file) throws Exception {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

}
