package org.apache.log4j.lf5.util;

import java.awt.Toolkit;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.lf5.LogLevel;
import org.apache.log4j.lf5.LogRecord;
import org.apache.log4j.lf5.viewer.LogBrokerMonitor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LogMonitorAdapter {
    public static final int JDK14_LOG_LEVELS = 1;
    public static final int LOG4J_LOG_LEVELS = 0;
    private LogLevel _defaultLevel;
    private LogBrokerMonitor _logMonitor;

    public static LogMonitorAdapter newInstance(int i10) {
        if (i10 == 1) {
            LogMonitorAdapter logMonitorAdapterNewInstance = newInstance(LogLevel.getJdk14Levels());
            logMonitorAdapterNewInstance.setDefaultLevel(LogLevel.FINEST);
            logMonitorAdapterNewInstance.setSevereLevel(LogLevel.SEVERE);
            return logMonitorAdapterNewInstance;
        }
        LogMonitorAdapter logMonitorAdapterNewInstance2 = newInstance(LogLevel.getLog4JLevels());
        logMonitorAdapterNewInstance2.setDefaultLevel(LogLevel.DEBUG);
        logMonitorAdapterNewInstance2.setSevereLevel(LogLevel.FATAL);
        return logMonitorAdapterNewInstance2;
    }

    public void log(String str, LogLevel logLevel, String str2, Throwable th, String str3) {
        AdapterLogRecord adapterLogRecord = new AdapterLogRecord();
        adapterLogRecord.setCategory(str);
        adapterLogRecord.setMessage(str2);
        adapterLogRecord.setNDC(str3);
        adapterLogRecord.setThrown(th);
        if (logLevel == null) {
            adapterLogRecord.setLevel(getDefaultLevel());
        } else {
            adapterLogRecord.setLevel(logLevel);
        }
        addMessage(adapterLogRecord);
    }

    public void addMessage(LogRecord logRecord) {
        this._logMonitor.addMessage(logRecord);
    }

    public LogLevel getDefaultLevel() {
        return this._defaultLevel;
    }

    public void setDefaultLevel(LogLevel logLevel) {
        this._defaultLevel = logLevel;
    }

    public void setMaxNumberOfRecords(int i10) {
        this._logMonitor.setMaxNumberOfLogRecords(i10);
    }

    private LogMonitorAdapter(List list) {
        this._defaultLevel = null;
        this._defaultLevel = (LogLevel) list.get(0);
        LogBrokerMonitor logBrokerMonitor = new LogBrokerMonitor(list);
        this._logMonitor = logBrokerMonitor;
        logBrokerMonitor.setFrameSize(getDefaultMonitorWidth(), getDefaultMonitorHeight());
        this._logMonitor.setFontSize(12);
        this._logMonitor.show();
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

    public LogLevel getSevereLevel() {
        return AdapterLogRecord.getSevereLevel();
    }

    public void setSevereLevel(LogLevel logLevel) {
        AdapterLogRecord.setSevereLevel(logLevel);
    }

    public static LogMonitorAdapter newInstance(LogLevel[] logLevelArr) {
        if (logLevelArr == null) {
            return null;
        }
        return newInstance(Arrays.asList(logLevelArr));
    }

    public static LogMonitorAdapter newInstance(List list) {
        return new LogMonitorAdapter(list);
    }

    public void log(String str, String str2) {
        log(str, null, str2);
    }

    public void log(String str, LogLevel logLevel, String str2, String str3) {
        log(str, logLevel, str2, null, str3);
    }

    public void log(String str, LogLevel logLevel, String str2, Throwable th) {
        log(str, logLevel, str2, th, null);
    }

    public void log(String str, LogLevel logLevel, String str2) {
        log(str, logLevel, str2, null, null);
    }
}
