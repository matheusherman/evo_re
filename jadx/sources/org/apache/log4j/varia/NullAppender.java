package org.apache.log4j.varia;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class NullAppender extends AppenderSkeleton {
    private static NullAppender instance = new NullAppender();

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return false;
    }

    public static NullAppender getNullAppender() {
        return instance;
    }

    public NullAppender getInstance() {
        return instance;
    }

    @Override // org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
    }

    @Override // org.apache.log4j.Appender
    public void close() {
    }

    @Override // org.apache.log4j.AppenderSkeleton
    protected void append(LoggingEvent loggingEvent) {
    }

    @Override // org.apache.log4j.AppenderSkeleton, org.apache.log4j.Appender
    public void doAppend(LoggingEvent loggingEvent) {
    }
}
