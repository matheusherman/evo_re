package org.apache.log4j.pattern;

import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class LevelPatternConverter extends LoggingEventPatternConverter {
    private static final LevelPatternConverter INSTANCE = new LevelPatternConverter();
    private static final int TRACE_INT = 5000;

    private LevelPatternConverter() {
        super("Level", "level");
    }

    public static LevelPatternConverter newInstance(String[] strArr) {
        return INSTANCE;
    }

    @Override // org.apache.log4j.pattern.PatternConverter
    public String getStyleClass(Object obj) {
        if (!(obj instanceof LoggingEvent)) {
            return "level";
        }
        LoggingEvent loggingEvent = (LoggingEvent) obj;
        int i10 = loggingEvent.getLevel().toInt();
        if (i10 == TRACE_INT) {
            return "level trace";
        }
        if (i10 == 10000) {
            return "level debug";
        }
        if (i10 == 20000) {
            return "level info";
        }
        if (i10 == 30000) {
            return "level warn";
        }
        if (i10 == 40000) {
            return "level error";
        }
        if (i10 == 50000) {
            return "level fatal";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("level ");
        stringBuffer.append(loggingEvent.getLevel().toString());
        return stringBuffer.toString();
    }

    @Override // org.apache.log4j.pattern.LoggingEventPatternConverter
    public void format(LoggingEvent loggingEvent, StringBuffer stringBuffer) {
        stringBuffer.append(loggingEvent.getLevel().toString());
    }
}
