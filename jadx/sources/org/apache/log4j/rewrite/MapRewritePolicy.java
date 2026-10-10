package org.apache.log4j.rewrite;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class MapRewritePolicy implements RewritePolicy {
    @Override // org.apache.log4j.rewrite.RewritePolicy
    public LoggingEvent rewrite(LoggingEvent loggingEvent) {
        Object obj;
        Category logger;
        Object message = loggingEvent.getMessage();
        if (message instanceof Map) {
            HashMap map = new HashMap(loggingEvent.getProperties());
            Map map2 = (Map) message;
            Object obj2 = map2.get("message");
            if (obj2 == null) {
                obj = message;
            } else {
                obj = obj2;
            }
            for (Map.Entry entry : map2.entrySet()) {
                if (!"message".equals(entry.getKey())) {
                    map.put(entry.getKey(), entry.getValue());
                }
            }
            String fQNOfLoggerClass = loggingEvent.getFQNOfLoggerClass();
            if (loggingEvent.getLogger() != null) {
                logger = loggingEvent.getLogger();
            } else {
                logger = Logger.getLogger(loggingEvent.getLoggerName());
            }
            return new LoggingEvent(fQNOfLoggerClass, logger, loggingEvent.getTimeStamp(), loggingEvent.getLevel(), obj, loggingEvent.getThreadName(), loggingEvent.getThrowableInformation(), loggingEvent.getNDC(), loggingEvent.getLocationInformation(), map);
        }
        return loggingEvent;
    }
}
