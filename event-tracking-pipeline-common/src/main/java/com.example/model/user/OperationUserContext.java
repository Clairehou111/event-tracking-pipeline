package com.example.model.user;

import lombok.Getter;
import lombok.Setter;

public class OperationUserContext {
    @Getter
    @Setter
    private String realName;
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private Long userId;
    @Getter
    @Setter
    private String operationRepositoryCode;
    @Getter
    @Setter
    private String operationRepositoryName;
    @Getter
    @Setter
    private String tenantId;
    @Getter
    @Setter
    private String appVersion;
    @Getter
    @Setter
    private String stationNo;
    @Getter
    @Setter
    private String orgCode;
    @Getter
    @Setter
    private String orgName;
    @Getter
    @Setter
    private String orgFullName;
}
