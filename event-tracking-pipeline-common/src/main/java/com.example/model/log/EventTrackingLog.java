package com.example.model.log;

import com.demo.framework.bigdata.log.BigDataLog;

public final class EventTrackingLog {

    private EventTrackingLog() {
    }

    public static void log(BaseEventTrackingLog eventTrackingLog) {
        BigDataLog.log(eventTrackingLog);
    }

    public static void asyncLog(BaseEventTrackingLog eventTrackingLog) {
        BigDataLog.asyncLog(eventTrackingLog);
    }
}
