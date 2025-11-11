package com.likelion.assignment14.culture.api.dto.response;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 문화행사 리스트 API 응답
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
public class CultureListApiResponse {
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

        @XmlElement(name = "PageNo")
        private Integer pageNo;

        @XmlElement(name = "numOfrows")
        private Integer numOfRows;

        private Items items;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class Items {
        @XmlElement(name = "item")
        private List<CultureListItem> item;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class CultureListItem {
        private String serviceName;
        private String seq;
        private String title;
        private String startDate;
        private String endDate;
        private String place;
        private String realmName;
        private String area;
        private String sigungu;
        private String thumbnail;
        private String gpxX;
        private String gpsY;
    }
}
