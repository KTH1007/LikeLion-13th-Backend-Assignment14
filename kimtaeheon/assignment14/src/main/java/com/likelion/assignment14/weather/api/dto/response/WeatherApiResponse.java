package com.likelion.assignment14.weather.api.dto.response;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 동네예보 API 응답
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
public class WeatherApiResponse {
    private Header header;
    private Body body;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class Header {
        private String resultCode;
        private String resultMsg;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class Body {
        private Integer totalCount;
        private Integer pageNo;
        private Integer numOfRows;
        private Items items;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class Items {
        @XmlElement(name = "item")
        private List<WeatherItem> item;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class WeatherItem {
        private String tm;
        private String thema;
        private String courseId;
        private String courseAreaId;
        private String courseAreaName;
        private String spotAreaId;
        private String spotAreaName;
        private String spotName;
        private String th3;
        private String wd;
        private String ws;
        private String sky;
        private String rhm;
        private String pop;
    }
}
