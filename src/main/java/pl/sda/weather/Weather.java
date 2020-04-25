package pl.sda.weather;

public class Weather {
    private double temperature;
    private String city;
    private Request request;
    private Location location;


    public Weather() { }

    public Weather(double temperature, String city, Request request, Location location) {
        this.temperature = temperature;
        this.city = city;
        this.request = request;
        this.location = location;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
