package com.example.weatherapplication.service;


import com.example.weatherapplication.dto.WeatherDto;
import com.example.weatherapplication.entity.Weather;
import reactor.core.publisher.Mono;

import java.util.List;

public interface WeatherService {
    Mono<WeatherDto> getMumbaiWeather();
    Mono<WeatherDto> getDelhiWeather();
    Mono<WeatherDto> getChennaiWeather();
    Mono<WeatherDto> getKolkataWeather();
    Mono<WeatherDto> getHyderabadWeather();
    Mono<WeatherDto> getBangloreWeather();

    String mapTemperatureToDescription(double temperature);

    List<Weather> getAllWeatherHistory();
}
