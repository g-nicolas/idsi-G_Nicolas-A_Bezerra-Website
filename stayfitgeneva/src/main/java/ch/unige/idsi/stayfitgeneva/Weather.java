package ch.unige.idsi.stayfitgeneva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Weather {
	// URL for fetching weather data in json format
	String OPEN_WEATHER_MAP_API = "http://api.openweathermap.org/data/2.5/weather?q=Geneva,Switzerland&units=metric&lang=fr&APPID=de5d0a46fa1dacc1f431c25c2935d5e0";
	private ArrayList<String> weatherValues;
	// Constructor
	public Weather() throws IOException {
		// Set arraylist to 7 --> only need 7 values for now
		weatherValues = new ArrayList<String>(7);
		String stringJsonGeneva = getJSONfromURL(OPEN_WEATHER_MAP_API);
		//System.out.println(stringJsonGeneva);
		parseWeather(stringJsonGeneva);
		
	}
	/*
	 * Method for fetching json file from URL
	 * */
	public String getJSONfromURL(String url) throws IOException {
		// Initialize
        String resultString;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        // Fetching the JSON data from sitg
        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        resultString = response.toString();
        return resultString;
	}
	/*
	 * Method to json file (in string format) from parameter
	 * Use the library org.json
	 * */
	public void parseWeather(String stringJson)
	{
		// Initialize
        //try parse the string to a JSON object
        // That will give the entire string as a Json Object
		JSONObject jsonObject = new JSONObject(stringJson);
        // From there, pull out an individual array as a JsonArray
        JSONArray jsonArrayWeather = jsonObject.getJSONArray("weather");
		// Fetch data in {} of weather
		Object description = jsonArrayWeather.getJSONObject(0).get("description");
		Object main = jsonArrayWeather.getJSONObject(0).get("main");
		Object temp = jsonObject.getJSONObject("main").get("temp");
		Object temp_min = jsonObject.getJSONObject("main").get("temp_min");
		Object temp_max = jsonObject.getJSONObject("main").get("temp_max");
		Object pressure = jsonObject.getJSONObject("main").get("pressure");
		Object windSpeed = jsonObject.getJSONObject("wind").get("speed");
		
		weatherValues.add(description.toString());
		weatherValues.add(main.toString());
		weatherValues.add(temp.toString());
		weatherValues.add(temp_min.toString());
		weatherValues.add(temp_max.toString());
		weatherValues.add(pressure.toString());
		weatherValues.add(windSpeed.toString());
	}
	/*
	 * Method returning an ArrayList of weather data values 
	 * */
	public  ArrayList<String> getArrayListValues(){
		return weatherValues;
	}
}
