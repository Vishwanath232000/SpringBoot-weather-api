package com.practise.springpractise.service;

import com.practise.springpractise.entity.WeatherDetails;
import com.practise.springpractise.respository.weatherRespository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherServiceTest {
    @Autowired
    private WeatherService weatherService;

    @MockBean
    private weatherRespository weatherRepo;

    @BeforeEach
    void setUp() {
        WeatherDetails weatherDetails=WeatherDetails.builder()
                .cityID(1L).cityName("Hyderabad")
                .temperature("45").rainfall("NIL").build();
        Mockito.when(weatherRepo.findByCityNameIgnoreCase("Hyderabad")).thenReturn(weatherDetails);
        Mockito.when(weatherRepo.save(weatherDetails)).thenReturn(weatherDetails);

    }

    @Test
    void whenValidWeatherName_thenWeatherShouldbeFound(){
        WeatherDetails found=weatherService
                .fetchWeatherByName("Hyderabad");
        assertEquals(found.getCityName(),"Hyderabad");
    }
    @Test
    void whenSaveWeather_thenSavedWeatherShouldbeFound(){
        WeatherDetails weatherDetails=WeatherDetails.builder()
                .cityID(1L).cityName("Hyderabad")
                .temperature("45").rainfall("NIL").build();
        WeatherDetails found=weatherService.saveWeather(weatherDetails);
        assertEquals(found.getCityName(),"Hyderabad");
    }

}
