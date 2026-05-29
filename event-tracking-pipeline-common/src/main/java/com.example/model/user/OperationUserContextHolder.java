package com.example.model.user;



import lombok.Getter;
import lombok.Setter;

import com.example.utils.PMFContextHolder;
import java.io.Serializable;

public class OperationUserContextHolder implements Serializable {

    public static final String OPERATION_USER = "OPERATION_USER";
    public static final String HTTP_HEADER = "HTTP_HEADER";
    public static String TENANT_ID = "1";

    public static OperationUserContext getOperationUser() {
        OperationUserContext userContext = PMFContextHolder.getContextValue(OPERATION_USER);
        if (userContext == null) {
            userContext =getSystemOperationUser();
            PMFContextHolder.addContextValue(OPERATION_USER, userContext);
        }
        return userContext;
    }

    public static void setOperationUser(OperationUserContext operationUser) {
        if (operationUser == null) {
            return;
        }
        PMFContextHolder.addContextValue(OPERATION_USER, operationUser);
    }

    public static HttpHeaderContext getHttpHeader() {
        HttpHeaderContext headerContext = PMFContextHolder.getContextValue(HTTP_HEADER);
        if (headerContext == null) {
            headerContext = new HttpHeaderContext();
            PMFContextHolder.addContextValue(HTTP_HEADER, headerContext);
        }
        return headerContext;
    }

    public static OperationUserContext getSystemOperationUser() {
        OperationUserContext userContext = new OperationUserContext();
        userContext.setRealName("系统自动");
        userContext.setUserName("系统自动");
        userContext.setUserId(1L);
        userContext.setOperationRepositoryCode("");
        userContext.setOperationRepositoryName("");
        userContext.setTenantId(TENANT_ID);
        return userContext;
    }

    public static void setHttpHeader(HttpHeaderContext httpHeader) {
        if (httpHeader == null) {
            return;
        }
        PMFContextHolder.addContextValue(HTTP_HEADER, httpHeader);
    }

}
