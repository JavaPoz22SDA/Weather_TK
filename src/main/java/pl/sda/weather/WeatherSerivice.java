package pl.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class WeatherSerivice {
    private String finalURL;
    private Weather weather;
    ObjectMapper mapper = new ObjectMapper();

    public WeatherSerivice(String url, String key) {
        finalURL = url + "?access_key=" + key;
    }

    public Optional<Weather> getCityWeather(String city) throws IOException {
        finalURL = finalURL + "&query=" + city.replace(" ", "%20");
        Weather weather;
        Optional<Weather> opt;// = Optional.ofNullable(Weather);
        try {
            weather = mapper.readValue(new URL(finalURL), Weather.class);
            opt = Optional.ofNullable(weather);
            return opt;
        } catch (UnrecognizedPropertyException e) {
            ErrorWeatherException errorWeatherException = mapper.readValue(new URL(finalURL), ErrorWeatherException.class);
            System.out.println("Podane miasto nie istnieje. ");
            System.out.println("Kod błędu: " + errorWeatherException.getError().getCode() + " Info: " + errorWeatherException.getError().getInfo());
            return Optional.empty();
        }
    }
}
