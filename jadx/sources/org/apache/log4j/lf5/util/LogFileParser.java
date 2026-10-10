package org.apache.log4j.lf5.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.SwingUtilities;
import org.apache.log4j.lf5.Log4JLogRecord;
import org.apache.log4j.lf5.LogLevel;
import org.apache.log4j.lf5.LogLevelFormatException;
import org.apache.log4j.lf5.LogRecord;
import org.apache.log4j.lf5.viewer.LogBrokerMonitor;
import org.apache.log4j.lf5.viewer.LogFactor5ErrorDialog;
import org.apache.log4j.lf5.viewer.LogFactor5LoadingDialog;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LogFileParser implements Runnable {
    public static final String ATTRIBUTE_DELIMITER = "[slf5s.";
    public static final String CATEGORY_DELIMITER = "[slf5s.CATEGORY]";
    public static final String DATE_DELIMITER = "[slf5s.DATE]";
    public static final String LOCATION_DELIMITER = "[slf5s.LOCATION]";
    public static final String MESSAGE_DELIMITER = "[slf5s.MESSAGE]";
    public static final String NDC_DELIMITER = "[slf5s.NDC]";
    public static final String PRIORITY_DELIMITER = "[slf5s.PRIORITY]";
    public static final String RECORD_DELIMITER = "[slf5s.start]";
    public static final String THREAD_DELIMITER = "[slf5s.THREAD]";
    private static SimpleDateFormat _sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss,S");
    private InputStream _in;
    LogFactor5LoadingDialog _loadDialog;
    private LogBrokerMonitor _monitor;

    public LogFileParser(File file) {
        this(new FileInputStream(file));
    }

    public LogFileParser(InputStream inputStream) {
        this._in = inputStream;
    }

    private LogRecord createLogRecord(String str) {
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        Log4JLogRecord log4JLogRecord = new Log4JLogRecord();
        log4JLogRecord.setMillis(parseDate(str));
        log4JLogRecord.setLevel(parsePriority(str));
        log4JLogRecord.setCategory(parseCategory(str));
        log4JLogRecord.setLocation(parseLocation(str));
        log4JLogRecord.setThreadDescription(parseThread(str));
        log4JLogRecord.setNDC(parseNDC(str));
        log4JLogRecord.setMessage(parseMessage(str));
        log4JLogRecord.setThrownStackTrace(parseThrowable(str));
        return log4JLogRecord;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyDialog() {
        this._loadDialog.hide();
        this._loadDialog.dispose();
    }

    private String getAttribute(int i10, String str) {
        int iLastIndexOf = str.lastIndexOf(ATTRIBUTE_DELIMITER, i10 - 1);
        return iLastIndexOf == -1 ? str.substring(0, i10) : str.substring(str.indexOf("]", iLastIndexOf) + 1, i10).trim();
    }

    private String loadLogFile(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        int iAvailable = bufferedInputStream.available();
        StringBuffer stringBuffer = iAvailable > 0 ? new StringBuffer(iAvailable) : new StringBuffer(1024);
        while (true) {
            int i10 = bufferedInputStream.read();
            if (i10 == -1) {
                bufferedInputStream.close();
                return stringBuffer.toString();
            }
            stringBuffer.append((char) i10);
        }
    }

    private String parseCategory(String str) {
        return parseAttribute(CATEGORY_DELIMITER, str);
    }

    private long parseDate(String str) {
        try {
            String attribute = parseAttribute(DATE_DELIMITER, str);
            if (attribute == null) {
                return 0L;
            }
            return _sdf.parse(attribute).getTime();
        } catch (ParseException unused) {
            return 0L;
        }
    }

    private String parseLocation(String str) {
        return parseAttribute(LOCATION_DELIMITER, str);
    }

    private String parseMessage(String str) {
        return parseAttribute(MESSAGE_DELIMITER, str);
    }

    private String parseNDC(String str) {
        return parseAttribute(NDC_DELIMITER, str);
    }

    private LogLevel parsePriority(String str) {
        String attribute = parseAttribute(PRIORITY_DELIMITER, str);
        if (attribute == null) {
            return LogLevel.DEBUG;
        }
        try {
            return LogLevel.valueOf(attribute);
        } catch (LogLevelFormatException unused) {
            return LogLevel.DEBUG;
        }
    }

    private String parseThread(String str) {
        return parseAttribute(THREAD_DELIMITER, str);
    }

    protected void displayError(String str) {
        new LogFactor5ErrorDialog(this._monitor.getBaseFrame(), str);
    }

    public void parse(LogBrokerMonitor logBrokerMonitor) {
        this._monitor = logBrokerMonitor;
        new Thread(this).start();
    }

    @Override // java.lang.Runnable
    public void run() {
        LogRecord logRecordCreateLogRecord;
        this._loadDialog = new LogFactor5LoadingDialog(this._monitor.getBaseFrame(), "Loading file...");
        try {
            String strLoadLogFile = loadLogFile(this._in);
            int i10 = 0;
            boolean z10 = false;
            while (true) {
                int iIndexOf = strLoadLogFile.indexOf(RECORD_DELIMITER, i10);
                if (iIndexOf == -1) {
                    break;
                }
                LogRecord logRecordCreateLogRecord2 = createLogRecord(strLoadLogFile.substring(i10, iIndexOf));
                if (logRecordCreateLogRecord2 != null) {
                    this._monitor.addMessage(logRecordCreateLogRecord2);
                }
                i10 = iIndexOf + 13;
                z10 = true;
            }
            if (i10 < strLoadLogFile.length() && z10 && (logRecordCreateLogRecord = createLogRecord(strLoadLogFile.substring(i10))) != null) {
                this._monitor.addMessage(logRecordCreateLogRecord);
            }
            if (!z10) {
                throw new RuntimeException("Invalid log file format");
            }
            SwingUtilities.invokeLater(new Runnable() { // from class: org.apache.log4j.lf5.util.LogFileParser.1
                @Override // java.lang.Runnable
                public void run() {
                    LogFileParser.this.destroyDialog();
                }
            });
            this._in = null;
        } catch (IOException unused) {
            destroyDialog();
            displayError("Error - Unable to load log file!");
        } catch (RuntimeException unused2) {
            destroyDialog();
            displayError("Error - Invalid log file format.\nPlease see documentation on how to load log files.");
        }
    }

    private String parseAttribute(String str, String str2) {
        int iIndexOf = str2.indexOf(str);
        if (iIndexOf == -1) {
            return null;
        }
        return getAttribute(iIndexOf, str2);
    }

    private String parseThrowable(String str) {
        return getAttribute(str.length(), str);
    }
}
