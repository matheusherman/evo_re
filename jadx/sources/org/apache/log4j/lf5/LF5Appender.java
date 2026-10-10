package org.apache.log4j.lf5;

import java.awt.Toolkit;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.lf5.viewer.LogBrokerMonitor;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LF5Appender extends AppenderSkeleton {
    protected static LogBrokerMonitor _defaultLogMonitor;
    protected static AppenderFinalizer _finalizer;
    protected LogBrokerMonitor _logMonitor;

    public LF5Appender() {
        this(getDefaultInstance());
    }

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return false;
    }

    public LF5Appender(LogBrokerMonitor logBrokerMonitor) {
        if (logBrokerMonitor != null) {
            this._logMonitor = logBrokerMonitor;
        }
    }

    protected static synchronized LogBrokerMonitor getDefaultInstance() {
        if (_defaultLogMonitor == null) {
            try {
                LogBrokerMonitor logBrokerMonitor = new LogBrokerMonitor(LogLevel.getLog4JLevels());
                _defaultLogMonitor = logBrokerMonitor;
                _finalizer = new AppenderFinalizer(logBrokerMonitor);
                _defaultLogMonitor.setFrameSize(getDefaultMonitorWidth(), getDefaultMonitorHeight());
                _defaultLogMonitor.setFontSize(12);
                _defaultLogMonitor.show();
            } catch (SecurityException unused) {
                _defaultLogMonitor = null;
            }
        }
        return _defaultLogMonitor;
    }

    public static void main(String[] strArr) {
        new LF5Appender();
    }

    public boolean equals(LF5Appender lF5Appender) {
        return this._logMonitor == lF5Appender.getLogBrokerMonitor();
    }

    public LogBrokerMonitor getLogBrokerMonitor() {
        return this._logMonitor;
    }

    public void setCallSystemExitOnClose(boolean z10) {
        this._logMonitor.setCallSystemExitOnClose(z10);
    }

    public void setMaxNumberOfRecords(int i10) {
        _defaultLogMonitor.setMaxNumberOfLogRecords(i10);
    }

    protected static int getDefaultMonitorHeight() {
        return (getScreenHeight() * 3) / 4;
    }

    protected static int getDefaultMonitorWidth() {
        return (getScreenWidth() * 3) / 4;
    }

    protected static int getScreenHeight() {
        try {
            return Toolkit.getDefaultToolkit().getScreenSize().height;
        } catch (Throwable unused) {
            return 600;
        }
    }

    protected static int getScreenWidth() {
        try {
            return Toolkit.getDefaultToolkit().getScreenSize().width;
        } catch (Throwable unused) {
            return 800;
        }
    }

    @Override // org.apache.log4j.AppenderSkeleton
    public void append(LoggingEvent loggingEvent) {
        String loggerName = loggingEvent.getLoggerName();
        String renderedMessage = loggingEvent.getRenderedMessage();
        String ndc = loggingEvent.getNDC();
        String threadName = loggingEvent.getThreadName();
        String string = loggingEvent.getLevel().toString();
        long j10 = loggingEvent.timeStamp;
        LocationInfo locationInformation = loggingEvent.getLocationInformation();
        Log4JLogRecord log4JLogRecord = new Log4JLogRecord();
        log4JLogRecord.setCategory(loggerName);
        log4JLogRecord.setMessage(renderedMessage);
        log4JLogRecord.setLocation(locationInformation.fullInfo);
        log4JLogRecord.setMillis(j10);
        log4JLogRecord.setThreadDescription(threadName);
        if (ndc != null) {
            log4JLogRecord.setNDC(ndc);
        } else {
            log4JLogRecord.setNDC("");
        }
        if (loggingEvent.getThrowableInformation() != null) {
            log4JLogRecord.setThrownStackTrace(loggingEvent.getThrowableInformation());
        }
        try {
            log4JLogRecord.setLevel(LogLevel.valueOf(string));
        } catch (LogLevelFormatException unused) {
            log4JLogRecord.setLevel(LogLevel.WARN);
        }
        LogBrokerMonitor logBrokerMonitor = this._logMonitor;
        if (logBrokerMonitor != null) {
            logBrokerMonitor.addMessage(log4JLogRecord);
        }
    }

    @Override // org.apache.log4j.Appender
    public void close() {
    }
}
