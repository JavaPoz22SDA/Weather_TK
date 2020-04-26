package pl.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import java.io.IOException;
import java.util.Scanner;

public class GetWeather {
    public static void main(String[] args) throws IOException {
        final String API_KEY = "66bbbddf38facc47e28cb6afc7bccc6b";
        ObjectMapper mapper = new ObjectMapper();
        WeatherSerivice weatherSerivice = new WeatherSerivice("http://api.weatherstack.com/current", API_KEY);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj miasto:");
        String city = scanner.nextLine();

        Weather weather = weatherSerivice.getCityWeather(city);
        if(weather != null)
            System.out.println("Temperatura w " + weather.getLocation().getName() + " wynosi: " + weather.getCurrent().getTemperature());
    }
}
