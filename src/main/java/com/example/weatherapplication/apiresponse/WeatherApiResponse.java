package com.example.weatherapplication.apiresponse;

import com.example.weatherapplication.dto.WeatherDto;

import java.util.List;

public class WeatherApiResponse {

    private Main main;
    private List<WeatherDto> weather; // Changed to List<WeatherDto>

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<WeatherDto> getWeather() { // Updated return type
        return weather;
    }

    public void setWeather(List<WeatherDto> weather) { // Updated parameter type
        this.weather = weather;
    }
}
