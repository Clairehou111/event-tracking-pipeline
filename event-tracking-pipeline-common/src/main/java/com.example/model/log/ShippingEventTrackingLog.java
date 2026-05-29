package com.example.model.log;

import lombok.Getter;
import lombok.Setter;

import com.example.constants.EventTrackingSceneKeyEnum;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class ShippingEventTrackingLog extends BaseEventTrackingLog {
    private String orderNo;
    private String expressCode;

    public ShippingEventTrackingLog() {
        super(EventTrackingSceneKeyEnum.APP_EXAMPLE_SCENE);
        this.mockYesterday();
    }


    private void mockYesterday() {
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String yesterdayStr = yesterday.format(formatter);
        long yesterdayTimestamp = yesterday.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        this.setDateTime(yesterdayStr);
        this.setTimestamp(yesterdayTimestamp);
    }
}
