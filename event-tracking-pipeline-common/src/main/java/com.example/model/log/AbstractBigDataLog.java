package com.example.model.log;


import com.demo.framework.bigdata.log.model.BaseBigDataLog;
import com.example.model.user.HttpHeaderContext;
import com.example.model.user.OperationUserContext;
import lombok.Getter;
import lombok.Setter;


import com.example.constants.BigDataSceneKeyEnum;
import com.example.model.user.OperationUserContextHolder;
import java.util.Objects;

@Getter
@Setter
public abstract class AbstractBigDataLog extends BaseBigDataLog {
    
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

    public AbstractBigDataLog(BigDataSceneKeyEnum bigDataSceneKeyEnum) {
        super(bigDataSceneKeyEnum.getSceneKey(), bigDataSceneKeyEnum.getSceneDesc());
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

//        HttpHeaderContext headerContext = PhoenixContext.getHttpHeader();
//        if (Objects.nonNull(headerContext)) {
//            this.setPlatform(headerContext.getPlatform());
//            this.setDeviceId(headerContext.getDeviceId());
//            this.setAppBuild(headerContext.getAppBuild());
//            this.setActionCode(headerContext.getActionCode());
//            this.setTerminalSource(headerContext.getTerminalSource());
//        }
    }
}
