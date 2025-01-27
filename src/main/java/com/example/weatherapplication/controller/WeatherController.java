package com.example.weatherapplication.controller;

import com.example.weatherapplication.dto.WeatherDto;
import com.example.weatherapplication.entity.Weather;
//import com.example.weatherapplication.service.WeatherSchedulerService;
import com.example.weatherapplication.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;
  

    @GetMapping("/allcities")
    public Mono<ResponseEntity<List<WeatherDto>>> getWeatherForAllCities() {
        // Get weather data for all cities and return as a list
        return Flux.concat(
                        weatherService.getMumbaiWeather(),
                        weatherService.getDelhiWeather(),
                        weatherService.getChennaiWeather(),
                        weatherService.getKolkataWeather(),
                        weatherService.getHyderabadWeather(),
                        weatherService.getBangloreWeather()
                )
                .collectList()  // Collect the results into a List<WeatherDto>
                .map(weatherDtos -> ResponseEntity.ok(weatherDtos))  // Wrap the list in a ResponseEntity
                .onErrorResume(e -> {
                    // Handle error and return a response with error code
                    return Mono.just(ResponseEntity.status(500).body(null));
                });
    }
    @GetMapping("/weatherhistory")
    public ResponseEntity<List<Weather>> getAllWeatherHistory() {
        List<Weather> historyList = weatherService.getAllWeatherHistory();
        return ResponseEntity.ok(historyList); // Return the list of historical weather data
    }


}
