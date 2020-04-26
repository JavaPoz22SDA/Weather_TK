package pl.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class GetWeather {
    public static void main(String[] args) throws IOException {
        final String KLUCZ_API = "66bbbddf38facc47e28cb6afc7bccc6b";
        ObjectMapper mapper = new ObjectMapper();
        WeatherSerive weatherSerive = new WeatherSerive("http://api.weatherstack.com/current", KLUCZ_API);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj miasto:");
        String city = scanner.nextLine();

        try {
            Weather weather = weatherSerive.getCityWeather(city);

            System.out.println("Temperatura w " + weather.getLocation().getName() + " wynosi: " + weather.getCurrent().getTemperature());
        } catch (UnrecognizedPropertyException e) {
            System.out.println("Podane miasto nie istnieje.");
        }


    }
}
