package com.practise.springpractise.Controller;

import com.practise.springpractise.entity.WeatherDetails;
import com.practise.springpractise.service.WeatherService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @PostMapping("/cities")
    public WeatherDetails saveWeatherDetails(@Valid @RequestBody WeatherDetails weather) {
        return weatherService.saveWeather(weather);
    }

    @GetMapping("/cities")
    public List<WeatherDetails> getDetails() {
        return weatherService.getWeather();
    }

    @GetMapping("/cities/{city}")
    public WeatherDetails fetchWeatherByName(@PathVariable("city") String CityName) {
        return weatherService.fetchWeatherByName(CityName);
    }

    @PutMapping("/cities/{id}")
    public WeatherDetails updateWeather(@PathVariable("id") Long cityId,
                                        @RequestBody WeatherDetails weather){
        return weatherService.updateWeather(cityId,weather);
    }
    @DeleteMapping("/cities/id/{id}")
    @Transactional
    public  void  deleteById(@PathVariable("id") Long cityId){
        weatherService.deleteById(cityId);

    }

    @DeleteMapping("/cities/name/{cityName}")
    @Transactional
    public  String deleteByCityName(@PathVariable ("cityName") String cityName){
        weatherService.deleteByCityName(cityName);
        return "The record of city "+cityName+" got deleted";
    }



}
