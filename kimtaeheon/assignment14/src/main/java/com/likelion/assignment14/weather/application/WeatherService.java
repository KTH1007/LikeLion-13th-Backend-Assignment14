package com.likelion.assignment14.weather.application;

import com.likelion.assignment14.weather.api.dto.response.WeatherApiResponse;
import com.likelion.assignment14.weather.client.WeatherApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WeatherService {
    private final WeatherApiClient weatherApiClient;

    public String getWeatherForecastRaw(int page, int size,
                                        String currentDate, int hour, String courseId, String dataType) {

        return weatherApiClient.getWeatherForecastAsString(
                page, size, currentDate, hour, courseId, dataType);
    }

    public WeatherApiResponse getWeatherForecastFromApi(int page, int size,
                                                        String currentDate, int hour, String courseId,
                                                        String dataType) {

        return weatherApiClient.getWeatherForecast(
                page, size, currentDate, hour, courseId, dataType);
    }
}
