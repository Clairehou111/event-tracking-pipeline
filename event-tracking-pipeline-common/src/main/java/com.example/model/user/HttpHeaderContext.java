package com.example.model.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class HttpHeaderContext implements Serializable {
    public static String IOS = "iPhone";
    public static String Android = "Android";
    private String userId;
    private String userName;
    private String platform;
    private String deviceId;
    private String userAgent;
    private String appVersion;
    private String appBuild;
    private String acceptLanguage;
    
    private String actionCode;

    private String terminalSource;
}
