package org.apache.log4j.pattern;

import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class LoggerPatternConverter extends NamePatternConverter {
    private static final LoggerPatternConverter INSTANCE = new LoggerPatternConverter(null);

    private LoggerPatternConverter(String[] strArr) {
        super("Logger", "logger", strArr);
    }

    public static LoggerPatternConverter newInstance(String[] strArr) {
        return (strArr == null || strArr.length == 0) ? INSTANCE : new LoggerPatternConverter(strArr);
    }

    @Override // org.apache.log4j.pattern.LoggingEventPatternConverter
    public void format(LoggingEvent loggingEvent, StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        stringBuffer.append(loggingEvent.getLoggerName());
        abbreviate(length, stringBuffer);
    }
}
