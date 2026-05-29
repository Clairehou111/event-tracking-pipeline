package com.example.utils;

import com.alibaba.ttl.TransmittableThreadLocal;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 线程上下文工具类,使用的时候记得在请求链路中要释放。
 * 注意：在使用上下文中，切记一定要记得资源释放
 * 如在每个方法执行结束的时候手动释放，或者在全局过滤器或者拦截器中释放(推荐使用)
 *
 *
 */
public final class PMFContextHolder {

    private static final TransmittableThreadLocal<Map<String, Object>> THREAD_LOCAL_CONTEXT = new TransmittableThreadLocal<Map<String, Object>>();

    private PMFContextHolder() {
    }

    public static <T> T getContextValue(String key, Class<T> clz) {
        return Optional.ofNullable(getBusinessExt().get(key))
                .filter(clz::isInstance)
                .map(clz::cast)
                .orElse(null);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getContextValue(String namespace) {
        return (T) getBusinessExt().get(namespace);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getContextValue(Class targetClass) {
        return (T) getBusinessExt().get(targetClass.getName());
    }

    public static String getContextStringValue(String key) {
        return getContextValue(key, String.class);
    }

    public static String getContextStringValue(String key, String defaultValue) {
        String contextValue = getContextStringValue(key);
        if (StringUtils.isEmpty(contextValue)) {
            return defaultValue;
        }
        return contextValue;
    }

    public static void addContextValue(String key, Object val) {
        getBusinessExt().put(key, val);
    }

    public static Object removeContextValue(String key) {
        return getBusinessExt().remove(key);
    }

    public static Map<String, Object> getBusinessExt() {
        Map<String, Object> map = THREAD_LOCAL_CONTEXT.get();
        if (map == null) {
            THREAD_LOCAL_CONTEXT.set(new HashMap<>());
            return THREAD_LOCAL_CONTEXT.get();
        }
        return map;
    }

    public static void clearContextValue() {
        THREAD_LOCAL_CONTEXT.remove();
    }

}