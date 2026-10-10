package org.apache.log4j;

import java.util.ResourceBundle;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class LogSF extends LogXF {
    private static final String FQCN;
    static /* synthetic */ Class class$org$apache$log4j$LogSF;

    public static void debug(Logger logger, String str, Object[] objArr) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, objArr));
        }
    }

    public static void error(Logger logger, String str, Object[] objArr) {
        Level level = Level.ERROR;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, objArr));
        }
    }

    public static void fatal(Logger logger, String str, Object[] objArr) {
        Level level = Level.FATAL;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, objArr));
        }
    }

    private static void forcedLog(Logger logger, Level level, String str) {
        logger.callAppenders(new LoggingEvent(FQCN, logger, level, str, null));
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0037  */
    private static String format(String str, Object[] objArr) {
        String string;
        int i10;
        String string2;
        int i11;
        int i12;
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf("{");
        int i13 = 0;
        String string3 = "";
        int i14 = 0;
        while (iIndexOf >= 0) {
            if (iIndexOf != 0) {
                int i15 = iIndexOf - 1;
                if (str.charAt(i15) != '\\') {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(string3);
                    stringBuffer.append(str.substring(i13, iIndexOf));
                    string = stringBuffer.toString();
                    i10 = iIndexOf + 1;
                    if (i10 < str.length() || str.charAt(i10) != '}') {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(string);
                        stringBuffer2.append("{");
                        i13 = i10;
                        string3 = stringBuffer2.toString();
                    } else {
                        if (objArr == null || i14 >= objArr.length) {
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append(string);
                            stringBuffer3.append("{}");
                            int i16 = i14;
                            string2 = stringBuffer3.toString();
                            i11 = i16;
                        } else {
                            StringBuffer stringBuffer4 = new StringBuffer();
                            stringBuffer4.append(string);
                            i11 = i14 + 1;
                            stringBuffer4.append(objArr[i14]);
                            string2 = stringBuffer4.toString();
                        }
                        i12 = iIndexOf + 2;
                        string3 = string2;
                        i14 = i11;
                    }
                } else {
                    StringBuffer stringBuffer5 = new StringBuffer();
                    stringBuffer5.append(string3);
                    stringBuffer5.append(str.substring(i13, i15));
                    stringBuffer5.append("{");
                    i12 = iIndexOf + 1;
                    string3 = stringBuffer5.toString();
                }
                i13 = i12;
            } else {
                StringBuffer stringBuffer6 = new StringBuffer();
                stringBuffer6.append(string3);
                stringBuffer6.append(str.substring(i13, iIndexOf));
                string = stringBuffer6.toString();
                i10 = iIndexOf + 1;
                if (i10 < str.length()) {
                }
                StringBuffer stringBuffer7 = new StringBuffer();
                stringBuffer7.append(string);
                stringBuffer7.append("{");
                i13 = i10;
                string3 = stringBuffer7.toString();
            }
            iIndexOf = str.indexOf("{", i13);
        }
        StringBuffer stringBuffer8 = new StringBuffer();
        stringBuffer8.append(string3);
        stringBuffer8.append(str.substring(i13));
        return stringBuffer8.toString();
    }

    public static void info(Logger logger, String str, Object[] objArr) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, objArr));
        }
    }

    public static void log(Logger logger, Level level, String str, Object[] objArr) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, objArr));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, Object[] objArr) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, objArr));
        }
    }

    public static void trace(Logger logger, String str, Object[] objArr) {
        Level level = LogXF.TRACE;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, objArr));
        }
    }

    public static void warn(Logger logger, String str, Object[] objArr) {
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, objArr));
        }
    }

    static {
        Class clsClass$ = class$org$apache$log4j$LogSF;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.LogSF");
            class$org$apache$log4j$LogSF = clsClass$;
        }
        FQCN = clsClass$.getName();
    }

    private static void forcedLog(Logger logger, Level level, String str, Throwable th) {
        logger.callAppenders(new LoggingEvent(FQCN, logger, level, str, th));
    }

    private LogSF() {
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    public static void debug(Logger logger, Throwable th, String str, Object[] objArr) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, objArr), th);
        }
    }

    public static void error(Logger logger, Throwable th, String str, Object[] objArr) {
        Level level = Level.ERROR;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, objArr), th);
        }
    }

    public static void fatal(Logger logger, Throwable th, String str, Object[] objArr) {
        Level level = Level.FATAL;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, objArr), th);
        }
    }

    public static void info(Logger logger, Throwable th, String str, Object[] objArr) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, objArr), th);
        }
    }

    public static void log(Logger logger, Level level, Throwable th, String str, Object[] objArr) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, objArr), th);
        }
    }

    public static void logrb(Logger logger, Level level, Throwable th, String str, String str2, Object[] objArr) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, objArr), th);
        }
    }

    public static void trace(Logger logger, Throwable th, String str, Object[] objArr) {
        Level level = LogXF.TRACE;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, objArr), th);
        }
    }

    public static void warn(Logger logger, Throwable th, String str, Object[] objArr) {
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, objArr), th);
        }
    }

    public static void debug(Logger logger, String str, boolean z10) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.valueOf(z10)));
        }
    }

    public static void info(Logger logger, String str, boolean z10) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.valueOf(z10)));
        }
    }

    public static void log(Logger logger, Level level, String str, Object obj) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(obj)));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, Object obj) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(obj)));
        }
    }

    public static void trace(Logger logger, String str, boolean z10) {
        Level level = LogXF.TRACE;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.valueOf(z10)));
        }
    }

    public static void warn(Logger logger, String str, boolean z10) {
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.valueOf(z10)));
        }
    }

    public static void debug(Logger logger, String str, char c10) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.valueOf(c10)));
        }
    }

    public static void info(Logger logger, String str, char c10) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.valueOf(c10)));
        }
    }

    public static void log(Logger logger, Level level, String str, boolean z10) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(LogXF.valueOf(z10))));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, boolean z10) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(LogXF.valueOf(z10))));
        }
    }

    public static void trace(Logger logger, String str, char c10) {
        Level level = LogXF.TRACE;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.valueOf(c10)));
        }
    }

    public static void warn(Logger logger, String str, char c10) {
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.valueOf(c10)));
        }
    }

    public static void debug(Logger logger, String str, byte b10) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.valueOf(b10)));
        }
    }

    public static void info(Logger logger, String str, byte b10) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.valueOf(b10)));
        }
    }

    public static void log(Logger logger, Level level, String str, byte b10) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(LogXF.valueOf(b10))));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, char c10) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(LogXF.valueOf(c10))));
        }
    }

    public static void trace(Logger logger, String str, byte b10) {
        Level level = LogXF.TRACE;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.valueOf(b10)));
        }
    }

    public static void warn(Logger logger, String str, byte b10) {
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.valueOf(b10)));
        }
    }

    public static void debug(Logger logger, String str, short s10) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.valueOf(s10)));
        }
    }

    public static void info(Logger logger, String str, short s10) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.valueOf(s10)));
        }
    }

    public static void log(Logger logger, Level level, String str, char c10) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(LogXF.valueOf(c10))));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, byte b10) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(LogXF.valueOf(b10))));
        }
    }

    public static void trace(Logger logger, String str, short s10) {
        Level level = LogXF.TRACE;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.valueOf(s10)));
        }
    }

    public static void warn(Logger logger, String str, short s10) {
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.valueOf(s10)));
        }
    }

    private static String format(String str, Object obj) {
        if (str == null) {
            return str;
        }
        if (str.indexOf("\\{") >= 0) {
            return format(str, new Object[]{obj});
        }
        int iIndexOf = str.indexOf("{}");
        if (iIndexOf < 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.substring(0, iIndexOf));
        stringBuffer.append(obj);
        stringBuffer.append(str.substring(iIndexOf + 2));
        return stringBuffer.toString();
    }

    public static void debug(Logger logger, String str, int i10) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.valueOf(i10)));
        }
    }

    public static void info(Logger logger, String str, int i10) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.valueOf(i10)));
        }
    }

    public static void log(Logger logger, Level level, String str, short s10) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(LogXF.valueOf(s10))));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, short s10) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(LogXF.valueOf(s10))));
        }
    }

    public static void trace(Logger logger, String str, int i10) {
        Level level = LogXF.TRACE;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.valueOf(i10)));
        }
    }

    public static void warn(Logger logger, String str, int i10) {
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.valueOf(i10)));
        }
    }

    public static void debug(Logger logger, String str, long j10) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.valueOf(j10)));
        }
    }

    public static void info(Logger logger, String str, long j10) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.valueOf(j10)));
        }
    }

    public static void log(Logger logger, Level level, String str, int i10) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(LogXF.valueOf(i10))));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, int i10) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(LogXF.valueOf(i10))));
        }
    }

    public static void trace(Logger logger, String str, long j10) {
        Level level = LogXF.TRACE;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.valueOf(j10)));
        }
    }

    public static void warn(Logger logger, String str, long j10) {
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.valueOf(j10)));
        }
    }

    private static String format(String str, String str2, Object[] objArr) {
        if (str != null) {
            try {
                str2 = ResourceBundle.getBundle(str).getString(str2);
            } catch (Exception unused) {
            }
        }
        return format(str2, objArr);
    }

    public static void debug(Logger logger, String str, float f10) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.valueOf(f10)));
        }
    }

    public static void info(Logger logger, String str, float f10) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.valueOf(f10)));
        }
    }

    public static void log(Logger logger, Level level, String str, long j10) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(LogXF.valueOf(j10))));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, long j10) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(LogXF.valueOf(j10))));
        }
    }

    public static void trace(Logger logger, String str, float f10) {
        Level level = LogXF.TRACE;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.valueOf(f10)));
        }
    }

    public static void warn(Logger logger, String str, float f10) {
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.valueOf(f10)));
        }
    }

    public static void debug(Logger logger, String str, double d10) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.valueOf(d10)));
        }
    }

    public static void info(Logger logger, String str, double d10) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.valueOf(d10)));
        }
    }

    public static void log(Logger logger, Level level, String str, float f10) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(LogXF.valueOf(f10))));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, float f10) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(LogXF.valueOf(f10))));
        }
    }

    public static void trace(Logger logger, String str, double d10) {
        Level level = LogXF.TRACE;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.valueOf(d10)));
        }
    }

    public static void warn(Logger logger, String str, double d10) {
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.valueOf(d10)));
        }
    }

    public static void debug(Logger logger, String str, Object obj) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, obj));
        }
    }

    public static void info(Logger logger, String str, Object obj) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, obj));
        }
    }

    public static void log(Logger logger, Level level, String str, double d10) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(LogXF.valueOf(d10))));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, double d10) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(LogXF.valueOf(d10))));
        }
    }

    public static void trace(Logger logger, String str, Object obj) {
        Level level = LogXF.TRACE;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, obj));
        }
    }

    public static void warn(Logger logger, String str, Object obj) {
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, obj));
        }
    }

    public static void debug(Logger logger, String str, Object obj, Object obj2) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.toArray(obj, obj2)));
        }
    }

    public static void info(Logger logger, String str, Object obj, Object obj2) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.toArray(obj, obj2)));
        }
    }

    public static void log(Logger logger, Level level, String str, Object obj, Object obj2) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(obj, obj2)));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, Object obj, Object obj2) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(obj, obj2)));
        }
    }

    public static void trace(Logger logger, String str, Object obj, Object obj2) {
        Level level = LogXF.TRACE;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(obj, obj2)));
        }
    }

    public static void warn(Logger logger, String str, Object obj, Object obj2) {
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(obj, obj2)));
        }
    }

    public static void debug(Logger logger, String str, Object obj, Object obj2, Object obj3) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.toArray(obj, obj2, obj3)));
        }
    }

    public static void info(Logger logger, String str, Object obj, Object obj2, Object obj3) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.toArray(obj, obj2, obj3)));
        }
    }

    public static void log(Logger logger, Level level, String str, Object obj, Object obj2, Object obj3) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(obj, obj2, obj3)));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, Object obj, Object obj2, Object obj3) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(obj, obj2, obj3)));
        }
    }

    public static void trace(Logger logger, String str, Object obj, Object obj2, Object obj3) {
        Level level = LogXF.TRACE;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(obj, obj2, obj3)));
        }
    }

    public static void warn(Logger logger, String str, Object obj, Object obj2, Object obj3) {
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(obj, obj2, obj3)));
        }
    }

    public static void debug(Logger logger, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.toArray(obj, obj2, obj3, obj4)));
        }
    }

    public static void info(Logger logger, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.toArray(obj, obj2, obj3, obj4)));
        }
    }

    public static void log(Logger logger, Level level, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(obj, obj2, obj3, obj4)));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(obj, obj2, obj3, obj4)));
        }
    }

    public static void trace(Logger logger, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        Level level = LogXF.TRACE;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(obj, obj2, obj3, obj4)));
        }
    }

    public static void warn(Logger logger, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        Level level = Level.WARN;
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(obj, obj2, obj3, obj4)));
        }
    }
}
