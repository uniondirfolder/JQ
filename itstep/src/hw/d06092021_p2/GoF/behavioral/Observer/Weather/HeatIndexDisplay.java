package hw.d06092021_p2.GoF.behavioral.Observer.Weather;

import java.util.Observable;
import java.util.Observer;

public class HeatIndexDisplay implements Observer, DisplayElement {
    float heatIndex = 0.0f;

    public HeatIndexDisplay(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)observable;
            float tF = weatherData.getTemperature() * 9 / 5 + 32;
            float rh = weatherData.getHumidity();
            heatIndex = (float)
                    ((
                            (16.923 + (0.185212 * tF)) + 
                            (5.37941 * rh) - 
                            (0.100254 * tF * rh) + 
                            (0.00941695 * (tF * tF)) + 
                            (0.00728898 * (rh * rh)) + 
                            (0.000345372 * (tF * tF * rh)) - 
                            (0.000814971 * (tF * rh * rh)) +
                            (0.0000102102 * (tF * tF * rh * rh)) - 
                            (0.000038646 * (tF * tF * tF)) + 
                            (0.0000291583 * (rh * rh * rh)) +
                            (0.00000142721 * (tF * tF * tF * rh)) + 
                            (0.000000197483 * (tF * rh * rh * rh)) - 
                            (0.0000000218429 * (tF * tF * tF * rh * rh)) +
                            (0.000000000843296 * (tF * tF * rh * rh * rh)) -
                            (0.0000000000481975 * (tF * tF * tF * rh * rh * rh))) - 32) * 5 / 9;
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Heat index is " + heatIndex);
    }
}
