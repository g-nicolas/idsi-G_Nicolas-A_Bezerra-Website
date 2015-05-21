package ch.unige.idsi.stayfitgeneva;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StayFitGenevaController {
	// gmapsWebKey=AIzaSyBdf8gpxkqM8OpkxIOb5u5mbanRGOtYuU0
	OpenDataExtractorWebApp dataExtractor;

	@RequestMapping("/weather")
	public ModelAndView weather() throws IOException {
		Weather weather = new Weather();
		// Get the values to display
		ArrayList<String> weatherValues = weather.getArrayListValues();
		// Setup the values to display in html
		String weatherLocation = "<h1>Genève, Suisse</h1>";
		String weatherDesc = "<h1>"+weatherValues.get(0)+"</h1>";
		String weatherMain = "<h1>"+weatherValues.get(1)+"</h1>";
		String weatherTemp = "<h1>"+weatherValues.get(2)+"°</h1>";
		String weatherTempMinMax = "<h4>Min:"+weatherValues.get(3)+"°"+"  "+"Max:"+weatherValues.get(4)+"°</h4>";
		String weatherWind = "<h3>Vent: "+weatherValues.get(5)+"</h3>";
		String weatherPressure= "<h3>Pression: "+weatherValues.get(6)+" hpa</h3>";
		String weatherDisplay = "<br>"+weatherLocation+weatherTemp+weatherTempMinMax+weatherDesc+weatherWind+weatherPressure+"<br>";
		ModelAndView mv = new ModelAndView("weather", "displayWeather", weatherDisplay);
		// Add the setup as attribute of model mv to be fetch when needed
		mv.addObject("weatherMain",weatherMain);
		return mv;
	}
	@RequestMapping("/sitg")
	public ModelAndView sitg() {
		// Do something here
		//String message = "sitgValue";
		return new ModelAndView("sitg");
	}
	@RequestMapping("/maps-hike")
	public ModelAndView mapsHike() throws IOException, InvalidKeyException, JSONException {
		// Do something here: Get data from extractor
		// Change of plan: applying layer directly with javascript google maps api
		return new ModelAndView("maps-hike");
	}
	@RequestMapping("/maps-pharmacy")
	public ModelAndView mapsPharmacy() throws IOException {
		// Setup extractor to retrieve data for category "Emplacement pharmacies"
		dataExtractor = new OpenDataExtractorWebApp("Emplacement pharmacies");
		HashMap<String, ArrayList<ArrayList<String>>> dataHashmap = dataExtractor.getHashMapAllDataSet();
		ArrayList<ArrayList<String>> dataSet = dataHashmap.get("PHARMACIE");
		System.out.println(dataSet.size());
		// Get all the titles of pharmacies
		ArrayList<String> titles = dataSet.get(0);
		// Get all the latitudes of pharmacies
		ArrayList<String> lats = dataSet.get(1);
		// Get all the longitudes of pharmacies
		ArrayList<String> lngs = dataSet.get(2);
		ModelAndView mv = new ModelAndView("maps-pharmacy");
		mv.addObject("titles", titles);
		mv.addObject("lats",lats);
		mv.addObject("lngs",lngs);
		return mv;
	}
}
