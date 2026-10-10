package org.apache.log4j.helpers;

import java.io.InterruptedIOException;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class OnlyOnceErrorHandler implements ErrorHandler {
    final String WARN_PREFIX = "log4j warning: ";
    final String ERROR_PREFIX = "log4j error: ";
    boolean firstTime = true;

    @Override // org.apache.log4j.spi.ErrorHandler
    public void error(String str, Exception exc, int i10) {
        error(str, exc, i10, null);
    }

    @Override // org.apache.log4j.spi.ErrorHandler
    public void error(String str, Exception exc, int i10, LoggingEvent loggingEvent) {
        if ((exc instanceof InterruptedIOException) || (exc instanceof InterruptedException)) {
            Thread.currentThread().interrupt();
        }
        if (this.firstTime) {
            LogLog.error(str, exc);
            this.firstTime = false;
        }
    }

    @Override // org.apache.log4j.spi.ErrorHandler
    public void error(String str) {
        if (this.firstTime) {
            LogLog.error(str);
            this.firstTime = false;
        }
    }

    @Override // org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
    }

    @Override // org.apache.log4j.spi.ErrorHandler
    public void setAppender(Appender appender) {
    }

    @Override // org.apache.log4j.spi.ErrorHandler
    public void setBackupAppender(Appender appender) {
    }

    @Override // org.apache.log4j.spi.ErrorHandler
    public void setLogger(Logger logger) {
    }
}
