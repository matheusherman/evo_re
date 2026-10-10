package org.apache.log4j.spi;

import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.log4j.Layout;
import org.apache.log4j.helpers.LogLog;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LocationInfo implements Serializable {
    static /* synthetic */ Class class$java$lang$Throwable = null;
    private static Method getClassNameMethod = null;
    private static Method getFileNameMethod = null;
    private static Method getLineNumberMethod = null;
    private static Method getMethodNameMethod = null;
    private static Method getStackTraceMethod = null;
    static boolean inVisualAge = false;
    static final long serialVersionUID = -1325822038990805636L;
    transient String className;
    transient String fileName;
    public String fullInfo;
    transient String lineNumber;
    transient String methodName;
    private static StringWriter sw = new StringWriter();
    private static PrintWriter pw = new PrintWriter(sw);
    public static final String NA = "?";
    public static final LocationInfo NA_LOCATION_INFO = new LocationInfo(NA, NA, NA, NA);

    public LocationInfo(Throwable th, String str) {
        String string;
        int i10;
        int iIndexOf;
        if (th == null || str == null) {
            return;
        }
        if (getLineNumberMethod != null) {
            try {
                Object[] objArr = (Object[]) getStackTraceMethod.invoke(th, null);
                String str2 = NA;
                int length = objArr.length - 1;
                while (length >= 0) {
                    String str3 = (String) getClassNameMethod.invoke(objArr[length], null);
                    if (str.equals(str3)) {
                        int i11 = length + 1;
                        if (i11 < objArr.length) {
                            this.className = str2;
                            this.methodName = (String) getMethodNameMethod.invoke(objArr[i11], null);
                            String str4 = (String) getFileNameMethod.invoke(objArr[i11], null);
                            this.fileName = str4;
                            if (str4 == null) {
                                this.fileName = NA;
                            }
                            int iIntValue = ((Integer) getLineNumberMethod.invoke(objArr[i11], null)).intValue();
                            if (iIntValue < 0) {
                                this.lineNumber = NA;
                            } else {
                                this.lineNumber = String.valueOf(iIntValue);
                            }
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(this.className);
                            stringBuffer.append(".");
                            stringBuffer.append(this.methodName);
                            stringBuffer.append("(");
                            stringBuffer.append(this.fileName);
                            stringBuffer.append(":");
                            stringBuffer.append(this.lineNumber);
                            stringBuffer.append(")");
                            this.fullInfo = stringBuffer.toString();
                            return;
                        }
                        return;
                    }
                    length--;
                    str2 = str3;
                }
                return;
            } catch (IllegalAccessException e10) {
                LogLog.debug("LocationInfo failed using JDK 1.4 methods", e10);
            } catch (RuntimeException e11) {
                LogLog.debug("LocationInfo failed using JDK 1.4 methods", e11);
            } catch (InvocationTargetException e12) {
                if ((e12.getTargetException() instanceof InterruptedException) || (e12.getTargetException() instanceof InterruptedIOException)) {
                    Thread.currentThread().interrupt();
                }
                LogLog.debug("LocationInfo failed using JDK 1.4 methods", e12);
            }
        }
        synchronized (sw) {
            th.printStackTrace(pw);
            string = sw.toString();
            sw.getBuffer().setLength(0);
        }
        int iLastIndexOf = string.lastIndexOf(str);
        if (iLastIndexOf == -1) {
            return;
        }
        if (str.length() + iLastIndexOf < string.length() && string.charAt(str.length() + iLastIndexOf) != '.') {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str);
            stringBuffer2.append(".");
            int iLastIndexOf2 = string.lastIndexOf(stringBuffer2.toString());
            if (iLastIndexOf2 != -1) {
                iLastIndexOf = iLastIndexOf2;
            }
        }
        String str5 = Layout.LINE_SEP;
        int iIndexOf2 = string.indexOf(str5, iLastIndexOf);
        if (iIndexOf2 == -1 || (iIndexOf = string.indexOf(str5, (i10 = iIndexOf2 + Layout.LINE_SEP_LEN))) == -1) {
            return;
        }
        if (!inVisualAge) {
            int iLastIndexOf3 = string.lastIndexOf("at ", iIndexOf);
            if (iLastIndexOf3 == -1) {
                return;
            } else {
                i10 = iLastIndexOf3 + 3;
            }
        }
        this.fullInfo = string.substring(i10, iIndexOf);
    }

    static {
        inVisualAge = false;
        try {
            Class.forName("com.ibm.uvm.tools.DebugSupport");
            inVisualAge = true;
            LogLog.debug("Detected IBM VisualAge environment.");
        } catch (Throwable unused) {
        }
        try {
            Class clsClass$ = class$java$lang$Throwable;
            if (clsClass$ == null) {
                clsClass$ = class$("java.lang.Throwable");
                class$java$lang$Throwable = clsClass$;
            }
            getStackTraceMethod = clsClass$.getMethod("getStackTrace", null);
            Class<?> cls = Class.forName("java.lang.StackTraceElement");
            getClassNameMethod = cls.getMethod("getClassName", null);
            getMethodNameMethod = cls.getMethod("getMethodName", null);
            getFileNameMethod = cls.getMethod("getFileName", null);
            getLineNumberMethod = cls.getMethod("getLineNumber", null);
        } catch (ClassNotFoundException unused2) {
            LogLog.debug("LocationInfo will use pre-JDK 1.4 methods to determine location.");
        } catch (NoSuchMethodException unused3) {
            LogLog.debug("LocationInfo will use pre-JDK 1.4 methods to determine location.");
        }
    }

    private static final void appendFragment(StringBuffer stringBuffer, String str) {
        if (str == null) {
            stringBuffer.append(NA);
        } else {
            stringBuffer.append(str);
        }
    }

    public String getClassName() {
        String str = this.fullInfo;
        if (str == null) {
            return NA;
        }
        if (this.className == null) {
            int iLastIndexOf = str.lastIndexOf(40);
            if (iLastIndexOf == -1) {
                this.className = NA;
            } else {
                int iLastIndexOf2 = this.fullInfo.lastIndexOf(46, iLastIndexOf);
                int iLastIndexOf3 = inVisualAge ? this.fullInfo.lastIndexOf(32, iLastIndexOf2) + 1 : 0;
                if (iLastIndexOf2 == -1) {
                    this.className = NA;
                } else {
                    this.className = this.fullInfo.substring(iLastIndexOf3, iLastIndexOf2);
                }
            }
        }
        return this.className;
    }

    public String getFileName() {
        String str = this.fullInfo;
        if (str == null) {
            return NA;
        }
        if (this.fileName == null) {
            int iLastIndexOf = str.lastIndexOf(58);
            if (iLastIndexOf == -1) {
                this.fileName = NA;
            } else {
                this.fileName = this.fullInfo.substring(this.fullInfo.lastIndexOf(40, iLastIndexOf - 1) + 1, iLastIndexOf);
            }
        }
        return this.fileName;
    }

    public String getLineNumber() {
        String str = this.fullInfo;
        if (str == null) {
            return NA;
        }
        if (this.lineNumber == null) {
            int iLastIndexOf = str.lastIndexOf(41);
            int iLastIndexOf2 = this.fullInfo.lastIndexOf(58, iLastIndexOf - 1);
            if (iLastIndexOf2 == -1) {
                this.lineNumber = NA;
            } else {
                this.lineNumber = this.fullInfo.substring(iLastIndexOf2 + 1, iLastIndexOf);
            }
        }
        return this.lineNumber;
    }

    public String getMethodName() {
        String str = this.fullInfo;
        if (str == null) {
            return NA;
        }
        if (this.methodName == null) {
            int iLastIndexOf = str.lastIndexOf(40);
            int iLastIndexOf2 = this.fullInfo.lastIndexOf(46, iLastIndexOf);
            if (iLastIndexOf2 == -1) {
                this.methodName = NA;
            } else {
                this.methodName = this.fullInfo.substring(iLastIndexOf2 + 1, iLastIndexOf);
            }
        }
        return this.methodName;
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    public LocationInfo(String str, String str2, String str3, String str4) {
        this.fileName = str;
        this.className = str2;
        this.methodName = str3;
        this.lineNumber = str4;
        StringBuffer stringBuffer = new StringBuffer();
        appendFragment(stringBuffer, str2);
        stringBuffer.append(".");
        appendFragment(stringBuffer, str3);
        stringBuffer.append("(");
        appendFragment(stringBuffer, str);
        stringBuffer.append(":");
        appendFragment(stringBuffer, str4);
        stringBuffer.append(")");
        this.fullInfo = stringBuffer.toString();
    }
}
