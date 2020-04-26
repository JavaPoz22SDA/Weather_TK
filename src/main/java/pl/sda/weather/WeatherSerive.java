package pl.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import java.io.IOException;
import java.net.URL;

public class WeatherSerive {
    private String finalURL;
    private Weather weather;
    ObjectMapper mapper = new ObjectMapper();

    public WeatherSerive(String url, String key) {
        finalURL = url + "?access_key=" + key;
    }

    public Weather getCityWeather(String city) throws IOException {
        finalURL = finalURL + "&query=" + city.replace(" ", "%20");
        return mapper.readValue(new URL(finalURL), Weather.class);
    }
}
