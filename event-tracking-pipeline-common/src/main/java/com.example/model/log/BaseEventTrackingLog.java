package com.example.model.log;

import com.demo.framework.bigdata.log.model.BaseBigDataLog;
import com.example.constants.EventTrackingSceneKeyEnum;
import com.example.model.user.OperationUserContext;
import com.example.model.user.OperationUserContextHolder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public abstract class BaseEventTrackingLog extends BaseBigDataLog {

    private Long userId;

    private String userName;

    private String realName;

    private String operationRepositoryCode;

    private String operationRepositoryName;

    private String stationNo;

    private String appVersion;
    
    private String language;

    private String orgCode;

    private String orgName;

    private String orgFullName;

    private String platform;

    private String deviceId;

    private String appBuild;

    private String actionCode;

    private String terminalSource;

    public BaseEventTrackingLog(EventTrackingSceneKeyEnum eventTrackingSceneKeyEnum) {
        super(eventTrackingSceneKeyEnum.getSceneKey(), eventTrackingSceneKeyEnum.getSceneDesc());
        OperationUserContext userContext = OperationUserContextHolder.getOperationUser();
        if (Objects.nonNull(userContext)) {
            this.setRealName(userContext.getRealName());
            this.setAppVersion(userContext.getAppVersion());
            this.setOperationRepositoryName(userContext.getOperationRepositoryName());
            this.setOperationRepositoryCode(userContext.getOperationRepositoryCode());
            this.setStationNo(userContext.getStationNo());
            this.setOrgName(userContext.getOrgName());
            this.setOrgCode(userContext.getOrgCode());
            this.setOrgFullName(userContext.getOrgFullName());
        }

    }
}
