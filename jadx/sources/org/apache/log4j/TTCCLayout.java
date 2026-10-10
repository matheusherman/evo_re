package org.apache.log4j;

import java.util.TimeZone;
import org.apache.log4j.helpers.DateLayout;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class TTCCLayout extends DateLayout {
    private boolean threadPrinting = true;
    private boolean categoryPrefixing = true;
    private boolean contextPrinting = true;
    protected final StringBuffer buf = new StringBuffer(256);

    public TTCCLayout() {
        setDateFormat(DateLayout.RELATIVE_TIME_DATE_FORMAT, (TimeZone) null);
    }

    @Override // org.apache.log4j.Layout
    public boolean ignoresThrowable() {
        return true;
    }

    @Override // org.apache.log4j.Layout
    public String format(LoggingEvent loggingEvent) {
        String ndc;
        this.buf.setLength(0);
        dateFormat(this.buf, loggingEvent);
        if (this.threadPrinting) {
            this.buf.append('[');
            this.buf.append(loggingEvent.getThreadName());
            this.buf.append("] ");
        }
        this.buf.append(loggingEvent.getLevel().toString());
        this.buf.append(' ');
        if (this.categoryPrefixing) {
            this.buf.append(loggingEvent.getLoggerName());
            this.buf.append(' ');
        }
        if (this.contextPrinting && (ndc = loggingEvent.getNDC()) != null) {
            this.buf.append(ndc);
            this.buf.append(' ');
        }
        this.buf.append("- ");
        this.buf.append(loggingEvent.getRenderedMessage());
        this.buf.append(Layout.LINE_SEP);
        return this.buf.toString();
    }

    public boolean getCategoryPrefixing() {
        return this.categoryPrefixing;
    }

    public boolean getContextPrinting() {
        return this.contextPrinting;
    }

    public boolean getThreadPrinting() {
        return this.threadPrinting;
    }

    public void setCategoryPrefixing(boolean z10) {
        this.categoryPrefixing = z10;
    }

    public void setContextPrinting(boolean z10) {
        this.contextPrinting = z10;
    }

    public void setThreadPrinting(boolean z10) {
        this.threadPrinting = z10;
    }

    public TTCCLayout(String str) {
        setDateFormat(str);
    }
}
