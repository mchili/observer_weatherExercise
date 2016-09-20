/**
 * WeatherDataTest.java 1.0 Sep 20, 2016
 * 
 * Copyright (c) 2016 Maddie Chili. All Rights Reserved
 */
package headfirst.seniorstudent2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests methods of the Weather Data class
 *
 * @author Owner
 * @version 1.0
 *
 */
public class WeatherDataTest {

  private CurrentConditionsDisplay display;
  private CurrentConditionsDisplay display2;
  private CurrentConditionsDisplay display3;
  private WeatherData weatherData;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    weatherData = new WeatherData();
    display = new CurrentConditionsDisplay(weatherData, 0, 0);
    display2 = new CurrentConditionsDisplay(weatherData, 0, 0);
    display3 = new CurrentConditionsDisplay(weatherData, 0, 0);
  }

  @Test
  public void testAddObserver() {
    weatherData.deleteObservers();
    int count = weatherData.countObservers();
    weatherData.addObserver(display);
    weatherData.addObserver(display2);
    assertEquals(count + 2, weatherData.countObservers());
  }

  @Test
  public void testDeleteObserver() {
    int count = weatherData.countObservers();
    weatherData.deleteObserver(display);
    weatherData.deleteObserver(display3);
    assertEquals(count - 2, weatherData.countObservers());
  }

  @Test
  public void testSetMeasurements() {
    float temperature = 75;
    float humidity = 47;
    float pressure = 30;
    weatherData.setMeasurements(temperature, humidity, pressure);
    assertTrue(weatherData.getTemperature() == temperature && weatherData.getHumidity() == humidity
            && weatherData.getPressure() == pressure);
  }
}
