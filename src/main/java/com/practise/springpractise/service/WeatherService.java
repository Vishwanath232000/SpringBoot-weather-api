package com.practise.springpractise.service;

import com.practise.springpractise.entity.WeatherDetails;

import java.util.List;

public interface WeatherService {
    public WeatherDetails saveWeather(WeatherDetails weather);
    public List<WeatherDetails> getWeather();
    public WeatherDetails fetchWeatherByName(String CityName);

    public WeatherDetails updateWeather(Long cityId, WeatherDetails weather);

    public void deleteById(Long cityId);

    public void deleteByCityName(String cityName);
}
