package com.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-tracking")
public class OrderTrackingController {

    private final OrderTrackingExample orderTrackingExample;

    public OrderTrackingController(OrderTrackingExample orderTrackingExample) {
        this.orderTrackingExample = orderTrackingExample;
    }

    @PostMapping("/status-change")
    public ResponseEntity<String> trackOrderStatusChange(@RequestParam String orderId,
                                                         @RequestParam String expressCode) {
        orderTrackingExample.trackOrderStatusChange(orderId, expressCode);
        return ResponseEntity.ok("tracked");
    }
}
