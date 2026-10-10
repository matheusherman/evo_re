package org.apache.log4j;

import com.pengrad.telegrambot.request.ContentTypes;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.OptionHandler;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class Layout implements OptionHandler {
    public static final String LINE_SEP;
    public static final int LINE_SEP_LEN;

    public abstract String format(LoggingEvent loggingEvent);

    public String getFooter() {
        return null;
    }

    public String getHeader() {
        return null;
    }

    public abstract boolean ignoresThrowable();

    static {
        String property = System.getProperty("line.separator");
        LINE_SEP = property;
        LINE_SEP_LEN = property.length();
    }

    public String getContentType() {
        return ContentTypes.DOC_MIME_TYPE;
    }
}
