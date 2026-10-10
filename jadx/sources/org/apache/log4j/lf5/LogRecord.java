package org.apache.log4j.lf5;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class LogRecord implements Serializable {
    protected static long _seqCount;
    protected Throwable _thrown;
    protected String _thrownStackTrace;
    protected long _millis = System.currentTimeMillis();
    protected String _category = "Debug";
    protected String _message = "";
    protected LogLevel _level = LogLevel.INFO;
    protected long _sequenceNumber = getNextId();
    protected String _thread = Thread.currentThread().toString();
    protected String _ndc = "";
    protected String _location = "";

    public abstract boolean isSevereLevel();

    protected static synchronized long getNextId() {
        long j10;
        j10 = _seqCount + 1;
        _seqCount = j10;
        return j10;
    }

    public static synchronized void resetSequenceNumber() {
        _seqCount = 0L;
    }

    public String getCategory() {
        return this._category;
    }

    public LogLevel getLevel() {
        return this._level;
    }

    public String getLocation() {
        return this._location;
    }

    public String getMessage() {
        return this._message;
    }

    public long getMillis() {
        return this._millis;
    }

    public String getNDC() {
        return this._ndc;
    }

    public long getSequenceNumber() {
        return this._sequenceNumber;
    }

    public String getThreadDescription() {
        return this._thread;
    }

    public Throwable getThrown() {
        return this._thrown;
    }

    public String getThrownStackTrace() {
        return this._thrownStackTrace;
    }

    public void setCategory(String str) {
        this._category = str;
    }

    public void setLevel(LogLevel logLevel) {
        this._level = logLevel;
    }

    public void setLocation(String str) {
        this._location = str;
    }

    public void setMessage(String str) {
        this._message = str;
    }

    public void setMillis(long j10) {
        this._millis = j10;
    }

    public void setNDC(String str) {
        this._ndc = str;
    }

    public void setSequenceNumber(long j10) {
        this._sequenceNumber = j10;
    }

    public void setThreadDescription(String str) {
        this._thread = str;
    }

    public void setThrown(Throwable th) {
        if (th == null) {
            return;
        }
        this._thrown = th;
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        this._thrownStackTrace = stringWriter.toString();
        try {
            printWriter.close();
            stringWriter.close();
        } catch (IOException unused) {
        }
    }

    public void setThrownStackTrace(String str) {
        this._thrownStackTrace = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("LogRecord: [");
        stringBuffer2.append(this._level);
        stringBuffer2.append(", ");
        stringBuffer2.append(this._message);
        stringBuffer2.append("]");
        stringBuffer.append(stringBuffer2.toString());
        return stringBuffer.toString();
    }

    public boolean hasThrown() {
        String string;
        Throwable thrown = getThrown();
        if (thrown == null || (string = thrown.toString()) == null || string.trim().length() == 0) {
            return false;
        }
        return true;
    }

    public boolean isFatal() {
        if (!isSevereLevel() && !hasThrown()) {
            return false;
        }
        return true;
    }
}
