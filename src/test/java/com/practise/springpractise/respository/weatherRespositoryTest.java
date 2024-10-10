package com.practise.springpractise.respository;

import com.practise.springpractise.entity.WeatherDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class weatherRespositoryTest {

    @Autowired
    private weatherRespository weatherRepo;

    @PersistenceContext
    private EntityManager entityManager;






    @BeforeEach
    void setUp() {
        WeatherDetails weather=WeatherDetails.builder()
                .cityName("Hyderabad").cityID(1L)
                .temperature("45").rainfall("NIL").build();

    }


    void whenWeatherSave_thenReturnWeather(){

        WeatherDetails found=weatherRepo
                .findByCityNameIgnoreCase("Hyderabad");
        assertNotNull(found);
        assertEquals(found.getCityName(),"Hyderabad");

    }


    void testFindAllWeather(){
        WeatherDetails weather1=WeatherDetails.builder()
                .cityName("Hyderabad").cityID(1L)
                .temperature("45").rainfall("NIL").build();
        WeatherDetails weather2=WeatherDetails.builder()
                .cityName("Mumbai").cityID(2L)
                .temperature("45").rainfall("NIL").build();
        weatherRepo.save(weather1);
        weatherRepo.save(weather2);
        List<WeatherDetails> weatherList=weatherRepo.findAll();
        assertEquals(2,weatherList.size());
        assertEquals("Hyderabad",weatherList.get(0).getCityName());
        assertEquals("Mumbai",weatherList.get(1).getCityName());


    }

    @Test
    void testUsingPersist(){
        WeatherDetails weatherDetails=WeatherDetails.builder()
                .cityName("Hyderabad")
                .temperature("45").rainfall("NIL").build();
        entityManager.persist(weatherDetails);
        entityManager.flush();

        WeatherDetails found=entityManager.find(WeatherDetails.class
                ,weatherDetails.getCityID());
        assertNotNull(found);
        assertEquals("Hyderabad",found.getCityName());
        assertEquals("45",found.getTemperature());

    }
}