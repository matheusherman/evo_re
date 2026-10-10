package org.apache.log4j;

import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class SimpleLayout extends Layout {
    StringBuffer sbuf = new StringBuffer(128);

    @Override // org.apache.log4j.Layout
    public boolean ignoresThrowable() {
        return true;
    }

    @Override // org.apache.log4j.Layout
    public String format(LoggingEvent loggingEvent) {
        this.sbuf.setLength(0);
        this.sbuf.append(loggingEvent.getLevel().toString());
        this.sbuf.append(" - ");
        this.sbuf.append(loggingEvent.getRenderedMessage());
        this.sbuf.append(Layout.LINE_SEP);
        return this.sbuf.toString();
    }

    @Override // org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
    }
}
