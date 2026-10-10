package org.apache.log4j;

import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public interface Appender {
    void addFilter(Filter filter);

    void clearFilters();

    void close();

    void doAppend(LoggingEvent loggingEvent);

    ErrorHandler getErrorHandler();

    Filter getFilter();

    Layout getLayout();

    String getName();

    boolean requiresLayout();

    void setErrorHandler(ErrorHandler errorHandler);

    void setLayout(Layout layout);

    void setName(String str);
}
