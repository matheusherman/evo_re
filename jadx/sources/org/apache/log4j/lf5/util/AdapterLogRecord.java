package org.apache.log4j.lf5.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.log4j.lf5.LogLevel;
import org.apache.log4j.lf5.LogRecord;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class AdapterLogRecord extends LogRecord {
    private static LogLevel severeLevel;
    private static StringWriter sw = new StringWriter();
    private static PrintWriter pw = new PrintWriter(sw);

    public static LogLevel getSevereLevel() {
        return severeLevel;
    }

    public static void setSevereLevel(LogLevel logLevel) {
        severeLevel = logLevel;
    }

    protected String getLocationInfo(String str) {
        return parseLine(stackTraceToString(new Throwable()), str);
    }

    @Override // org.apache.log4j.lf5.LogRecord
    public boolean isSevereLevel() {
        LogLevel logLevel = severeLevel;
        if (logLevel == null) {
            return false;
        }
        return logLevel.equals(getLevel());
    }

    protected String stackTraceToString(Throwable th) {
        String string;
        synchronized (sw) {
            th.printStackTrace(pw);
            string = sw.toString();
            sw.getBuffer().setLength(0);
        }
        return string;
    }

    protected String parseLine(String str, String str2) {
        int iIndexOf = str.indexOf(str2);
        if (iIndexOf == -1) {
            return null;
        }
        String strSubstring = str.substring(iIndexOf);
        return strSubstring.substring(0, strSubstring.indexOf(")") + 1);
    }

    @Override // org.apache.log4j.lf5.LogRecord
    public void setCategory(String str) {
        super.setCategory(str);
        super.setLocation(getLocationInfo(str));
    }
}
