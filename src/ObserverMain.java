import java.util.ArrayList;
import java.util.List;

public class ObserverMain {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.setTemperature(30.1);

        PhoneScreen phoneScreen = new PhoneScreen(weatherStation);
        phoneScreen.update();

        weatherStation.setTemperature(31.2);
        weatherStation.load();
        phoneScreen.update();
    }
}

interface IObservable{
    void add(IObserver observer);
    void remove(IObserver observer);
    void load();
}
class WeatherStation implements IObservable{
    double temperature;
    List<IObserver> observers = new ArrayList<>();
    @Override
    public void add(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void load() {
        for (IObserver observer: this.observers){
            observer.update();
        }
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}

interface IObserver{
    void update();
}
class PhoneScreen implements IObserver{
    WeatherStation weatherStation;
    public PhoneScreen(WeatherStation weatherStation){
        this.weatherStation = weatherStation;
    }
    @Override
    public void update() {
        // Something is happened, I have to react to that.
        System.out.println("Screen updated :" + this.weatherStation.getTemperature());
    }
}