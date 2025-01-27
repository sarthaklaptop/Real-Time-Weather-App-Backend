package com.example.weatherapplication.config;

import com.example.weatherapplication.dto.WeatherDto;
import com.example.weatherapplication.entity.Weather;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        // Mapping from WeatherDto to Weather entity
        mapper.typeMap(WeatherDto.class, Weather.class).setConverter(context -> {
            WeatherDto weatherDto = context.getSource();
            Weather weather = new Weather();
            weather.setCityName(weatherDto.getCityName());
            weather.setTemperature(weatherDto.getTemperature());
            weather.setFeelsLike(weatherDto.getFeelsLike());
            weather.setWeatherCondition(weatherDto.getWeatherCondition());
            weather.setMaxTemp(weatherDto.getMaxTemp());
            weather.setMinTemp(weatherDto.getMinTemp());
            weather.setTimestamp(weatherDto.getDateTime());  // DateTime in WeatherDto is mapped to timestamp in Weather
            return weather;
        });

        // Mapping from Weather entity to WeatherDto
        mapper.typeMap(Weather.class, WeatherDto.class).setConverter(context -> {
            Weather weather = context.getSource();
            WeatherDto weatherDto = new WeatherDto();
            weatherDto.setCityName(weather.getCityName());
            weatherDto.setTemperature(weather.getTemperature());
            weatherDto.setFeelsLike(weather.getFeelsLike());
            weatherDto.setWeatherCondition(weather.getWeatherCondition());
            weatherDto.setMaxTemp(weather.getMaxTemp());
            weatherDto.setMinTemp(weather.getMinTemp());
            weatherDto.setDateTime(weather.getTimestamp());  // Mapping timestamp to dateTime
            return weatherDto;
        });

        return mapper;
    }
}
