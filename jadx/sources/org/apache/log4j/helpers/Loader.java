package org.apache.log4j.helpers;

import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class Loader {
    static final String TSTR = "Caught Exception while in Loader.getResource. This may be innocuous.";
    static /* synthetic */ Class class$java$lang$Thread = null;
    static /* synthetic */ Class class$org$apache$log4j$helpers$Loader = null;
    private static boolean ignoreTCL = false;
    private static boolean java1 = true;

    public static URL getResource(String str, Class cls) {
        return getResource(str);
    }

    private static ClassLoader getTCL() throws Throwable {
        try {
            Class clsClass$ = class$java$lang$Thread;
            if (clsClass$ == null) {
                clsClass$ = class$("java.lang.Thread");
                class$java$lang$Thread = clsClass$;
            }
            return (ClassLoader) clsClass$.getMethod("getContextClassLoader", null).invoke(Thread.currentThread(), null);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    static {
        int iIndexOf;
        String systemProperty = OptionConverter.getSystemProperty("java.version", null);
        if (systemProperty != null && (iIndexOf = systemProperty.indexOf(46)) != -1 && systemProperty.charAt(iIndexOf + 1) != '1') {
            java1 = false;
        }
        String systemProperty2 = OptionConverter.getSystemProperty("log4j.ignoreTCL", null);
        if (systemProperty2 != null) {
            ignoreTCL = OptionConverter.toBoolean(systemProperty2, true);
        }
    }

    public static URL getResource(String str) {
        ClassLoader tcl;
        try {
            if (!java1 && !ignoreTCL && (tcl = getTCL()) != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Trying to find [");
                stringBuffer.append(str);
                stringBuffer.append("] using context classloader ");
                stringBuffer.append(tcl);
                stringBuffer.append(".");
                LogLog.debug(stringBuffer.toString());
                URL resource = tcl.getResource(str);
                if (resource != null) {
                    return resource;
                }
            }
            Class clsClass$ = class$org$apache$log4j$helpers$Loader;
            if (clsClass$ == null) {
                clsClass$ = class$("org.apache.log4j.helpers.Loader");
                class$org$apache$log4j$helpers$Loader = clsClass$;
            }
            ClassLoader classLoader = clsClass$.getClassLoader();
            if (classLoader != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Trying to find [");
                stringBuffer2.append(str);
                stringBuffer2.append("] using ");
                stringBuffer2.append(classLoader);
                stringBuffer2.append(" class loader.");
                LogLog.debug(stringBuffer2.toString());
                URL resource2 = classLoader.getResource(str);
                if (resource2 != null) {
                    return resource2;
                }
            }
        } catch (IllegalAccessException e10) {
            LogLog.warn(TSTR, e10);
        } catch (InvocationTargetException e11) {
            if ((e11.getTargetException() instanceof InterruptedException) || (e11.getTargetException() instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            LogLog.warn(TSTR, e11);
        } catch (Throwable th) {
            LogLog.warn(TSTR, th);
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Trying to find [");
        stringBuffer3.append(str);
        stringBuffer3.append("] using ClassLoader.getSystemResource().");
        LogLog.debug(stringBuffer3.toString());
        return ClassLoader.getSystemResource(str);
    }

    public static boolean isJava1() {
        return java1;
    }

    public static Class loadClass(String str) {
        if (java1 || ignoreTCL) {
            return Class.forName(str);
        }
        try {
            return getTCL().loadClass(str);
        } catch (InvocationTargetException e10) {
            if ((e10.getTargetException() instanceof InterruptedException) || (e10.getTargetException() instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            return Class.forName(str);
        } catch (Throwable unused) {
            return Class.forName(str);
        }
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }
}
