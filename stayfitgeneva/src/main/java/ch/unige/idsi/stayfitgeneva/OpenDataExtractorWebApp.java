package ch.unige.idsi.stayfitgeneva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenDataExtractorWebApp {
	// HashMap to store values parsed: each line contains same values from its list
	HashMap<String, ArrayList<ArrayList<String>>> hashMapDataSet;
	// HashMap to store values parsed:each column contains same values from its list
	HashMap<String, ArrayList<ArrayList<String>>> hashMapAllDataSet;
	String catID;
	/*
	 * 	Constructor 1
	 *  Parse Everything (All URLs) when Class is created
	 *  
	 * */
	public OpenDataExtractorWebApp() throws JSONException, IOException{
		hashMapDataSet = new HashMap<>();
		hashMapAllDataSet = new HashMap<>();
		final String source_hike_trail = "http://ge.ch/ags1/rest/services/open_data/vector_layers/MapServer/149/query?text=&geometry=&geometryType=esriGeometryPoint&inSR=2056&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=0%3C1&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=4326&outFields=*&f=pjson";
        final String[] json_hike_trail = new String[1];
        json_hike_trail[0] = getJSONfromURL(source_hike_trail);
        parseJSON(1, json_hike_trail[0], "Parcours randonnée");
        
        final String source_bike_trail = "http://ge.ch/ags1/rest/services/open_data/vector_layers/MapServer/307/query?text=&geometry=&geometryType=esriGeometryPoint&inSR=2056&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=0%3C1&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=4326&outFields=*&f=pjson";
        final String[] json_bike_trail = new String[1];
        json_bike_trail[0] = getJSONfromURL(source_bike_trail);
        parseJSON(1, json_bike_trail[0], "Parcours vélo");
        
        final String source_sports_facilities_location = "http://ge.ch/ags1/rest/services/open_data/vector_layers/MapServer/428/query?text=&geometry=&geometryType=esriGeometryPoint&inSR=2056&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=0%3C1&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=4326&outFields=*&f=pjson";
        final String source_sports_facilities_trail = "http://ge.ch/ags1/rest/services/open_data/vector_layers/MapServer/429/query?text=&geometry=&geometryType=esriGeometryPoint&inSR=2056&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=0%3C1&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=4326&outFields=*&f=pjson";
        final String[] json_sports_facilities_trail = new String[1];
        final String[] json_sports_facilities_location = new String[1];
        json_sports_facilities_location[0] = getJSONfromURL(source_sports_facilities_location);
        json_sports_facilities_trail[0] = getJSONfromURL(source_sports_facilities_trail);
        parseJSON(1, json_sports_facilities_location[0], "Complexe sportif");
        parseJSON(2, json_sports_facilities_trail[0], "Complexe sportif");
        
        final String source_pharmacies = "http://ge.ch/ags1/rest/services/open_data/vector_layers/MapServer/80/query?text=&geometry=&geometryType=esriGeometryPoint&inSR=2056&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=0%3C1&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=4326&outFields=*&f=pjson";
        final String source_hospitals = "http://ge.ch/ags1/rest/services/open_data/vector_layers/MapServer/81/query?text=&geometry=&geometryType=esriGeometryPoint&inSR=2056&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=0%3C1&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=4326&outFields=*&f=pjson";
        final String[] json_pharmacies = new String[1];
        final String[] json_hospitals = new String[1];
        json_pharmacies[0] = getJSONfromURL(source_pharmacies);
        json_hospitals[0] = getJSONfromURL(source_hospitals);
        parseJSON(1, json_pharmacies[0], "Emplacement pharmacies");
        parseJSON(2, json_hospitals[0], "Emplacement pharmacies");
        
        final String source_terrasses = "http://ge.ch/ags1/rest/services/open_data/vector_layers/MapServer/430/query?text=&geometry=&geometryType=esriGeometryPoint&inSR=2056&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=0%3C1&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=4326&outFields=*&f=pjson";
        final String[] json_terrasses = new String[1];
        json_terrasses[0] = getJSONfromURL(source_terrasses);
        parseJSON(1, json_terrasses[0], "Terrasses de cafés");
	}
	/*
	 * 	Constructor 2
	 *  Parse Specific Category when Class is created due to parameter
	 * */
	public OpenDataExtractorWebApp(String category) throws IOException{
		hashMapDataSet = new HashMap<>();
		hashMapAllDataSet = new HashMap<>();
		switch (category) {
	        case "Parcours randonnée":
	        	final String source_hike_trail = "http://ge.ch/ags1/rest/services/open_data/vector_layers/MapServer/149/query?text=&geometry=&geometryType=esriGeometryPoint&inSR=2056&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=0%3C1&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=4326&outFields=*&f=pjson";
	            final String[] json_hike_trail = new String[1];
	            json_hike_trail[0] = getJSONfromURL(source_hike_trail);
	            parseJSON(1, json_hike_trail[0], "Parcours randonnée");
	            break;
	
	        case "Parcours vélo":
	        	final String source_bike_trail = "http://ge.ch/ags1/rest/services/open_data/vector_layers/MapServer/307/query?text=&geometry=&geometryType=esriGeometryPoint&inSR=2056&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=0%3C1&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=4326&outFields=*&f=pjson";
	            final String[] json_bike_trail = new String[1];
	            json_bike_trail[0] = getJSONfromURL(source_bike_trail);
	            parseJSON(1, json_bike_trail[0], "Parcours vélo");
	            break;
	
	        case "Complexe sportif":
	        	final String source_sports_facilities_location = "http://ge.ch/ags1/rest/services/open_data/vector_layers/MapServer/428/query?text=&geometry=&geometryType=esriGeometryPoint&inSR=2056&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=0%3C1&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=4326&outFields=*&f=pjson";
	            final String source_sports_facilities_trail = "http://ge.ch/ags1/rest/services/open_data/vector_layers/MapServer/429/query?text=&geometry=&geometryType=esriGeometryPoint&inSR=2056&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=0%3C1&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=4326&outFields=*&f=pjson";
	            final String[] json_sports_facilities_trail = new String[1];
	            final String[] json_sports_facilities_location = new String[1];
	            json_sports_facilities_location[0] = getJSONfromURL(source_sports_facilities_location);
	            json_sports_facilities_trail[0] = getJSONfromURL(source_sports_facilities_trail);
	            parseJSON(1, json_sports_facilities_location[0], "Complexe sportif");
	            parseJSON(2, json_sports_facilities_trail[0], "Complexe sportif");
	            break;
	
	        case "Emplacement pharmacies":
	        	final String source_pharmacies = "http://ge.ch/ags1/rest/services/open_data/vector_layers/MapServer/80/query?text=&geometry=&geometryType=esriGeometryPoint&inSR=2056&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=0%3C1&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=4326&outFields=*&f=pjson";
	            final String source_hospitals = "http://ge.ch/ags1/rest/services/open_data/vector_layers/MapServer/81/query?text=&geometry=&geometryType=esriGeometryPoint&inSR=2056&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=0%3C1&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=4326&outFields=*&f=pjson";
	            final String[] json_pharmacies = new String[1];
	            final String[] json_hospitals = new String[1];
	            json_pharmacies[0] = getJSONfromURL(source_pharmacies);
	            json_hospitals[0] = getJSONfromURL(source_hospitals);
	            parseJSON(1, json_pharmacies[0], "Emplacement pharmacies");
	            parseJSON(2, json_hospitals[0], "Emplacement pharmacies");
	            break;
	
	        case "Terrasses de cafés":
	        	final String source_terrasses = "http://ge.ch/ags1/rest/services/open_data/vector_layers/MapServer/430/query?text=&geometry=&geometryType=esriGeometryPoint&inSR=2056&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=0%3C1&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=4326&outFields=*&f=pjson";
	            final String[] json_terrasses = new String[1];
	            json_terrasses[0] = getJSONfromURL(source_terrasses);
	            parseJSON(1, json_terrasses[0], "Terrasses de cafés");
	            break;
		}
	}
	/*
	 * Method linking Methods: getJSONfromURL(link) & parseJSON(i, string_link[0], category);
	 * */
	public void getJSON(int i, String link, String category) throws JSONException, IOException{
		String[] string_link = new String[1];
		string_link[0] = getJSONfromURL(link);
		parseJSON(i, string_link[0], category);
	}
	/*
	 * Method returning arraylist hashMapDataSet
	 * */
	public HashMap<String, ArrayList<ArrayList<String>>> getHashMapDataSet(){
		return hashMapDataSet;
	}
	/*
	 * Method returning arraylist hashMapAllDataSet
	 * */
	public HashMap<String, ArrayList<ArrayList<String>>> getHashMapAllDataSet(){
		return hashMapAllDataSet;
	}
	/*
	 * Method for fetching json file from URL
	 * Returns a JSONObject type of object
	 * */
	public JSONObject getJSONObjectfromURL(String url) throws IOException {
		// Initialize
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        // Fetching the JSON data from sitg
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONObject jsonObject = new JSONObject(response.toString());
        return jsonObject;
	}
	/*
	 * Method for fetching json file from URL
	 * Returns a String type of object
	 * */
	private String getJSONfromURL(String url) throws IOException {
		// Initialize
        String resultString;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        // Fetching the JSON data from sitg
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
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
	private void parseJSON(int id, String json_String, String dataCat) throws IOException, JSONException{
		// Initialize
        //try parse the string to a JSON object
        // That will give the entire string as a Json Object
		JSONObject jsonObject = new JSONObject(json_String);
        // From there, pull out an individual array as a JsonArray
        JSONArray jsonArray = jsonObject.getJSONArray("features");
        // Access each object of the array under "features"
        switch (dataCat) {
        // Parse the category "Parcours randonnée"
        case "Parcours randonnée":
            if (id == 1) {
                ArrayList<ArrayList<String>> array_list = new ArrayList<>();
                ArrayList<String> allValuesTitle = new ArrayList<>();
                ArrayList<ArrayList<Double>> allValuesDoubleLat = new ArrayList<>();
                ArrayList<ArrayList<Double>> allValuesDoubleLng = new ArrayList<>();
                // Loop to iterate JSONArray
                for (int i = 0; i < jsonArray.length(); i++) {
                    ArrayList<String> objectValues = new ArrayList<>();
                    JSONObject object_JSON = jsonArray.getJSONObject(i);
                    // Access sub object "attributes" from the object "features"
                    JSONObject curr_JSONObject = object_JSON.getJSONObject("attributes");
                    String nom_itineraire = curr_JSONObject.getString("STATUT");
                    String no_itineraire = object_JSON.getJSONObject("attributes").optString("IDENTIFIANT");
                    JSONObject curr_JSONObject_geometry = object_JSON.getJSONObject("geometry");
                    String paths = curr_JSONObject_geometry.optString("paths");
                    objectValues.add(nom_itineraire);
                    objectValues.add(paths);
                    objectValues.add(no_itineraire);
                    array_list.add(objectValues);
                    String delims = "\\]+";
                    String[] paths_values = paths.split(delims);
                    ArrayList<Double> arrayDoubleLat = new ArrayList<>();
                    ArrayList<Double> arrayDoubleLng = new ArrayList<>();
					// Retrieve each set of polylines from path
                    for (String values : paths_values) {
                        values = values.trim();
                        // Case 1: Beginning of subArray in array Paths
                        if (values.startsWith(",[[")) {
                            // When a SubArray is found, Add the current array to paths
                            // Create a new current array
                            String[] stringCoordLatLong = values.split(",\\[\\[");
                            String[] coordLatLong = stringCoordLatLong[1].split(",");
                            arrayDoubleLat = new ArrayList<>();
                            arrayDoubleLng = new ArrayList<>();
                            arrayDoubleLat.add(Double.valueOf(coordLatLong[1]));
                            arrayDoubleLng.add(Double.valueOf(coordLatLong[0]));
                        }
                        // Case 2: Beginning of paths
                        else if (values.startsWith("[[[")) {
                            String[] stringCoordLatLong = values.split("\\[\\[\\[");
                            String[] coordLatLong = stringCoordLatLong[1].split(",");
                            arrayDoubleLat.add(Double.valueOf(coordLatLong[1]));
                            arrayDoubleLng.add(Double.valueOf(coordLatLong[0]));
                        }
                        // Case 3: Other LatLng Values
                        else {
                            String[] stringCoordLatLong = values.split(",\\[");
                            String[] coordLatLong = stringCoordLatLong[1].split(",");
                            arrayDoubleLat.add(Double.valueOf(coordLatLong[1]));
                            arrayDoubleLng.add(Double.valueOf(coordLatLong[0]));
                        }
                    }
                    allValuesTitle.add(nom_itineraire);
                    allValuesDoubleLat.add(arrayDoubleLat);
                    allValuesDoubleLng.add(arrayDoubleLng);
                }
                ArrayList valuesSet = new ArrayList();
                valuesSet.add(allValuesTitle);
                valuesSet.add(allValuesDoubleLat);
                valuesSet.add(allValuesDoubleLng);
                hashMapAllDataSet.put("HIKING_TRAIL", valuesSet);
                hashMapDataSet.put("HIKING_TRAIL", array_list);
            }
            break;
        // Parse the category 
        case "Parcours vélo":
            if (id == 1) {
                ArrayList<ArrayList<String>> array_list = new ArrayList<>();
                ArrayList<String> allValuesTitle = new ArrayList<>();
                ArrayList<ArrayList<String>> allValuesDoubleLat = new ArrayList<>();
                ArrayList<ArrayList<String>> allValuesDoubleLng = new ArrayList<>();
                //Log.v("CHECKPOINT", " HIKING TRAILS");
                int i = 0;
                // Loop to iterate JSONArray
                for (; i < jsonArray.length(); i++) {
                    ArrayList<String> objectValues = new ArrayList<>();
                    JSONObject object_JSON = jsonArray.getJSONObject(i);
                    // Access data from the object "attributes"
                    JSONObject curr_JSONObject = object_JSON.getJSONObject("attributes");
                    String nom_itineraire = curr_JSONObject.optString("NOM");
                    String type_itineraire = curr_JSONObject.optString("TYPE");
                    String statut_itineraire = curr_JSONObject.optString("STATUT");
                    JSONObject curr_JSONObject_geometry = object_JSON.getJSONObject("geometry");
                    String paths = curr_JSONObject_geometry.optString("paths");
                    objectValues.add(nom_itineraire);
                    objectValues.add(paths);
                    objectValues.add(type_itineraire);
                    objectValues.add(statut_itineraire);
                    array_list.add(objectValues);
                    String delims = "\\]+";
                    String[] paths_values = paths.split(delims);
                    ArrayList<String> arrayDoubleLat = new ArrayList<>();
                    ArrayList<String> arrayDoubleLng = new ArrayList<>();
                    // Retrieve each set of polylines from path
                    for (String values : paths_values) {
                        values = values.trim();
                        // Beginning of subArray in array Paths
                        if (values.startsWith(",[[")) {
                            // When a SubArray is found, Add the current array to paths
                            // Create a new current array
                            String[] stringCoordLatLong = values.split(",\\[\\[");
                            String[] coordLatLong = stringCoordLatLong[1].split(",");
                            arrayDoubleLat = new ArrayList<>();
                            arrayDoubleLng = new ArrayList<>();
                            arrayDoubleLat.add(coordLatLong[1]);
                            arrayDoubleLng.add(coordLatLong[0]);
                        }
                        // Beginning of paths
                        else if (values.startsWith("[[[")) {
                            String[] stringCoordLatLong = values.split("\\[\\[\\[");
                            String[] coordLatLong = stringCoordLatLong[1].split(",");
                            arrayDoubleLat.add(coordLatLong[1]);
                            arrayDoubleLng.add(coordLatLong[0]);
                        }
                        // Other LatLng Values
                        else {
                            String[] stringCoordLatLong = values.split(",\\[");
                            String[] coordLatLong = stringCoordLatLong[1].split(",");
                            arrayDoubleLat.add(coordLatLong[1]);
                            arrayDoubleLng.add(coordLatLong[0]);
                        }
                    }
                    allValuesTitle.add(nom_itineraire);
                    allValuesDoubleLat.add(arrayDoubleLat);
                    allValuesDoubleLng.add(arrayDoubleLng);
                }

                ArrayList valuesSet = new ArrayList();
                valuesSet.add(allValuesTitle);
                valuesSet.add(allValuesDoubleLat);
                valuesSet.add(allValuesDoubleLng);
                hashMapAllDataSet.put("BIKE_TRAIL", valuesSet);
                hashMapDataSet.put("BIKE_TRAIL", array_list);
            }
            break;

            // Parse the category
            case "Complexe sportif":
            if (id == 1) {
                ArrayList<ArrayList<String>> array_list = new ArrayList<>();
                ArrayList<String> allValuesTitle = new ArrayList<>();
                ArrayList<String> allValuesDoubleLat = new ArrayList<>();
                ArrayList<String> allValuesDoubleLng = new ArrayList<>();
                int i = 0;
                // Loop to iterate JSONArray
                for (; i < jsonArray.length(); i++) {
                    ArrayList<String> objectValues = new ArrayList<>();
                    JSONObject object_JSON = jsonArray.getJSONObject(i);
                    // Access data from the object "attributes"
                    JSONObject curr_JSONObject = object_JSON.getJSONObject("attributes");
                    String sport = curr_JSONObject.optString("SPORT");
                    String type = curr_JSONObject.optString("TYPE");
                    String commune = curr_JSONObject.optString("COMMUNE");
                    String lien_fiche_descriptive = curr_JSONObject.optString("LIEN_FICHE_DESCRIPTIVE");
                    JSONObject curr_JSONObject_geometry = object_JSON.getJSONObject("geometry");
                    String latitude = curr_JSONObject_geometry.optString("y");
                    String longitude = curr_JSONObject_geometry.optString("x");
                    objectValues.add(sport);
                    objectValues.add(latitude);
                    objectValues.add(longitude);
                    objectValues.add(type);
                    objectValues.add(commune);
                    objectValues.add(lien_fiche_descriptive);
                    array_list.add(objectValues);
                    allValuesTitle.add(sport);
                    allValuesDoubleLat.add(latitude);
                    allValuesDoubleLng.add(longitude);
                }
                ArrayList valuesSet = new ArrayList();
                valuesSet.add(allValuesTitle);
                valuesSet.add(allValuesDoubleLat);
                valuesSet.add(allValuesDoubleLng);
                hashMapAllDataSet.put("SPORTS_CENTER_LOCATION", valuesSet);
                hashMapDataSet.put("SPORTS_CENTER_LOCATION", array_list);
            } else if (id == 2) {
                ArrayList<ArrayList<String>> array_list = new ArrayList<>();
                ArrayList<String> allValuesTitle = new ArrayList<>();
                ArrayList<ArrayList<String>> allValuesDoubleLat = new ArrayList<>();
                ArrayList<ArrayList<String>> allValuesDoubleLng = new ArrayList<>();
                int i = 0;
                for (; i < jsonArray.length(); i++) {
                    ArrayList<String> objectValues = new ArrayList<>();
                    JSONObject object_JSON = jsonArray.getJSONObject(i);
                    // Access data from the object "attributes"
                    JSONObject curr_JSONObject = object_JSON.getJSONObject("attributes");
                    String designation = curr_JSONObject.optString("DESIGNATION");
                    String lien_fiche_descriptive = curr_JSONObject.optString("LIEN_FICHE_DESCRIPTIVE");
                    String promnb = curr_JSONObject.optString("PROMNB");
                    JSONObject curr_JSONObject_geometry = object_JSON.getJSONObject("geometry");
                    String paths = curr_JSONObject_geometry.optString("paths");
                    objectValues.add(designation);
                    objectValues.add(paths);
                    objectValues.add(lien_fiche_descriptive);
                    objectValues.add(promnb);
                    array_list.add(objectValues);
                    String delims = "\\]+";
                    String[] paths_values = paths.split(delims);
                    ArrayList<String> arrayDoubleLat = new ArrayList<>();
                    ArrayList<String> arrayDoubleLng = new ArrayList<>();
					// Retrieve each set of polylines from paths
                    for (String values : paths_values) {
                        values = values.trim();
                        // Beginning of subArray in array Paths
                        if (values.startsWith(",[[")) {
                            // When a SubArray is found, Add the current array to paths
                            // Create a new current array
                            String[] stringCoordLatLong = values.split(",\\[\\[");
                            String[] coordLatLong = stringCoordLatLong[1].split(",");
                            arrayDoubleLat = new ArrayList<>();
                            arrayDoubleLng = new ArrayList<>();
                            arrayDoubleLat.add(coordLatLong[1]);
                            arrayDoubleLng.add(coordLatLong[0]);
                        }
                        // Beginning of paths
                        else if (values.startsWith("[[[")) {
                            String[] stringCoordLatLong = values.split("\\[\\[\\[");
                            String[] coordLatLong = stringCoordLatLong[1].split(",");
                            arrayDoubleLat.add(coordLatLong[1]);
                            arrayDoubleLng.add(coordLatLong[0]);
                        }
                        // Other LatLng Values
                        else {
                            String[] stringCoordLatLong = values.split(",\\[");
                            String[] coordLatLong = stringCoordLatLong[1].split(",");
                            arrayDoubleLat.add(coordLatLong[1]);
                            arrayDoubleLng.add(coordLatLong[0]);
                        }
                    }
                    allValuesTitle.add(designation);
                    allValuesDoubleLat.add(arrayDoubleLat);
                    allValuesDoubleLng.add(arrayDoubleLng);
                }
                ArrayList valuesSet = new ArrayList();
                valuesSet.add(allValuesTitle);
                valuesSet.add(allValuesDoubleLat);
                valuesSet.add(allValuesDoubleLng);
                hashMapAllDataSet.put("SPORTS_CENTER_TRAIL", valuesSet);
                hashMapDataSet.put("SPORTS_CENTER_TRAIL", array_list);
            }
            break;
         // Parse the category
         case "Emplacement pharmacies":
            if (id == 1) {
                ArrayList<ArrayList<String>> array_list = new ArrayList<>();
                ArrayList<String> allValuesTitle = new ArrayList<>();
                ArrayList<String> allValuesDoubleLat = new ArrayList<>();
                ArrayList<String> allValuesDoubleLng = new ArrayList<>();
                int i = 0;
                // Loop to iterate JSONArray
                for (; i < jsonArray.length(); i++) {
                    ArrayList<String> objectValues = new ArrayList<>();
                    JSONObject object_JSON = jsonArray.getJSONObject(i);
                    // Access data from the object "attributes"
                    JSONObject curr_JSONObject = object_JSON.getJSONObject("attributes");
                    //String idPADR = curr_JSONObject.getString("IDPADR");
                    String pharmacie = curr_JSONObject.optString("PHARMACIE");
                    String adresse = curr_JSONObject.optString("ADRESSE");
                    String no_postal = curr_JSONObject.optString("NO_POSTAL");
                    String commune = curr_JSONObject.optString("COMMUNE");
                    String telephone = curr_JSONObject.optString("TELEPHONE");
                    String adr = adresse + ", " + no_postal + " " + commune;
                    JSONObject curr_JSONObject_geometry = object_JSON.getJSONObject("geometry");
                    String latitude = curr_JSONObject_geometry.optString("y");
                    String longitude = curr_JSONObject_geometry.optString("x");
                    objectValues.add(pharmacie);
                    objectValues.add(latitude);
                    objectValues.add(longitude);
                    objectValues.add(adr);
                    objectValues.add(no_postal);
                    objectValues.add(commune);
                    objectValues.add(telephone);
                    array_list.add(objectValues);
                    allValuesTitle.add(pharmacie);
                    allValuesDoubleLat.add(latitude);
                    allValuesDoubleLng.add(longitude);
                }
                //Log.e("ValueSTR", String.valueOf(array_list));
                ArrayList valuesSet = new ArrayList();
                valuesSet.add(allValuesTitle);
                valuesSet.add(allValuesDoubleLat);
                valuesSet.add(allValuesDoubleLng);
                hashMapAllDataSet.put("PHARMACIE", valuesSet);
                hashMapDataSet.put("PHARMACIE", array_list);
            } else if (id == 2) {
                ArrayList<ArrayList<String>> array_list = new ArrayList<>();
                ArrayList<String> allValuesTitle = new ArrayList<>();
                ArrayList<String> allValuesDoubleLat = new ArrayList<>();
                ArrayList<String> allValuesDoubleLng = new ArrayList<>();
                int i = 0;
                // Loop to iterate JSONArray
                for (; i < jsonArray.length(); i++) {
                    ArrayList<String> objectValues = new ArrayList<>();
                    JSONObject object_JSON = jsonArray.getJSONObject(i);
                    // Access data from the object "attributes"
                    JSONObject curr_JSONObject = object_JSON.getJSONObject("attributes");
                    String hopital = curr_JSONObject.optString("NOM_ETABLISSEMENT");
                    String adresse = curr_JSONObject.optString("ADRESSE");
                    String type_etablissement = curr_JSONObject.optString("TYPE_ETABLISSEMENT");
                    String telephone = curr_JSONObject.optString("TELEPHONE");
                    String fax = curr_JSONObject.optString("FAX");
                    String siteweb = curr_JSONObject.optString("SITE_WEB");
                    JSONObject curr_JSONObject_geometry = object_JSON.getJSONObject("geometry");
                    String latitude = curr_JSONObject_geometry.optString("y");
                    String longitude = curr_JSONObject_geometry.optString("x");
                    objectValues.add(hopital);
                    objectValues.add(latitude);
                    objectValues.add(longitude);
                    objectValues.add(adresse);
                    objectValues.add(type_etablissement);
                    objectValues.add(telephone);
                    objectValues.add(fax);
                    objectValues.add(siteweb);
                    array_list.add(objectValues);
                    allValuesTitle.add(hopital);
                    allValuesDoubleLat.add(latitude);
                    allValuesDoubleLng.add(longitude);
                }
                ArrayList valuesSet = new ArrayList();
                valuesSet.add(allValuesTitle);
                valuesSet.add(allValuesDoubleLat);
                valuesSet.add(allValuesDoubleLng);
                hashMapAllDataSet.put("HOPITAL", valuesSet);
                hashMapDataSet.put("HOPITAL", array_list);
            }
            break;
         // Parse the category
         case "Terrasses de cafés":
            if (id == 1) {
                ArrayList<ArrayList<String>> array_list = new ArrayList<>();
                ArrayList<String> allValuesTitle = new ArrayList<>();
                ArrayList<String> allValuesDoubleLat = new ArrayList<>();
                ArrayList<String> allValuesDoubleLng = new ArrayList<>();
                int i = 0;
                // Loop to iterate JSONArray
                for (; i < jsonArray.length(); i++) {
                    ArrayList<String> objectValues = new ArrayList<>();
                    JSONObject object_JSON = jsonArray.getJSONObject(i);
                    // Access data from the object "attributes"
                    JSONObject curr_JSONObject = object_JSON.getJSONObject("attributes");
                    String nom_cafe = curr_JSONObject.optString("NOM_CAFE");
                    String lieu = curr_JSONObject.optString("LIEU");
                    String no_adresse = curr_JSONObject.optString("NUMERO");
                    String no_terrasses = curr_JSONObject.optString("NO_TERRASSE");
                    String rive = curr_JSONObject.optString("RIVE");
                    String periode_debut = curr_JSONObject.optString("DEBUT");
                    String periode_fin = curr_JSONObject.optString("FIN");
                    String type_terrasse = curr_JSONObject.optString("OBJET");
                    
                    String adr = clean_Addresse(lieu) + " " + no_adresse + ", Genève";
                    JSONObject curr_JSONObject_geometry = object_JSON.getJSONObject("geometry");
                    String latitude = curr_JSONObject_geometry.optString("y");
                    String longitude = curr_JSONObject_geometry.optString("x");
                    String periode = periode_debut + " -- " + periode_fin;
                    objectValues.add(nom_cafe);
                    objectValues.add(latitude);
                    objectValues.add(longitude);
                    objectValues.add(adr);
                    objectValues.add(no_terrasses);
                    objectValues.add(rive);
                    objectValues.add(periode);
                    objectValues.add(type_terrasse);
                    array_list.add(objectValues);
                    allValuesTitle.add(nom_cafe);
                    allValuesDoubleLat.add(latitude);
                    allValuesDoubleLng.add(longitude);
                    // Limite le nombre d'objet Terrasses ==> trop de points concentrés sinon
                    if (i>500){
                    	break;
                    }
                }
                ArrayList valuesSet = new ArrayList();
                valuesSet.add(allValuesTitle);
                valuesSet.add(allValuesDoubleLat);
                valuesSet.add(allValuesDoubleLng);
                hashMapAllDataSet.put("TERRASSES", valuesSet);
                hashMapDataSet.put("TERRASSES", array_list);
            }
            break;
        }
	}
	public String clean_Addresse(String lieu) {
        String[] parts = lieu.split(", ");
        if (parts.length < 2) {
            return lieu;
        } else {
            String beforeFirstDot = parts[0];
            String afterFirstDot = parts[1];
            if (Character.isLetterOrDigit(afterFirstDot.charAt(afterFirstDot.length() - 1))) {
                return afterFirstDot + " " + beforeFirstDot;
            } else {
                return afterFirstDot + beforeFirstDot;
            }
        }
    }
	// Unused method due to restrictions...
	/*
	 * Unused method due to restrictions...
	 * Was supposed to return geolocalisation (Lat, Long) from adress in parameter
	 * 
	public String[] getCoordLat_Lng(String address) throws IOException {
        //
		// Initialize a new GeoAddressStandardizer-class with your API-Key
		final Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address).setLanguage("fr").getGeocoderRequest();
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		List<GeocoderResult> results = geocoderResponse.getResults();
		if (results.size()>0){
			String geometryLat = results.get(0).getGeometry().getLocation().getLat().toString();
			String geometryLng = results.get(0).getGeometry().getLocation().getLng().toString();
			return new String[]{geometryLat, geometryLng};
		}
		else{
			return null;
		}
    }
	public String[] getCoordLat_Lng(String address, int i) throws IOException {
        //
		// Initialize a new GeoAddressStandardizer-class with your API-Key
		if (!address.endsWith("Genève")){
			address = address+" Genève";
		}
		final Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address).setLanguage("fr").getGeocoderRequest();
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		List<GeocoderResult> results = geocoderResponse.getResults();
		//BigDecimal geometryBigDecimalLat = results.get(0).getGeometry().getLocation().getLat();
		//BigDecimal geometryBigDecimalLng = results.get(0).getGeometry().getLocation().getLng();
		if (results.size()>0){
			String geometryLat = results.get(0).getGeometry().getLocation().getLat().toString();
			String geometryLng = results.get(0).getGeometry().getLocation().getLng().toString();
			return new String[]{geometryLat, geometryLng};
		}
		else{
			return null;
		}
    }*/
	public void getHikeTrail(){
		hashMapDataSet.get("HIKING_TRAIL");
	}
	public void getBikeTrail(){
		hashMapDataSet.get("BIKE_TRAIL");
	}
	public void getSportsCenter(){
		hashMapDataSet.get("SPORTS_CENTER_LOCATION");
	}
	public void getSportsTrail(){
		hashMapDataSet.get("SPORTS_CENTER_TRAIL");
	}
	public void getPharmacy(){
		hashMapDataSet.get("PHARMACIE");
	}
	public void getHospital(){
		hashMapDataSet.get("HOPITAL");
	}
	public void getPatio(){
		hashMapDataSet.get("TERRASSES");
	}
}