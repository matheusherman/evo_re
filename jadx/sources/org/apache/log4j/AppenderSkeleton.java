package org.apache.log4j;

import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OnlyOnceErrorHandler;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.OptionHandler;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class AppenderSkeleton implements Appender, OptionHandler {
    protected Filter headFilter;
    protected Layout layout;
    protected String name;
    protected Filter tailFilter;
    protected Priority threshold;
    protected ErrorHandler errorHandler = new OnlyOnceErrorHandler();
    protected boolean closed = false;

    public AppenderSkeleton() {
    }

    protected abstract void append(LoggingEvent loggingEvent);

    @Override // org.apache.log4j.Appender
    public void clearFilters() {
        this.tailFilter = null;
        this.headFilter = null;
    }

    @Override // org.apache.log4j.Appender
    public synchronized void doAppend(LoggingEvent loggingEvent) {
        if (this.closed) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Attempted to append to closed appender named [");
            stringBuffer.append(this.name);
            stringBuffer.append("].");
            LogLog.error(stringBuffer.toString());
            return;
        }
        if (isAsSevereAsThreshold(loggingEvent.getLevel())) {
            Filter next = this.headFilter;
            while (next != null) {
                int iDecide = next.decide(loggingEvent);
                if (iDecide == -1) {
                    return;
                }
                if (iDecide == 0) {
                    next = next.getNext();
                } else if (iDecide == 1) {
                    break;
                }
            }
            append(loggingEvent);
        }
    }

    @Override // org.apache.log4j.Appender
    public synchronized void setErrorHandler(ErrorHandler errorHandler) {
        try {
            if (errorHandler == null) {
                LogLog.warn("You have tried to set a null error-handler.");
            } else {
                this.errorHandler = errorHandler;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.log4j.Appender
    public void addFilter(Filter filter) {
        if (this.headFilter == null) {
            this.tailFilter = filter;
            this.headFilter = filter;
        } else {
            this.tailFilter.setNext(filter);
            this.tailFilter = filter;
        }
    }

    public void finalize() {
        if (this.closed) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Finalizing appender named [");
        stringBuffer.append(this.name);
        stringBuffer.append("].");
        LogLog.debug(stringBuffer.toString());
        close();
    }

    @Override // org.apache.log4j.Appender
    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    @Override // org.apache.log4j.Appender
    public Filter getFilter() {
        return this.headFilter;
    }

    public final Filter getFirstFilter() {
        return this.headFilter;
    }

    @Override // org.apache.log4j.Appender
    public Layout getLayout() {
        return this.layout;
    }

    @Override // org.apache.log4j.Appender
    public final String getName() {
        return this.name;
    }

    public Priority getThreshold() {
        return this.threshold;
    }

    public boolean isAsSevereAsThreshold(Priority priority) {
        Priority priority2 = this.threshold;
        return priority2 == null || priority.isGreaterOrEqual(priority2);
    }

    @Override // org.apache.log4j.Appender
    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    @Override // org.apache.log4j.Appender
    public void setName(String str) {
        this.name = str;
    }

    public void setThreshold(Priority priority) {
        this.threshold = priority;
    }

    protected AppenderSkeleton(boolean z10) {
    }

    @Override // org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
    }
}
