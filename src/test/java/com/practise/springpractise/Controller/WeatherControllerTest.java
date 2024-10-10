package com.practise.springpractise.Controller;

import com.practise.springpractise.entity.WeatherDetails;
import com.practise.springpractise.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(WeatherController.class)
class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherService weatherService;

    private WeatherDetails weatherDetails;

    @BeforeEach
    void setUp() {
        weatherDetails=WeatherDetails.builder()
                .cityName("Hyderabad")
                .cityID(1L).temperature("45")
                .rainfall("NIL").build();

    }

    @Test
    void saveWeather() throws Exception {
        WeatherDetails inputweather=WeatherDetails.builder()
                .cityName("Hyderabad")
                .cityID(1L).temperature("45")
                .rainfall("NIL").build();
        Mockito.when(weatherService.saveWeather(inputweather)).thenReturn(weatherDetails);
        mockMvc.perform(post("/cities")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"cityID\": 1,\n" +
                        "\t\"cityName\": \"Hyderabad\",\n" +
                        "\t\"temperature\": \"45\",\n" +
                        "\t\"rainfall\": \"NIL\"\n" +
                        "}")).andExpect(status().isOk());
    }
    @Test
    void getWeather() throws Exception {
        Mockito.when(weatherService.fetchWeatherByName("Hyderabad"))
                .thenReturn(weatherDetails);
        mockMvc.perform(get("/cities/Hyderabad")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$.cityName")
                .value(weatherDetails.getCityName()));


    }


}