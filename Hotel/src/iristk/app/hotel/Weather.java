package iristk.app.hotel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import net.aksingh.owmjapis.OpenWeatherMap.Language;
import net.aksingh.owmjapis.OpenWeatherMap.Units;

public class Weather {

//	OpenWeatherMap owm = new OpenWeatherMap("369ddea27e95cfbc3d130543c4372525");
	
	
	public String getweather() throws JSONException, IOException {
		String url = "http://api.openweathermap.org/data/2.5/weather?q=Glasgow,UK&appid=369ddea27e95cfbc3d130543c4372525&units=metric";
	    JSONObject json = readJsonFromUrl(url);
	    String description = json.getJSONArray("weather").getJSONObject(0).get("description").toString();
	    String temp_min = json.getJSONObject("main").get("temp_min").toString();
	    String temp_max = json.getJSONObject("main").get("temp_max").toString();
	    String temp = json.getJSONObject("main").get("temp").toString();
	    
	    String weather = "Today's weather in Glasgow is "+description+". The maximum tempearture is "+temp_max+
				 "degree, the minimum tempearture is "+temp_min+"degree and the current tempearture is "+temp+"degree.";
	    return weather;
	}
	
	public String getweather_CN() throws JSONException, IOException {
		String url = "http://api.openweathermap.org/data/2.5/weather?q=Glasgow,UK&lang=zh_cn&appid=369ddea27e95cfbc3d130543c4372525&units=metric";
	    JSONObject json = readJsonFromUrl(url);
	    String description = json.getJSONArray("weather").getJSONObject(0).get("description").toString();
	    String temp_min = json.getJSONObject("main").get("temp_min").toString();
	    String temp_max = json.getJSONObject("main").get("temp_max").toString();
	    String temp = json.getJSONObject("main").get("temp").toString();
	    
	    String weather = "今天格拉斯哥的天气是： "+description+"。 最高温度 "+temp_max+
				 "度, 最低温度 "+temp_min+"度。 当前温度："+temp+"度。";

	    return weather;
	}
	
	
	
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
			}
			return sb.toString();
		  }

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
			} finally {
		      is.close();
		    }
		  }

	
	
	
}
