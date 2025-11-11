package com.likelion.assignment14.culture.client;

import com.likelion.assignment14.culture.api.dto.response.CultureListApiResponse;
import com.likelion.assignment14.global.code.status.ErrorStatus;
import com.likelion.assignment14.global.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
@RequiredArgsConstructor
public class CultureApiClient {
    private static final String SERVICE_URL = "%s/period2?serviceKey=%s&PageNo=%d&numOfrows=%d";
    private static final String CULTURE_API_ERROR = "Culture API 호출 실패 (String)";

    private final RestTemplate restTemplate;

    @Value("${culture.api.base-url}")
    private String baseUrl;

    @Value("${culture.api.auth-key}")
    private String authKey;

    public String getCultureEventsAsString(int pageNo, int numOfRows) {
        String encodedKey = URLEncoder.encode(authKey, StandardCharsets.UTF_8);
        String url = String.format(SERVICE_URL, baseUrl, encodedKey, pageNo, numOfRows);

        try {
            return restTemplate.getForObject(new URI(url), String.class);
        } catch (Exception e) {
            log.error(CULTURE_API_ERROR, e);
            throw new GeneralException(ErrorStatus.CULTURE_API_ERROR);
        }
    }

    public CultureListApiResponse getCultureEvents(int pageNo, int numOfRows) {
        String encodedKey = URLEncoder.encode(authKey, StandardCharsets.UTF_8);
        String url = String.format(SERVICE_URL, baseUrl, encodedKey, pageNo, numOfRows);

        try {
            return restTemplate.getForObject(new URI(url), CultureListApiResponse.class);
        } catch (Exception e) {
            log.error(CULTURE_API_ERROR, e);
            throw new GeneralException(ErrorStatus.CULTURE_API_ERROR);
        }
    }
}
