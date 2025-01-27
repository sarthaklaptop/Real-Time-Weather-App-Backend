package com.example.weatherapplication.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class WeatherDto {

    private String cityName;

    private Double  temperature;

    private String  feelsLike;

    private String weatherCondition;

    private Double maxTemp;

    private Double minTemp;

    private String description;

    private LocalDateTime dateTime;
}
