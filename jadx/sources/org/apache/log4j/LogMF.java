package org.apache.log4j;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class LogMF extends LogXF {
    private static final String FQCN;
    static /* synthetic */ Class class$org$apache$log4j$LogMF;
    private static DateFormat dateFormat;
    private static Locale dateLocale;
    private static NumberFormat numberFormat;
    private static Locale numberLocale;

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

    private static String format(String str, Object[] objArr) {
        if (str == null) {
            return null;
        }
        if (!isSimple(str)) {
            try {
                return MessageFormat.format(str, objArr);
            } catch (IllegalArgumentException unused) {
                return str;
            }
        }
        String[] strArr = new String[10];
        int iIndexOf = str.indexOf(123);
        int i10 = 0;
        String string = "";
        while (iIndexOf >= 0) {
            int i11 = iIndexOf + 2;
            if (i11 < str.length() && str.charAt(i11) == '}') {
                int i12 = iIndexOf + 1;
                if (str.charAt(i12) >= '0' && str.charAt(i12) <= '9') {
                    int iCharAt = str.charAt(i12) - '0';
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(string);
                    stringBuffer.append(str.substring(i10, iIndexOf));
                    String string2 = stringBuffer.toString();
                    if (strArr[iCharAt] == null) {
                        if (objArr == null || iCharAt >= objArr.length) {
                            strArr[iCharAt] = str.substring(iIndexOf, iIndexOf + 3);
                        } else {
                            strArr[iCharAt] = formatObject(objArr[iCharAt]);
                        }
                    }
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(string2);
                    stringBuffer2.append(strArr[iCharAt]);
                    string = stringBuffer2.toString();
                    i10 = iIndexOf + 3;
                    iIndexOf = str.indexOf(123, i10);
                }
            }
            iIndexOf = str.indexOf(123, iIndexOf + 1);
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(string);
        stringBuffer3.append(str.substring(i10));
        return stringBuffer3.toString();
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
        Class clsClass$ = class$org$apache$log4j$LogMF;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.LogMF");
            class$org$apache$log4j$LogMF = clsClass$;
        }
        FQCN = clsClass$.getName();
    }

    private static void forcedLog(Logger logger, Level level, String str, Throwable th) {
        logger.callAppenders(new LoggingEvent(FQCN, logger, level, str, th));
    }

    private static synchronized String formatDate(Object obj) {
        try {
            Locale locale = Locale.getDefault();
            if (locale != dateLocale || dateFormat == null) {
                dateLocale = locale;
                dateFormat = DateFormat.getDateTimeInstance(3, 3, locale);
            }
        } catch (Throwable th) {
            throw th;
        }
        return dateFormat.format(obj);
    }

    private static synchronized String formatNumber(Object obj) {
        try {
            Locale locale = Locale.getDefault();
            if (locale != numberLocale || numberFormat == null) {
                numberLocale = locale;
                numberFormat = NumberFormat.getInstance(locale);
            }
        } catch (Throwable th) {
            throw th;
        }
        return numberFormat.format(obj);
    }

    private static String formatObject(Object obj) {
        if (obj instanceof String) {
            return obj.toString();
        }
        if ((obj instanceof Double) || (obj instanceof Float)) {
            return formatNumber(obj);
        }
        return obj instanceof Date ? formatDate(obj) : String.valueOf(obj);
    }

    private static boolean isSimple(String str) {
        if (str.indexOf(39) != -1) {
            return false;
        }
        int iIndexOf = str.indexOf(123);
        while (iIndexOf != -1) {
            int i10 = iIndexOf + 2;
            if (i10 < str.length() && str.charAt(i10) == '}') {
                int i11 = iIndexOf + 1;
                if (str.charAt(i11) >= '0' && str.charAt(i11) <= '9') {
                    iIndexOf = str.indexOf(123, i11);
                }
            }
            return false;
        }
        return true;
    }

    private LogMF() {
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

    private static String format(String str, Object obj) {
        String string;
        String object = null;
        if (str == null) {
            return null;
        }
        int i10 = 0;
        if (!isSimple(str)) {
            try {
                return MessageFormat.format(str, obj);
            } catch (IllegalArgumentException unused) {
                return str;
            }
        }
        int iIndexOf = str.indexOf(123);
        String str2 = "";
        while (iIndexOf >= 0) {
            int i11 = iIndexOf + 2;
            if (i11 < str.length() && str.charAt(i11) == '}') {
                int i12 = iIndexOf + 1;
                if (str.charAt(i12) >= '0' && str.charAt(i12) <= '9') {
                    int iCharAt = str.charAt(i12) - '0';
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(str2);
                    stringBuffer.append(str.substring(i10, iIndexOf));
                    String string2 = stringBuffer.toString();
                    if (iCharAt != 0) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(string2);
                        stringBuffer2.append(str.substring(iIndexOf, iIndexOf + 3));
                        string = stringBuffer2.toString();
                    } else {
                        if (object == null) {
                            object = formatObject(obj);
                        }
                        StringBuffer stringBuffer3 = new StringBuffer();
                        stringBuffer3.append(string2);
                        stringBuffer3.append(object);
                        string = stringBuffer3.toString();
                    }
                    str2 = string;
                    i10 = iIndexOf + 3;
                    iIndexOf = str.indexOf(123, i10);
                }
            }
            iIndexOf = str.indexOf(123, iIndexOf + 1);
        }
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append(str2);
        stringBuffer4.append(str.substring(i10));
        return stringBuffer4.toString();
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

    private static String format(String str, String str2, Object[] objArr) {
        if (str != null) {
            try {
                str2 = ResourceBundle.getBundle(str).getString(str2);
            } catch (Exception unused) {
            }
        }
        return format(str2, objArr);
    }
}
