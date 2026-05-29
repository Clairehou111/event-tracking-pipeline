package com.example.model.log;

import lombok.Getter;
import lombok.Setter;

import com.example.constants.BigDataSceneKeyEnum;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class ShippingBigDataLog extends AbstractBigDataLog {
    private String orderNo;
    private String expressCode;

    public ShippingBigDataLog() {
        super(BigDataSceneKeyEnum.APP_EXAMPLE_SCENE);
        //mock yesterday's data to test t-1 offline data
        this.mockYesterday();
    }


    private void mockYesterday() {
        // 1. Get exactly 24 hours ago
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);

        // 2. Format it to match your Logstash date filter ("yyyy-MM-dd HH:mm:ss")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String yesterdayStr = yesterday.format(formatter);

        // 3. Get the matching epoch timestamp (milliseconds) for consistency
        long yesterdayTimestamp = yesterday.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        // 4. Set them in your log object
        this.setDateTime(yesterdayStr);
        this.setTimestamp(yesterdayTimestamp);
    }
}
