package pl.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class GetWeather {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String url = "http://api.weatherstack.com/current"+
                "?access_key=66bbbddf38facc47e28cb6afc7bccc6b&query=Poznan";

        Weather object=mapper.readValue(new URL(url),Weather.class);
        System.out.println(object.getCurrent().getTemperature());
    }
}
