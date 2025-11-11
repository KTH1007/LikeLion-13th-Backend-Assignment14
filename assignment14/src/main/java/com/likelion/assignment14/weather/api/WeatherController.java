package com.likelion.assignment14.weather.api;

import com.likelion.assignment14.global.code.dto.ApiResponse;
import com.likelion.assignment14.weather.api.dto.response.WeatherApiResponse;
import com.likelion.assignment14.weather.application.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/raw")
    public ResponseEntity<String> getWeatherRaw(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam String currentDate,
            @RequestParam int hour,
            @RequestParam String courseId,
            @RequestParam(defaultValue = "XML") String dataType) {

        String response = weatherService.getWeatherForecastRaw(
                page, size, currentDate, hour, courseId, dataType);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/from-api")
    public ResponseEntity<ApiResponse<WeatherApiResponse>> getWeatherFromApi(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam String currentDate,
            @RequestParam int hour,
            @RequestParam String courseId,
            @RequestParam(defaultValue = "XML") String dataType) {

        WeatherApiResponse response = weatherService.getWeatherForecastFromApi(
                page, size, currentDate, hour, courseId, dataType);
        return ResponseEntity.ok(ApiResponse.onSuccess(response));
    }
}
