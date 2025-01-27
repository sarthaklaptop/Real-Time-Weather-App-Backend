package com.example.weatherapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Weather {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @Column(name = "max_temp")
    private Double maxTemp;

    private Double  temperature;

    private String  feelsLike;

    private String weatherCondition;

    @Column(name = "min_temp")
    private Double minTemp;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

}
