package com.example.weatherapplication.apiresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {
    private double temp;  // Current temperature

    @JsonProperty("feels_like")
    private double feelsLike;  // Changed to String as per your request

    @JsonProperty("temp_max")
    private double tempMax;  // Maximum temperature

    @JsonProperty("temp_min")
    private double tempMin;  // Minimum temperature

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

}
