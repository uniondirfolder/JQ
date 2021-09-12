package hw.d06092021_p2.GoF.behavioral.Observer.Weather;

public class Station {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        CurrentConditionsDisplay currentConditonsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(10, 70, 30.1f);
        weatherData.setMeasurements(13, 75, 28.1f);
        weatherData.setMeasurements(15, 72, 29.5f);
    }
}
