package org.apache.log4j.rewrite;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ReflectionRewritePolicy implements RewritePolicy {
    static /* synthetic */ Class class$java$lang$Object;

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    @Override // org.apache.log4j.rewrite.RewritePolicy
    public LoggingEvent rewrite(LoggingEvent loggingEvent) throws Throwable {
        Category logger;
        Object message = loggingEvent.getMessage();
        if (!(message instanceof String)) {
            HashMap map = new HashMap(loggingEvent.getProperties());
            try {
                Class<?> cls = message.getClass();
                Class clsClass$ = class$java$lang$Object;
                if (clsClass$ == null) {
                    clsClass$ = class$("java.lang.Object");
                    class$java$lang$Object = clsClass$;
                }
                PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(cls, clsClass$).getPropertyDescriptors();
                if (propertyDescriptors.length > 0) {
                    Object obj = message;
                    for (int i10 = 0; i10 < propertyDescriptors.length; i10++) {
                        try {
                            Object objInvoke = propertyDescriptors[i10].getReadMethod().invoke(message, null);
                            if ("message".equalsIgnoreCase(propertyDescriptors[i10].getName())) {
                                obj = objInvoke;
                            } else {
                                map.put(propertyDescriptors[i10].getName(), objInvoke);
                            }
                        } catch (Exception e10) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("Unable to evaluate property ");
                            stringBuffer.append(propertyDescriptors[i10].getName());
                            LogLog.warn(stringBuffer.toString(), e10);
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
            } catch (Exception e11) {
                LogLog.warn("Unable to get property descriptors", e11);
            }
        }
        return loggingEvent;
    }
}
