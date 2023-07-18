package inventory.services;

import java.io.BufferedReader;
import java.io.FileReader;
import org.json.JSONObject;


/**
 * Helper class to parse JSON files
 * @author gaut2172
 *
 */
public class JsonParser {

	/**
	 * Read a JSON file
	 * @param path - directory path of the file
	 * @return JSONObject of key/values in file
	 */
	public static JSONObject readJson(String path) {
		JSONObject jsonObject = null;
	
		try {
			String jsonData = readFile(path);
			jsonObject = new JSONObject(jsonData);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return jsonObject;
	}

	/**
	 * Read file into a string
	 * @param filename - path to file
	 * @return string version of the file
	 */
	public static String readFile(String filename) {
	    String result = "";
	    try {
	        BufferedReader br = new BufferedReader(new FileReader(filename));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	        }
	        result = sb.toString();
	        br.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	}
