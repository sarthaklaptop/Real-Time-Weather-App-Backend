package com.example.weatherapplication.repository;

import com.example.weatherapplication.dto.WeatherDto;
import com.example.weatherapplication.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather,Long> {
}
