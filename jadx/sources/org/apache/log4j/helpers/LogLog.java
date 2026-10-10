package org.apache.log4j.helpers;

import java.io.PrintStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LogLog {
    public static final String CONFIG_DEBUG_KEY = "log4j.configDebug";
    public static final String DEBUG_KEY = "log4j.debug";
    private static final String ERR_PREFIX = "log4j:ERROR ";
    private static final String PREFIX = "log4j: ";
    private static final String WARN_PREFIX = "log4j:WARN ";
    protected static boolean debugEnabled;
    private static boolean quietMode;

    public static void debug(String str) {
        if (!debugEnabled || quietMode) {
            return;
        }
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(PREFIX);
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
    }

    public static void error(String str) {
        if (quietMode) {
            return;
        }
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ERR_PREFIX);
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
    }

    public static void warn(String str) {
        if (quietMode) {
            return;
        }
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(WARN_PREFIX);
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
    }

    static {
        String systemProperty = OptionConverter.getSystemProperty(DEBUG_KEY, null);
        if (systemProperty == null) {
            systemProperty = OptionConverter.getSystemProperty(CONFIG_DEBUG_KEY, null);
        }
        if (systemProperty != null) {
            debugEnabled = OptionConverter.toBoolean(systemProperty, true);
        }
    }

    public static void setInternalDebugging(boolean z10) {
        debugEnabled = z10;
    }

    public static void setQuietMode(boolean z10) {
        quietMode = z10;
    }

    public static void debug(String str, Throwable th) {
        if (!debugEnabled || quietMode) {
            return;
        }
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(PREFIX);
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
        if (th != null) {
            th.printStackTrace(System.out);
        }
    }

    public static void error(String str, Throwable th) {
        if (quietMode) {
            return;
        }
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ERR_PREFIX);
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
        if (th != null) {
            th.printStackTrace();
        }
    }

    public static void warn(String str, Throwable th) {
        if (quietMode) {
            return;
        }
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(WARN_PREFIX);
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
        if (th != null) {
            th.printStackTrace();
        }
    }
}
