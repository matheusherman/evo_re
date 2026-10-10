package org.apache.log4j.pattern;

import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class LoggingEventPatternConverter extends PatternConverter {
    @Override // org.apache.log4j.pattern.PatternConverter
    public void format(Object obj, StringBuffer stringBuffer) {
        if (obj instanceof LoggingEvent) {
            format((LoggingEvent) obj, stringBuffer);
        }
    }

    public abstract void format(LoggingEvent loggingEvent, StringBuffer stringBuffer);

    public boolean handlesThrowable() {
        return false;
    }

    protected LoggingEventPatternConverter(String str, String str2) {
        super(str, str2);
    }
}
