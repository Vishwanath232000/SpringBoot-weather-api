package com.practise.springpractise.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class WeatherDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cityID;
    private String cityName;
    private String temperature;
    private String rainfall;


}
