package org.apache.log4j.config;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.log4j.helpers.LogLog;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class PropertyGetter {
    protected static final Object[] NULL_ARG = new Object[0];
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$apache$log4j$Priority;
    protected Object obj;
    protected PropertyDescriptor[] props;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface PropertyCallback {
        void foundProperty(Object obj, String str, String str2, Object obj2);
    }

    public static void getProperties(Object obj, PropertyCallback propertyCallback, String str) {
        try {
            new PropertyGetter(obj).getProperties(propertyCallback, str);
        } catch (IntrospectionException e10) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Failed to introspect object ");
            stringBuffer.append(obj);
            LogLog.error(stringBuffer.toString(), e10);
        }
    }

    protected boolean isHandledType(Class cls) throws Throwable {
        Class clsClass$ = class$java$lang$String;
        if (clsClass$ == null) {
            clsClass$ = class$("java.lang.String");
            class$java$lang$String = clsClass$;
        }
        if (clsClass$.isAssignableFrom(cls) || Integer.TYPE.isAssignableFrom(cls) || Long.TYPE.isAssignableFrom(cls) || Boolean.TYPE.isAssignableFrom(cls)) {
            return true;
        }
        Class clsClass$2 = class$org$apache$log4j$Priority;
        if (clsClass$2 == null) {
            clsClass$2 = class$("org.apache.log4j.Priority");
            class$org$apache$log4j$Priority = clsClass$2;
        }
        return clsClass$2.isAssignableFrom(cls);
    }

    public PropertyGetter(Object obj) {
        this.props = Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors();
        this.obj = obj;
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    public void getProperties(PropertyCallback propertyCallback, String str) {
        int i10 = 0;
        while (true) {
            PropertyDescriptor[] propertyDescriptorArr = this.props;
            if (i10 >= propertyDescriptorArr.length) {
                return;
            }
            Method readMethod = propertyDescriptorArr[i10].getReadMethod();
            if (readMethod != null && isHandledType(readMethod.getReturnType())) {
                String name = this.props[i10].getName();
                try {
                    Object objInvoke = readMethod.invoke(this.obj, NULL_ARG);
                    if (objInvoke != null) {
                        propertyCallback.foundProperty(this.obj, str, name, objInvoke);
                    }
                } catch (IllegalAccessException unused) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Failed to get value of property ");
                    stringBuffer.append(name);
                    LogLog.warn(stringBuffer.toString());
                } catch (RuntimeException unused2) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Failed to get value of property ");
                    stringBuffer2.append(name);
                    LogLog.warn(stringBuffer2.toString());
                } catch (InvocationTargetException e10) {
                    if ((e10.getTargetException() instanceof InterruptedException) || (e10.getTargetException() instanceof InterruptedIOException)) {
                        Thread.currentThread().interrupt();
                    }
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Failed to get value of property ");
                    stringBuffer3.append(name);
                    LogLog.warn(stringBuffer3.toString());
                }
            }
            i10++;
        }
    }
}
