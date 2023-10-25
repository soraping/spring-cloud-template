package com.fangzheng.common.config.kafka;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.github.danielwegener.logback.kafka.keying.KeyingStrategy;

import java.util.Map;

public class LogKeyStrategy implements KeyingStrategy<Object> {

    @Override
    public byte[] createKey(Object e) {
        if (e instanceof ILoggingEvent) {
            ILoggingEvent logEvent = (ILoggingEvent) e;
            Map<String, String> mdcProperty = logEvent.getMDCPropertyMap();
            String traceId = mdcProperty.get("X-B3-TraceId");
            if (traceId != null && traceId.length() > 0) {
                return traceId.getBytes();
            }
        }
        return null;
    }
}
