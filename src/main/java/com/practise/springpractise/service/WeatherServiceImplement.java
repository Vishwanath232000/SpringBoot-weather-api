package com.practise.springpractise.service;

import com.practise.springpractise.entity.WeatherDetails;
import com.practise.springpractise.respository.weatherRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class WeatherServiceImplement implements WeatherService {

    @Autowired
    private weatherRespository weatherRespo;

    @Override
    public WeatherDetails saveWeather(WeatherDetails weather) {
        return weatherRespo.save(weather);
    }

    @Override
    public List<WeatherDetails> getWeather() {
        return weatherRespo.findAll();
    }

    @Override
    public WeatherDetails fetchWeatherByName(String CityName) {
        return weatherRespo.findByCityNameIgnoreCase(CityName);
    }

    @Override
    public WeatherDetails updateWeather(Long cityId, WeatherDetails weather) {
        WeatherDetails weath=weatherRespo.findById(cityId).get();
        if(Objects.nonNull(weather.getCityName()) &&
                !"".equalsIgnoreCase(weather.getCityName())) {
            weath.setCityName(weather.getCityName());
        }
        if(Objects.nonNull(weather.getTemperature()) &&
                !"".equalsIgnoreCase(weather.getTemperature())){
            weath.setTemperature(weather.getTemperature());
        }
        if(Objects.nonNull(weather.getRainfall()) &&
                !"".equalsIgnoreCase(weather.getRainfall())){
            weath.setRainfall(weather.getRainfall());
        }
        return weatherRespo.save(weath);
    }

    @Override
    public void deleteById(Long cityId) {
        weatherRespo.deleteById(cityId);
    }

    @Override
    public void deleteByCityName(String cityName) {
        weatherRespo.deleteByCityName(cityName);
        System.out.printf("The record with city name %s delete ",cityName);
    }
}
