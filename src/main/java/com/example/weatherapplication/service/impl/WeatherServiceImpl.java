package com.example.weatherapplication.service.impl;

import com.example.weatherapplication.apiresponse.WeatherApiResponse;
import com.example.weatherapplication.dto.WeatherDto;
import com.example.weatherapplication.entity.Weather;
import com.example.weatherapplication.repository.WeatherRepository;
import com.example.weatherapplication.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class WeatherServiceImpl implements WeatherService {

   // private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String API_KEY = "fb294307431ca1f93a293944b8bfa94b";
    private final WebClient webClient;
    private final WeatherRepository weatherRepository;
    private final ModelMapper modelMapper;

    @Override
    public Mono<WeatherDto> getMumbaiWeather() {
        String uri = "/weather?lat=18.520760&lon=73.855408&appid=" + API_KEY + "&units=metric";
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(WeatherApiResponse.class)
                .map(responseDto -> {
                    WeatherDto weatherDto = new WeatherDto();
                    weatherDto.setCityName("Mumbai");  // Hardcoded for this method
                    //double temperatureInCelsius = kelvinToCelsius(responseDto.getMain().getTemp());
                    weatherDto.setTemperature(responseDto.getMain().getTemp());
                    //double feelsLikeTempInCelsius = kelvinToCelsius(responseDto.getMain().getFeelsLike());
                    weatherDto.setFeelsLike(mapTemperatureToDescription(responseDto.getMain().getFeelsLike()));
                    weatherDto.setMaxTemp(responseDto.getMain().getTempMax());
                    weatherDto.setMinTemp(responseDto.getMain().getTempMin());
                    weatherDto.setWeatherCondition(responseDto.getWeather().get(0).getDescription()); // General condition
                     // Detailed description
                    weatherDto.setDateTime(LocalDateTime.now());
                    weatherRepository.save(modelMapper.map(weatherDto, Weather.class));

                    return weatherDto;
                })
                .onErrorResume(e -> {
                    throw new RuntimeException("Error getting weather data: " + e.getMessage());
                });
    }

    @Override
    public Mono<WeatherDto> getDelhiWeather() {
        String uri = "/weather?lat=28.704060&lon=77.1024938&appid=" + API_KEY + "&units=metric";
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(WeatherApiResponse.class)
                .map(responseDto -> {
                    WeatherDto weatherDto = new WeatherDto();
                    weatherDto.setCityName("Delhi");  // Hardcoded for this method
                    //double temperatureInCelsius = kelvinToCelsius(responseDto.getMain().getTemp());
                    weatherDto.setTemperature(responseDto.getMain().getTemp());
                    //double feelsLikeTempInCelsius = kelvinToCelsius(responseDto.getMain().getFeelsLike());
                    weatherDto.setFeelsLike(mapTemperatureToDescription(responseDto.getMain().getFeelsLike()));

                    weatherDto.setMaxTemp(responseDto.getMain().getTempMax());
                    weatherDto.setMinTemp(responseDto.getMain().getTempMin());
                    weatherDto.setWeatherCondition(responseDto.getWeather().get(0).getDescription()); // General condition
                    // Detailed description
                    weatherDto.setDateTime(LocalDateTime.now());
                    weatherRepository.save(modelMapper.map(weatherDto, Weather.class));

//                    WeatherHistory currentWeatherHistory = weatherHistoryService.getWeatherHistoryForToday(weatherDto.getCityName());
//
//                    if (currentWeatherHistory == null || weatherDto.getMaxTemp() > currentWeatherHistory.getMaxTemp()) {
//                        if (currentWeatherHistory == null) {
//                            currentWeatherHistory = new WeatherHistory();
//                        }
//                        currentWeatherHistory.setMaxTemp(weatherDto.getMaxTemp());
//                        currentWeatherHistory.setCityName(weatherDto.getCityName());
//                        currentWeatherHistory.setDate(weatherDto.getDateTime().toLocalDate());
//                        weatherHistoryService.saveWeatherHistory(currentWeatherHistory);
//                    }
//
//                    // Check and update the min temperature for the day
//                    if (currentWeatherHistory == null || weatherDto.getMinTemp() < currentWeatherHistory.getMinTemp()) {
//                        if (currentWeatherHistory == null) {
//                            currentWeatherHistory = new WeatherHistory();
//                        }
//                        currentWeatherHistory.setMinTemp(weatherDto.getMinTemp());
//                        currentWeatherHistory.setCityName(weatherDto.getCityName());
//                        currentWeatherHistory.setDate(weatherDto.getDateTime().toLocalDate());
//                        weatherHistoryService.saveWeatherHistory(currentWeatherHistory);
//                    }

                    return weatherDto;
                })
                .onErrorResume(e -> {
                    throw new RuntimeException("Error getting weather data: " + e.getMessage());
                });
    }

    @Override
    public Mono<WeatherDto> getChennaiWeather() {
        String uri = "/weather?lat=13.082680&lon=80.270721&appid=" + API_KEY + "&units=metric";
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(WeatherApiResponse.class)
                .map(responseDto -> {
                    WeatherDto weatherDto = new WeatherDto();
                    weatherDto.setCityName("Chennai");  // Hardcoded for this method
                    //double temperatureInCelsius = kelvinToCelsius(responseDto.getMain().getTemp());
                    weatherDto.setTemperature(responseDto.getMain().getTemp());
                    //double feelsLikeTempInCelsius = kelvinToCelsius(responseDto.getMain().getFeelsLike());
                    weatherDto.setFeelsLike(mapTemperatureToDescription(responseDto.getMain().getFeelsLike()));
                    weatherDto.setMaxTemp(responseDto.getMain().getTempMax());
                    weatherDto.setMinTemp(responseDto.getMain().getTempMin());
                    weatherDto.setWeatherCondition(responseDto.getWeather().get(0).getDescription()); // General condition
                    // Detailed description
                    weatherDto.setDateTime(LocalDateTime.now());
                    weatherRepository.save(modelMapper.map(weatherDto, Weather.class));

//                    WeatherHistory currentWeatherHistory = weatherHistoryService.getWeatherHistoryForToday(weatherDto.getCityName());
//
//                    if (currentWeatherHistory == null || weatherDto.getMaxTemp() > currentWeatherHistory.getMaxTemp()) {
//                        if (currentWeatherHistory == null) {
//                            currentWeatherHistory = new WeatherHistory();
//                        }
//                        currentWeatherHistory.setMaxTemp(weatherDto.getMaxTemp());
//                        currentWeatherHistory.setCityName(weatherDto.getCityName());
//                        currentWeatherHistory.setDate(weatherDto.getDateTime().toLocalDate());
//                        weatherHistoryService.saveWeatherHistory(currentWeatherHistory);
//                    }
//
//                    // Check and update the min temperature for the day
//                    if (currentWeatherHistory == null || weatherDto.getMinTemp() < currentWeatherHistory.getMinTemp()) {
//                        if (currentWeatherHistory == null) {
//                            currentWeatherHistory = new WeatherHistory();
//                        }
//                        currentWeatherHistory.setMinTemp(weatherDto.getMinTemp());
//                        currentWeatherHistory.setCityName(weatherDto.getCityName());
//                        currentWeatherHistory.setDate(weatherDto.getDateTime().toLocalDate());
//                        weatherHistoryService.saveWeatherHistory(currentWeatherHistory);
//                    }

                    return weatherDto;
                })
                .onErrorResume(e -> {
                    throw new RuntimeException("Error getting weather data: " + e.getMessage());
                });
    }

    @Override
    public Mono<WeatherDto> getKolkataWeather() {
        String uri = "/weather?lat=22.572645&lon=88.363892&appid=" + API_KEY + "&units=metric";
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(WeatherApiResponse.class)
                .map(responseDto -> {
                    WeatherDto weatherDto = new WeatherDto();
                    weatherDto.setCityName("Kolkata");  // Hardcoded for this method
                    //double temperatureInCelsius = kelvinToCelsius(responseDto.getMain().getTemp());
                    weatherDto.setTemperature(responseDto.getMain().getTemp());
                    //double feelsLikeTempInCelsius = kelvinToCelsius(responseDto.getMain().getFeelsLike());
                    weatherDto.setFeelsLike(mapTemperatureToDescription(responseDto.getMain().getFeelsLike()));
                    weatherDto.setMaxTemp(responseDto.getMain().getTempMax());
                    weatherDto.setMinTemp(responseDto.getMain().getTempMin());
                    weatherDto.setWeatherCondition(responseDto.getWeather().get(0).getDescription()); // General condition
                    // Detailed description
                    weatherDto.setDateTime(LocalDateTime.now());
                    weatherRepository.save(modelMapper.map(weatherDto, Weather.class));

//                    WeatherHistory currentWeatherHistory = weatherHistoryService.getWeatherHistoryForToday(weatherDto.getCityName());
//
//                    if (currentWeatherHistory == null || weatherDto.getMaxTemp() > currentWeatherHistory.getMaxTemp()) {
//                        if (currentWeatherHistory == null) {
//                            currentWeatherHistory = new WeatherHistory();
//                        }
//                        currentWeatherHistory.setMaxTemp(weatherDto.getMaxTemp());
//                        currentWeatherHistory.setCityName(weatherDto.getCityName());
//                        currentWeatherHistory.setDate(weatherDto.getDateTime().toLocalDate());
//                        weatherHistoryService.saveWeatherHistory(currentWeatherHistory);
//                    }
//
//                    // Check and update the min temperature for the day
//                    if (currentWeatherHistory == null || weatherDto.getMinTemp() < currentWeatherHistory.getMinTemp()) {
//                        if (currentWeatherHistory == null) {
//                            currentWeatherHistory = new WeatherHistory();
//                        }
//                        currentWeatherHistory.setMinTemp(weatherDto.getMinTemp());
//                        currentWeatherHistory.setCityName(weatherDto.getCityName());
//                        currentWeatherHistory.setDate(weatherDto.getDateTime().toLocalDate());
//                        weatherHistoryService.saveWeatherHistory(currentWeatherHistory);
//                    }

                    return weatherDto;
                })
                .onErrorResume(e -> {
                    throw new RuntimeException("Error getting weather data: " + e.getMessage());
                });
    }

    @Override
    public Mono<WeatherDto> getHyderabadWeather() {
        String uri = "/weather?lat=17.361719&lon=78.475166&appid=" + API_KEY + "&units=metric";
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(WeatherApiResponse.class)
                .map(responseDto -> {
                    WeatherDto weatherDto = new WeatherDto();
                    weatherDto.setCityName("Hyderabad");

                    weatherDto.setTemperature(responseDto.getMain().getTemp());

                    weatherDto.setFeelsLike(mapTemperatureToDescription(responseDto.getMain().getFeelsLike()));
                    weatherDto.setMaxTemp(responseDto.getMain().getTempMax());
                    weatherDto.setMinTemp(responseDto.getMain().getTempMin());
                    weatherDto.setWeatherCondition(responseDto.getWeather().get(0).getDescription()); // General condition
                    // Detailed description
                    weatherDto.setDateTime(LocalDateTime.now());
                    weatherRepository.save(modelMapper.map(weatherDto, Weather.class));

//                    WeatherHistory currentWeatherHistory = weatherHistoryService.getWeatherHistoryForToday(weatherDto.getCityName());
//
//                    if (currentWeatherHistory == null || weatherDto.getMaxTemp() > currentWeatherHistory.getMaxTemp()) {
//                        if (currentWeatherHistory == null) {
//                            currentWeatherHistory = new WeatherHistory();
//                        }
//                        currentWeatherHistory.setMaxTemp(weatherDto.getMaxTemp());
//                        currentWeatherHistory.setCityName(weatherDto.getCityName());
//                        currentWeatherHistory.setDate(weatherDto.getDateTime().toLocalDate());
//                        weatherHistoryService.saveWeatherHistory(currentWeatherHistory);
//                    }
//
//                    // Check and update the min temperature for the day
//                    if (currentWeatherHistory == null || weatherDto.getMinTemp() < currentWeatherHistory.getMinTemp()) {
//                        if (currentWeatherHistory == null) {
//                            currentWeatherHistory = new WeatherHistory();
//                        }
//                        currentWeatherHistory.setMinTemp(weatherDto.getMinTemp());
//                        currentWeatherHistory.setCityName(weatherDto.getCityName());
//                        currentWeatherHistory.setDate(weatherDto.getDateTime().toLocalDate());
//                        weatherHistoryService.saveWeatherHistory(currentWeatherHistory);
//                    }
                    return weatherDto;
                })
                .onErrorResume(e -> {
                    throw new RuntimeException("Error getting weather data: " + e.getMessage());
                });
    }

    @Override
    public Mono<WeatherDto> getBangloreWeather() {
        String uri = "/weather?lat=12.9716&lon=77.5946&appid=" + API_KEY + "&units=metric";
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(WeatherApiResponse.class)
                .map(responseDto -> {
                    WeatherDto weatherDto = new WeatherDto();
                    weatherDto.setCityName("Banglore");

                    weatherDto.setTemperature(responseDto.getMain().getTemp());

                    weatherDto.setFeelsLike(mapTemperatureToDescription(responseDto.getMain().getFeelsLike()));
                    weatherDto.setMaxTemp(responseDto.getMain().getTempMax());
                    weatherDto.setMinTemp(responseDto.getMain().getTempMin());
                    weatherDto.setWeatherCondition(responseDto.getWeather().get(0).getDescription()); // General condition
                    // Detailed description
                    weatherDto.setDateTime(LocalDateTime.now());
                    weatherRepository.save(modelMapper.map(weatherDto, Weather.class));

//                    WeatherHistory currentWeatherHistory = weatherHistoryService.getWeatherHistoryForToday(weatherDto.getCityName());
//
//                    if (currentWeatherHistory == null || weatherDto.getMaxTemp() > currentWeatherHistory.getMaxTemp()) {
//                        if (currentWeatherHistory == null) {
//                            currentWeatherHistory = new WeatherHistory();
//                        }
//                        currentWeatherHistory.setMaxTemp(weatherDto.getMaxTemp());
//                        currentWeatherHistory.setCityName(weatherDto.getCityName());
//                        currentWeatherHistory.setDate(weatherDto.getDateTime().toLocalDate());
//                        weatherHistoryService.saveWeatherHistory(currentWeatherHistory);
//                    }
//
//                    // Check and update the min temperature for the day
//                    if (currentWeatherHistory == null || weatherDto.getMinTemp() < currentWeatherHistory.getMinTemp()) {
//                        if (currentWeatherHistory == null) {
//                            currentWeatherHistory = new WeatherHistory();
//                        }
//                        currentWeatherHistory.setMinTemp(weatherDto.getMinTemp());
//                        currentWeatherHistory.setCityName(weatherDto.getCityName());
//                        currentWeatherHistory.setDate(weatherDto.getDateTime().toLocalDate());
//                        weatherHistoryService.saveWeatherHistory(currentWeatherHistory);
//                    }
                    return weatherDto;
                })
                .onErrorResume(e -> {
                    throw new RuntimeException("Error getting weather data: " + e.getMessage());
                });
    }
    @Override
    public String mapTemperatureToDescription(double temperature) {

        if (temperature < 10) {
            return "Very Cool";
        } else if (temperature >= 10 && temperature < 20) {
            return "Cool";
        } else if (temperature >= 20 && temperature < 30) {
            return "Warm";
        } else if (temperature >= 30 && temperature < 40) {
            return "Hot";
        } else {
            return "Very Hot";
        }
    }

    @Override
    public List<Weather> getAllWeatherHistory() {
      return weatherRepository.findAll();
    }

}




