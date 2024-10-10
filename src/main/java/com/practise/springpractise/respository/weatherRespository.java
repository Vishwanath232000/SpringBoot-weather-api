package com.practise.springpractise.respository;

import com.practise.springpractise.entity.WeatherDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface weatherRespository extends JpaRepository<WeatherDetails, Long> {
    WeatherDetails findByCityName(String cityName);
    WeatherDetails findByCityNameIgnoreCase(String cityName);
    void deleteByCityName(String cityName);
}
