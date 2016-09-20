/*
 * WeatherData.java 1.0 Sept 10, 2016
 *
 * Copyright (c) 2016 HFDP and DJP
 */
package headfirst.seniorstudent2;

import java.util.Observable;

/**
 * Observable (Subject) broadcasts out pressure, temperature and humidity to all
 * Observer
 * 
 * @author dpowell2
 * @version 1.0
 * 
 */
public class WeatherData extends Observable {

  private float humidity;
  private float pressure;
  private float temperature;

  /**
   * Initializes empty list of Observers
   */
  public WeatherData() {
  }

  public float getHumidity() {
    return humidity;
  }

  public float getPressure() {
    return pressure;
  }

  public float getTemperature() {
    return temperature;
  }

  public void measurementsChanged() {
    setChanged();
    notifyObservers();
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }

  @Override
  public String toString() {
    String s = "temperature: " + temperature;
    s = s + "\n" + "humidity: " + humidity;
    s = s + "\n" + "pressure: " + pressure;
    return s;
  }
}