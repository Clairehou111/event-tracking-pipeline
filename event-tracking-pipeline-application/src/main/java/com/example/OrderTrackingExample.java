package com.example;

import com.example.model.log.EventTrackingLog;
import com.example.model.log.ShippingEventTrackingLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class OrderTrackingExample {


    // Example: track an order status change event
    public void trackOrderStatusChange(String orderId,
                                       String expressCode) {
        ShippingEventTrackingLog log = new ShippingEventTrackingLog();
        log.setOrderNo(orderId);
        log.setExpressCode(expressCode);

        EventTrackingLog.asyncLog(log);
    }
}
