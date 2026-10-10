package org.apache.log4j.net;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.apache.log4j.helpers.LogLog;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ZeroConfSupport {
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$java$util$Hashtable;
    static /* synthetic */ Class class$java$util$Map;
    private static Object jmDNS = initializeJMDNS();
    private static Class jmDNSClass;
    private static Class serviceInfoClass;
    Object serviceInfo;

    public ZeroConfSupport(String str, int i10, String str2, Map map) {
        try {
            jmDNSClass.getMethod("create", null);
            LogLog.debug("using JmDNS version 3 to construct serviceInfo instance");
            this.serviceInfo = buildServiceInfoVersion3(str, i10, str2, map);
        } catch (NoSuchMethodException unused) {
            LogLog.debug("using JmDNS version 1.0 to construct serviceInfo instance");
            this.serviceInfo = buildServiceInfoVersion1(str, i10, str2, map);
        }
    }

    private static Object createJmDNSVersion3() {
        try {
            return jmDNSClass.getMethod("create", null).invoke(null, null);
        } catch (IllegalAccessException e10) {
            LogLog.warn("Unable to instantiate jmdns class", e10);
            return null;
        } catch (NoSuchMethodException e11) {
            LogLog.warn("Unable to access constructor", e11);
            return null;
        } catch (InvocationTargetException e12) {
            LogLog.warn("Unable to call constructor", e12);
            return null;
        }
    }

    private Object buildServiceInfoVersion1(String str, int i10, String str2, Map map) throws Throwable {
        Hashtable hashtable = new Hashtable(map);
        try {
            Class<?> clsClass$ = class$java$lang$String;
            if (clsClass$ == null) {
                clsClass$ = class$("java.lang.String");
                class$java$lang$String = clsClass$;
            }
            Class<?> clsClass$2 = class$java$lang$String;
            if (clsClass$2 == null) {
                clsClass$2 = class$("java.lang.String");
                class$java$lang$String = clsClass$2;
            }
            Class<?> clsClass$3 = class$java$util$Hashtable;
            if (clsClass$3 == null) {
                clsClass$3 = class$("java.util.Hashtable");
                class$java$util$Hashtable = clsClass$3;
            }
            Class<?> cls = Integer.TYPE;
            Object objNewInstance = serviceInfoClass.getConstructor(clsClass$, clsClass$2, cls, cls, cls, clsClass$3).newInstance(str, str2, new Integer(i10), new Integer(0), new Integer(0), hashtable);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("created serviceinfo: ");
            stringBuffer.append(objNewInstance);
            LogLog.debug(stringBuffer.toString());
            return objNewInstance;
        } catch (IllegalAccessException e10) {
            LogLog.warn("Unable to construct ServiceInfo instance", e10);
            return null;
        } catch (InstantiationException e11) {
            LogLog.warn("Unable to construct ServiceInfo instance", e11);
            return null;
        } catch (NoSuchMethodException e12) {
            LogLog.warn("Unable to get ServiceInfo constructor", e12);
            return null;
        } catch (InvocationTargetException e13) {
            LogLog.warn("Unable to construct ServiceInfo instance", e13);
            return null;
        }
    }

    private Object buildServiceInfoVersion3(String str, int i10, String str2, Map map) throws Throwable {
        try {
            Class<?> clsClass$ = class$java$lang$String;
            if (clsClass$ == null) {
                clsClass$ = class$("java.lang.String");
                class$java$lang$String = clsClass$;
            }
            Class<?> clsClass$2 = class$java$lang$String;
            if (clsClass$2 == null) {
                clsClass$2 = class$("java.lang.String");
                class$java$lang$String = clsClass$2;
            }
            Class<?> clsClass$3 = class$java$util$Map;
            if (clsClass$3 == null) {
                clsClass$3 = class$("java.util.Map");
                class$java$util$Map = clsClass$3;
            }
            Class<?> cls = Integer.TYPE;
            Object objInvoke = serviceInfoClass.getMethod("create", clsClass$, clsClass$2, cls, cls, cls, clsClass$3).invoke(null, str, str2, new Integer(i10), new Integer(0), new Integer(0), map);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("created serviceinfo: ");
            stringBuffer.append(objInvoke);
            LogLog.debug(stringBuffer.toString());
            return objInvoke;
        } catch (IllegalAccessException e10) {
            LogLog.warn("Unable to invoke create method", e10);
            return null;
        } catch (NoSuchMethodException e11) {
            LogLog.warn("Unable to find create method", e11);
            return null;
        } catch (InvocationTargetException e12) {
            LogLog.warn("Unable to invoke create method", e12);
            return null;
        }
    }

    private static Object createJmDNSVersion1() {
        try {
            return jmDNSClass.newInstance();
        } catch (IllegalAccessException e10) {
            LogLog.warn("Unable to instantiate JMDNS", e10);
            return null;
        } catch (InstantiationException e11) {
            LogLog.warn("Unable to instantiate JMDNS", e11);
            return null;
        }
    }

    public static Object getJMDNSInstance() {
        return jmDNS;
    }

    private static Object initializeJMDNS() {
        try {
            jmDNSClass = Class.forName("javax.jmdns.JmDNS");
            serviceInfoClass = Class.forName("javax.jmdns.ServiceInfo");
        } catch (ClassNotFoundException e10) {
            LogLog.warn("JmDNS or serviceInfo class not found", e10);
        }
        try {
            jmDNSClass.getMethod("create", null);
            return createJmDNSVersion3();
        } catch (NoSuchMethodException unused) {
            return createJmDNSVersion1();
        }
    }

    public void advertise() {
        try {
            jmDNSClass.getMethod("registerService", serviceInfoClass).invoke(jmDNS, this.serviceInfo);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("registered serviceInfo: ");
            stringBuffer.append(this.serviceInfo);
            LogLog.debug(stringBuffer.toString());
        } catch (IllegalAccessException e10) {
            LogLog.warn("Unable to invoke registerService method", e10);
        } catch (NoSuchMethodException e11) {
            LogLog.warn("No registerService method", e11);
        } catch (InvocationTargetException e12) {
            LogLog.warn("Unable to invoke registerService method", e12);
        }
    }

    public void unadvertise() {
        try {
            jmDNSClass.getMethod("unregisterService", serviceInfoClass).invoke(jmDNS, this.serviceInfo);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("unregistered serviceInfo: ");
            stringBuffer.append(this.serviceInfo);
            LogLog.debug(stringBuffer.toString());
        } catch (IllegalAccessException e10) {
            LogLog.warn("Unable to invoke unregisterService method", e10);
        } catch (NoSuchMethodException e11) {
            LogLog.warn("No unregisterService method", e11);
        } catch (InvocationTargetException e12) {
            LogLog.warn("Unable to invoke unregisterService method", e12);
        }
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    public ZeroConfSupport(String str, int i10, String str2) {
        this(str, i10, str2, new HashMap());
    }
}
