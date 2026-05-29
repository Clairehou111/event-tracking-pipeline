package com.example;


import com.demo.framework.bigdata.log.BigDataLog;
import com.example.model.log.ShippingBigDataLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class OrderTrackingExample {


    // Example: track an order status change event
    public void trackOrderStatusChange(String orderId,
                                       String expressCode) {
        ShippingBigDataLog log = new ShippingBigDataLog();
        log.setOrderNo(orderId);
        log.setExpressCode(expressCode);

        // Non-blocking, fire-and-forget
        BigDataLog.asyncLog(log);


    }
}