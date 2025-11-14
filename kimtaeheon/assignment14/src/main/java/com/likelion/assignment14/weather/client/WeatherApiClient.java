package com.likelion.assignment14.weather.client;

import com.likelion.assignment14.global.code.status.ErrorStatus;
import com.likelion.assignment14.global.exception.GeneralException;
import com.likelion.assignment14.weather.api.dto.response.WeatherApiResponse;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class WeatherApiClient {
    private static final String SERVICE_URL = "%s/getTourStnVilageFcst1?ServiceKey=%s&pageNo=%d&numOfRows=%d&CURRENT_DATE=%s&HOUR=%d&COURSE_ID=%s&dataType=%s";
    private static final String WEATHER_API_ERROR = "Weather API 호출 실패";

    private final RestTemplate restTemplate;

    @Value("${weather.api.base-url}")
    private String baseUrl;

    @Value("${weather.api.auth-key}")
    private String authKey;

    public String getWeatherForecastAsString(int pageNo, int numOfRows,
                                             String currentDate, int hour, String courseId, String dataType) {
        String encodedKey = URLEncoder.encode(authKey, StandardCharsets.UTF_8);
        String url = String.format(SERVICE_URL, baseUrl, encodedKey,
                pageNo, numOfRows, currentDate, hour, courseId, dataType);

        try {
            return restTemplate.getForObject(new URI(url), String.class);
        } catch (Exception e) {
            log.error(WEATHER_API_ERROR, e);
            throw new GeneralException(ErrorStatus.WEATHER_API_ERROR);
        }
    }

    public WeatherApiResponse getWeatherForecast(int pageNo, int numOfRows,
                                                 String currentDate, int hour, String courseId, String dataType) {
        String encodedKey = URLEncoder.encode(authKey, StandardCharsets.UTF_8);
        String url = String.format(SERVICE_URL, baseUrl, encodedKey,
                pageNo, numOfRows, currentDate, hour, courseId, dataType);

        try {
            return restTemplate.getForObject(new URI(url), WeatherApiResponse.class);
        } catch (Exception e) {
            log.error(WEATHER_API_ERROR, e);
            throw new GeneralException(ErrorStatus.WEATHER_API_ERROR);
        }
    }
}
